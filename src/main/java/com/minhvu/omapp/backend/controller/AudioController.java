package com.minhvu.omapp.backend.controller;

import com.minhvu.omapp.backend.model.Audio;
import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.AudioRepository;
import com.minhvu.omapp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/audio")
public class AudioController {

    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<Audio> getAllAudios(){
        return audioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Audio getAudio(@PathVariable Long id){
        System.out.println(id);
        System.out.println(audioRepository.findAudioById(id));
        return audioRepository.findAudioById(id);
    }

    @PostMapping("")
    public Audio createAudio(@RequestBody Audio newAudio, Principal principal){
        User currentUser = userRepository.findUserByGoogleSub(principal.getName());
        newAudio.setUser(currentUser);
        return audioRepository.save(newAudio);
    }

    @GetMapping("/test")
    public User test(Principal principal){
        User user = userRepository.findUserByGoogleSub(principal.getName());
        return user;
    }

}
