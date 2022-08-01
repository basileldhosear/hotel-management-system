package com.meetup.hotel_management_system.service;


import com.meetup.hotel_management_system.dto.LoginDto;
import com.meetup.hotel_management_system.dto.LoginResponseDto;
import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.exception.ResourceNotFoundException;
import com.meetup.hotel_management_system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("jwtService")
public class JwtService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    public LoginResponseDto createJwtToken(LoginDto loginDto) throws Exception {

        UserDto userDto = userService.validateAndGetUser(loginDto);
        if (userDto != null) {

            final UserDetails userDetails = loadUserByUsername(userDto.getUsername());
            return new LoginResponseDto(jwtUtil.generateToken(userDetails));
        }
        else {

           // throw new ResourceNotFoundException("Bad credintails from the user");

            return LoginResponseDto.builder()

                    .token("Bad credentials from the user")
                    .build();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = null;
        try {
            userDto = userService.getByUserName(username);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (userDto != null) {
            return new org.springframework.security.core.userdetails.User(
                    userDto.getUsername(),
                    userDto.getPassword(),
                    getAuthorities(userDto)

            );
        } else {
            throw new UsernameNotFoundException("User name is not valid");
        }
    }

    private Set getAuthorities(UserDto userDto) {
        Set authorities = new HashSet();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userDto.getRole().getName()));
        return authorities;
    }


    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials from the user");
        }


    }

}
