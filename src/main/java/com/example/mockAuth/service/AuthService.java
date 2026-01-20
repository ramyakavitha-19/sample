package com.example.mockAuth.service;

import com.example.mockAuth.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class AuthService {

    private static final Map<String, UserDto> USERS = new HashMap<>();

    // ✅ SAME TOKEN USED IN LOGIN & SEND OTP
    private static final String VALID_TOKEN =
            "55f4b42da3a0cbd2094a39b87877bdccc84015839";

    private static final Set<String> VALID_TOKENS = Set.of(VALID_TOKEN);

    static {
        USERS.put("TEST1", createUser("TEST1", "1", "C", "RUSER_SB"));
        USERS.put("TEST2", createUser("TEST2", "2", "S", "ADMIN_SB"));
        USERS.put("TEST3", createUser("TEST3", "3", "C", "VIEW_SB"));
        USERS.put("TEST4", createUser("TEST4", "4", "J", "JOINT_SB"));
    }

    private static UserDto createUser(String userId, String userType,
                                      String typeOfAccounts, String menuProfile) {
        UserDto user = new UserDto();
        user.setUserId(userId);
        user.setUserType(userType);
        user.setTypeOfAccounts(typeOfAccounts);
        user.setMenuProfile(menuProfile);
        return user;
    }

    // ================= LOGIN =================
    public Object login(LoginRequest request) {

        if (request == null ||
                !StringUtils.hasText(request.getUsername()) ||
                !StringUtils.hasText(request.getPassword())) {
            return ErrorUtil.unauthorized();
        }

        if (!"password123".equals(request.getPassword())) {
            return ErrorUtil.unauthorized();
        }

        UserDto user = USERS.get(request.getUsername().toUpperCase());
        if (user == null) {
            return ErrorUtil.unauthorized();
        }

        LoginResponse response = new LoginResponse();
        response.setTokenType("bearer");
        response.setToken(VALID_TOKEN);
        response.setExpiresIn(3600);
        response.setUser(user);

        return response;
    }

    // ================= SEND OTP =================
    public Object sendOtp(String authorization, SendOtpRequest request) {

        if (!StringUtils.hasText(authorization) || request == null
                || !StringUtils.hasText(request.getUserId())) {
            return ErrorUtil.unauthorized();
        }

        // ✅ Handle "Bearer <token>"
        String token = authorization;
        if (authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);
        }

        if (!VALID_TOKENS.contains(token)) {
            return ErrorUtil.unauthorized();
        }

        return new SendOtpResponse("123456");
    }


}
