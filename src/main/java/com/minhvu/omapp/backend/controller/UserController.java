package com.minhvu.omapp.backend.controller;

import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/signup")
    public String signup(){
        User user = new User();
        user.setEmail("abc@admin.com");
        user.setName("abc");
        userRepository.save(user);
        return "saved";
    }

    @GetMapping("/test")
    public String test(){
        return "abc";
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public Principal getUser(Principal principal){
        return principal;
    }

    @GetMapping
    public String getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());
        //...

        String userInfoEndpointUri = client.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUri();

        return "loginSuccess";
    }

}
