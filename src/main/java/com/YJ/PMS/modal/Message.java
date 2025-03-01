package com.YJ.PMS.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;
    public void setContent(String content) {
        this.content = content;
    }

    private LocalDateTime createdAt;
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @ManyToOne
    private Chat chat;
    public void setChat(Chat chat) {
        this.chat = chat;
    }

    @ManyToOne
    private User sender;
    public void setSender(User sender) {
        this.sender = sender;
    }
}
