package com.YJ.PMS.service;

import com.YJ.PMS.modal.User;

public interface UserService {
    User findUserProfileByJwt(String jwt)throws Exception;
    User findUserByEmail(String email)throws Exception;
    User findUserById(Long id)throws Exception;
    User updateUserProjectSize(User user, int number);
}
