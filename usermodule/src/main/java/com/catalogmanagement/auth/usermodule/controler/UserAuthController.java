package com.catalogmanagement.auth.usermodule.controler;
/**
 * This is the controller used for User Authentication.
 * All the user Request of controller class passed here.
 */

import com.catalogmanagement.auth.usermodule.dao.StoreUserDetailsDao;
import com.catalogmanagement.auth.usermodule.model.UserTokenRequest;
import com.catalogmanagement.auth.usermodule.model.UserTokenResponse;
import com.catalogmanagement.auth.usermodule.service.JWTUserDetailsService;
import com.catalogmanagement.auth.usermodule.service.RegisterUserService;
import com.catalogmanagement.auth.usermodule.util.JwtTokenUtil;
import com.catalogmanagement.auth.usermodule.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserAuthController {

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/registeruser")
    public void registerUser(@RequestBody User user){
        registerUserService.registerUser(user);
    }


    /**
     * This is for create authentication request.
     * @param authenticationRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserTokenRequest authenticationRequest) throws Exception {

       // authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new UserTokenResponse(token));
    }

    /**
     * This method is used to return username from the token.
     * @param token
     * @return
     */
    @GetMapping("/getusernametoken")
    public UserDetails getUserFromToken(String token){
        String username=jwtTokenUtil.getUsernameFromToken(token);
        UserDetails userDetails= userDetailsService.loadUserByUsername(username);
        return userDetails;
    }

    /**
     *
     * @param token
     * @param userDetails
     * @return
     */
    @GetMapping("/validatetoken")
    public Boolean validateToken(String token, UserDetails userDetails){
        return jwtTokenUtil.validateToken(token, userDetails);
    }

    /**
     * authenticate method for authentication.
     * @param username
     * @param password
     * @throws Exception
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }





}
