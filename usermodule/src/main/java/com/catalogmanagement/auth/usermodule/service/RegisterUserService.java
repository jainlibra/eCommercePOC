package com.catalogmanagement.auth.usermodule.service;

import com.catalogmanagement.auth.usermodule.dao.StoreUserDetailsDao;
import com.catalogmanagement.auth.usermodule.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private StoreUserDetailsDao storeUserDetailsDao;

    /**
     * This method is used to store user in db.
     * @param user
     */
    public void registerUser(User user){
        storeUserDetailsDao.save(user);
    }
}
