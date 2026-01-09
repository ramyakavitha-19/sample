package com.example.mockAuth.service;

import com.example.mockAuth.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private static final Map<String, UserDto> USERS = new HashMap<>();

    static {
        USERS.put("TEST1", createUser("TEST1", "1", "C", "RUSER_SB"));
        USERS.put("TEST2", createUser("TEST2", "2", "S", "ADMIN_SB"));
        USERS.put("TEST3", createUser("TEST3", "3", "C", "VIEW_SB"));
        USERS.put("TEST4", createUser("TEST4", "4", "J", "JOINT_SB"));
    }

    private static UserDto createUser(String userId,
                                      String userType,
                                      String typeOfAccounts,
                                      String menuProfile) {

        UserDto user = new UserDto();
        user.setUserId(userId);
        user.setUserType(userType);
        user.setTypeOfAccounts(typeOfAccounts);
        user.setMenuProfile(menuProfile);
        return user;
    }

    public Object login(LoginRequest request) {

        // 1️⃣ Validate request
        if (request == null ||
                !StringUtils.hasText(request.getUsername()) ||
                !StringUtils.hasText(request.getPassword())) {

            return ErrorUtil.unauthorized();
        }

        // 2️⃣ Validate password
        if (!"password123".equals(request.getPassword())) {
            return ErrorUtil.unauthorized();
        }

        // 3️⃣ Validate user
        UserDto user = USERS.get(request.getUsername().toUpperCase());
        if (user == null) {
            return ErrorUtil.unauthorized();
        }

        // 4️⃣ Success response
        LoginResponse response = new LoginResponse();
        response.setTokenType("bearer");
        response.setToken(generateToken());
        response.setExpiresIn(3600);
        response.setUser(user);

        return response;
    }

    private String generateToken() {
        return "55f4b42da3a0cbd2094a39b87877bdccc84015839";
    }
}
