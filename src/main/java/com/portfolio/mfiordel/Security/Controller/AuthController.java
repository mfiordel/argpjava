package com.portfolio.mfiordel.Security.Controller;

import com.portfolio.mfiordel.Security.Dto.JwtDto;
import com.portfolio.mfiordel.Security.Dto.LoginUser;
import com.portfolio.mfiordel.Security.Dto.NewUser;
import com.portfolio.mfiordel.Security.Entity.Rol;
import com.portfolio.mfiordel.Security.Entity.User;
import com.portfolio.mfiordel.Security.Enums.RolName;
import com.portfolio.mfiordel.Security.JWT.JwtProvider;
import com.portfolio.mfiordel.Security.Service.RolService;
import com.portfolio.mfiordel.Security.Service.UserService;
import dto.Mensaje;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://mf-portfolio-arg-programa.web.app")
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
   
    @Autowired    
    UserService userService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
    if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensaje("campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
    if(userService.existsByNameUser(newUser.getNameUser()))
        return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
    if(userService.existsByEmail(newUser.getEmail()))
        return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
    User user = new User(newUser.getName(), newUser.getNameUser(),
            newUser.getEmail(), passwordEncoder.encode(newUser.getPassword())); 
    Set<Rol> roles = new HashSet<>();
    roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
    if(newUser.getRoles().contains("admin"))
        roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
    user.setRoles(roles);
    userService.save(user);
    return new ResponseEntity(new Mensaje("usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
         return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUser.getNameUser(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
