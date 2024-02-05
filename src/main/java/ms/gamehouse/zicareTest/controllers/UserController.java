package ms.gamehouse.zicareTest.controllers;

import ms.gamehouse.zicareTest.models.User;
import ms.gamehouse.zicareTest.payload.response.MessageResponse;
import ms.gamehouse.zicareTest.payload.response.UserInfoResponse;
import ms.gamehouse.zicareTest.repository.UserRepository;
import ms.gamehouse.zicareTest.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/me")
    public ResponseEntity<?> getUserProfile(@RequestHeader("Authorization") String bearerToken){
        String token = (bearerToken.split(" ").length > 1)? bearerToken.split(" ")[1]:bearerToken;
        if(jwtUtils.validateJwtToken(token)){
            Optional<User> user = userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(token));
            if(user.isPresent()){
                System.out.println("user : "+user.get().getFullName());
                List<String> roles = user.get().getRoles().stream()
                        .map(item -> item.getName().name())
                        .collect(Collectors.toList());

                return ResponseEntity.ok().body(
                        new UserInfoResponse(user.get().getId(),
                                user.get().getUsername(),
                                user.get().getFullName(),
                                user.get().getEmail(),
                                token, roles));
            }else{
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Token is not valid"));
        }
    }
}
