package com.minhvu.omapp.backend.config;

import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        //Check and create the new account from the principal detail
        String principalString = authentication.getPrincipal().toString();
        Pattern pattern = Pattern.compile("(.*)(User Attributes:)(.*)(sub=)(.*)(, name=)(.*)(, given_name=.*)(email=)(.*)(, email_verified.*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(principalString);
        if (matcher.find()) {
            String sub = matcher.group(5);
            String name = matcher.group(7);
            String email = matcher.group(10);

            //In case of the new account, store this account into db
            if (!userRepository.existsUserByEmail(email)) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setGoogleSub(sub);
                user.setRole(authentication.getAuthorities().toString());
                userRepository.save(user);
            }

        } else {
            System.out.println("Failed to extract google account detail.");
        }

        boolean admin = false;

        response.sendRedirect("/api/users/all");

    }
}
