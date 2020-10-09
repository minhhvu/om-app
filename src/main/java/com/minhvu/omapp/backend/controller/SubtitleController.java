package com.minhvu.omapp.backend.controller;

import com.minhvu.omapp.backend.domain.SubtitleDomain;
import com.minhvu.omapp.backend.model.Subtitle;
import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.AudioRepository;
import com.minhvu.omapp.backend.repository.SubtitleRepository;
import com.minhvu.omapp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/subtitle")
public class SubtitleController {

    @Autowired
    private SubtitleRepository subtitleRepository;

    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<Subtitle> getAllSubtitles(){
        return subtitleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subtitle getSubtitle(@PathVariable Long id){
        return subtitleRepository.findSubtitleById(id);
    }

    @PostMapping("")
    public Subtitle createSubtitle(@RequestBody SubtitleDomain subtitleDomain, Principal principal){
        Subtitle newSubtitle = subtitleDomain.toSubtitle();
        User currentUser = userRepository.findUserByGoogleSub(principal.getName());
        newSubtitle.setUser(currentUser);
        newSubtitle.setAudio(audioRepository.findAudioById(subtitleDomain.getAudio_id()));
        return subtitleRepository.save(newSubtitle);
    }

}
