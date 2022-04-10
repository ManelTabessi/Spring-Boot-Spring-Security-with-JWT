package com.example.springbootspringsecuritywithjwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    /*here we need to define the fetch because when i fetch all these users
     or when i load them i want also load the roles of user.
    ==>load all the roles whenever loading the user */
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles= new ArrayList<>();
}
