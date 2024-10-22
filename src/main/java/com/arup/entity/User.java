package com.arup.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_users")
public class User {

    @Id
    @Tsid
    private Long id;

    private String username;

    private String password;
    private String email;

    private String firstName;
    private String lastName;
    private String mobile;
}
