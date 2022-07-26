package com.meetup.hotel_management_system.controller;

import com.meetup.hotel_management_system.constant.HmsConstants;
import com.meetup.hotel_management_system.dto.LoginDto;
import com.meetup.hotel_management_system.dto.LoginResponseDto;
import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.repository.UserRepository;
import com.meetup.hotel_management_system.service.JwtService;
import com.meetup.hotel_management_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    private final UserService userService;


    @PostMapping
    @Secured(HmsConstants.ROLE_MANAGER)
    public String createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return String.format("User with username %s was created and assigned role %s",
                userDto.getUsername()
                ,userDto.getRole().getName()
            );
    }

    @GetMapping
    @Secured(HmsConstants.ROLE_MANAGER)
    public List<UserDto> getAllUsers() {

        return userService.getAll();
    }

    @PermitAll
    @PostMapping({"/login"})
    public LoginResponseDto createJwtToken(@RequestBody LoginDto loginDto) throws Exception {
        return jwtService.createJwtToken(loginDto);

    }


    @DeleteMapping("/{id}")
    @Secured({HmsConstants.ROLE_MANAGER})
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteByUserId(id);
    }





//    @PatchMapping("/access/{userId}/{userRole}")
//    @Secured("ROLE_MANAGER")
////    @PreAuthorize("hasAuthority('ROLE_MANAGER') or hasAuthority('ROLE_STAFF')")
//    public String giveAccessToUser(@PathVariable int userId, @PathVariable String userRole, Principal principal) {
//        UserEntity userEntity = userRepository.findById(userId).get();
//        List<String> activeRoles = getRolesByLoggedInUser(principal);
//        String newRole = "";
//        if (activeRoles.contains(userRole)) {
//            newRole = userEntity.getRole() + "," + userRole;
//            userEntity.setRole(newRole);
//        }
//        userRepository.save(userEntity);
//        return userEntity.getUserName() + "New role assigned to you by" + principal.getName();
//    }
//    private List<String> getRolesByLoggedInUser(Principal principal) {
//        String roles = getLoggedInUser(principal).getRole();
//        List<String> assignRoles = Arrays.stream(roles.split(",")).collect(Collectors.toList());
//
//        if (assignRoles.contains("ROLE_MANAGER")) {
//            return Arrays.stream(UserConstant.MANAGER_ACCESS).collect(Collectors.toList());
//        }
//
//        if (assignRoles.contains("ROLE_STAFF")) {
//            return Arrays.stream(UserConstant.STAFF_ACCESS).collect(Collectors.toList());
//        }
//
//        return Collections.emptyList();
//
//    }
//
//    private UserEntity getLoggedInUser(Principal principal) {
//        return userRepository.findByUserName(principal.getName()).get();
//    }


}

