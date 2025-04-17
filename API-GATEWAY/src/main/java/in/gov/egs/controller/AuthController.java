package in.gov.egs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gov.egs.payload.request.LoginRequest;
import in.gov.egs.security.jwt.JwtUtil;
import in.gov.egs.security.services.UserDetailsServiceImpl;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }
}