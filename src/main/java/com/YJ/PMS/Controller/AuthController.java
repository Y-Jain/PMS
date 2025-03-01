package com.YJ.PMS.Controller;

import com.YJ.PMS.config.AppConfig.JwtProvider;
import com.YJ.PMS.modal.User;
import com.YJ.PMS.repository.UserRepository;
import com.YJ.PMS.request.LoginRequest;
import com.YJ.PMS.response.AuthResponse;
import com.YJ.PMS.service.CustomUserDetailsImpl;
import com.YJ.PMS.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsImpl customUserDetails;

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/signup")
    public ResponseEntity<User>createUserHandler(@RequestBody User user) throws Exception {
        User isUserExist=userRepository.findByEmail(user.getEmail());

        if(isUserExist!=null){
            throw new Exception("email already exist with another account");
        }

        User createdUser=new User();
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setEmail(user.getEmail());
        createdUser.setFullName(user.getFullName());

        User savedUser = userRepository.save(createdUser);

        subscriptionService.createSubscription(savedUser);


        Authentication authentication= new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt= JwtProvider.generateToken(authentication);

        AuthResponse res=new AuthResponse();
        res.setMessage("Signup Success");
        res.setJwt(jwt);


        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/signing")
    public ResponseEntity<AuthResponse> signing(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authentication authentication= authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt= JwtProvider.generateToken(authentication);

        AuthResponse res=new AuthResponse();
        res.setMessage("Signin Success");
        res.setJwt(jwt);


        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    private Authentication authenticate(String username, String password) {

        UserDetails userDetails=customUserDetails.loadUserByUsername(username);
        if(userDetails== null){
            throw new BadCredentialsException("invalid username");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("invalid password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

}
