package com.example.springbootspringsecuritywithjwt.service;

import com.example.springbootspringsecuritywithjwt.domain.Role;
import com.example.springbootspringsecuritywithjwt.domain.User;
import com.example.springbootspringsecuritywithjwt.repository.RoleRepository;
import com.example.springbootspringsecuritywithjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.rmi.server.LogStream.log;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    @Override
    public User saveUser(User user) {
       // log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
       // log.info("Saving new role {} to the database",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        //log.info("Adding role {} to use {}",roleName,username);
     User user = userRepo.findByUsername(username);
     Role role = roleRepo.findByName(roleName);
     user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
