package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
public class CommentPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    private Timestamp comment_date;
    private String content;
    private String noti;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "appUser_id")
    private AppUser appUser;

    public void setNoti(String noti) {
        this.noti = appUser.getName() + "just commented on your post!";
    }
}
