package com.desarrollo.luis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.security.AuthenticationRequest;
import com.desarrollo.luis.security.AuthenticationResponse;
import com.desarrollo.luis.security.JwtService;
import com.desarrollo.luis.security.UserService;

@RestController
public class RestLoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
    private UserService myUserDetailService;
	@Autowired
    private JwtService jwtService;
 
    @PostMapping("/login")
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsuario(), authenticationRequest.getContrasena());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        }
        UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsuario());
        String token = jwtService.createToken(userDetails);
        return new AuthenticationResponse(token);
    }
}
