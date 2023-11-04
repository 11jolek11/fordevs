package com.dev.fordevs.security.service;

import com.dev.fordevs.security.model.User;
import com.dev.fordevs.security.repository.UserRepository;
import com.dev.fordevs.security.service.utils.AuthenticationRequest;
import com.dev.fordevs.security.service.utils.AuthenticationResponse;
import com.dev.fordevs.security.service.utils.RegisterRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(JwtService jwtService, PasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .name(registerRequest.getName())
                .password(registerRequest.getPassword())
                .email(registerRequest.getEmail())
                .role(registerRequest.getRole())
                .specialization(registerRequest.getSpecialization())
        .build();

        this.userRepository.save(user);

        String accessToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(accessToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        var user = this.userRepository.findUserByEmail(authenticationRequest.getEmail()).orElseThrow();

        String accessToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(accessToken)
                .build();
    }
}
