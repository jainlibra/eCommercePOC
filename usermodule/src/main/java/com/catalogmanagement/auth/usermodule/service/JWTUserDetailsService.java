package com.catalogmanagement.auth.usermodule.service;

import com.catalogmanagement.auth.usermodule.dao.StoreUserDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;

@Service
public class JWTUserDetailsService implements UserDetailsService {
    @Autowired
    private StoreUserDetailsDao storeUserDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         com.catalogmanagement.auth.usermodule.util.User users = storeUserDetailsDao.findByName(username);
        if (null!=users && null!=users.getName()) {
            return new User(users.getName(), "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        }
        else if(username.equals("guest")){
            return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
