package com.pixelprompt.entity;

import com.pixelprompt.enums.USER_PROFILE_VISIBILITY;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "daily_limit")
    private boolean dailyLimit;

    @Column(name = "total_photos_generated")
    private Integer totalPhotosGenerated;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile_visibility")
    private USER_PROFILE_VISIBILITY profileVisibility;

    @Column(name = "register_date")
    @CreationTimestamp
    private Timestamp registerDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Timestamp updateDate;

}
