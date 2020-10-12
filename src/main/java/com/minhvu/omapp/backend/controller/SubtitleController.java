package com.minhvu.omapp.backend.controller;

import com.minhvu.omapp.backend.domain.SubtitleDomain;
import com.minhvu.omapp.backend.exception.IDNotFoundException;
import com.minhvu.omapp.backend.model.Audio;
import com.minhvu.omapp.backend.model.Subtitle;
import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.AudioRepository;
import com.minhvu.omapp.backend.repository.SubtitleRepository;
import com.minhvu.omapp.backend.repository.UserRepository;
import com.minhvu.omapp.backend.service.SubtitleService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/subtitle")
public class SubtitleController {

    @Autowired
    private SubtitleRepository subtitleRepository;

    @Autowired
    private SubtitleService subtitleService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<Subtitle> getAllSubtitles(){
        return subtitleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subtitle getSubtitle(@PathVariable Long id){
        if(!subtitleRepository.existsById(id))
            throw new IDNotFoundException("Subtitle", id);
        return subtitleRepository.findSubtitleById(id);
    }

    @PostMapping("")
    public Subtitle createSubtitle(@RequestBody Subtitle subtitle, Principal principal){
        User currentUser = userRepository.findUserByGoogleSub(principal.getName());

        return subtitleService.createSubtitle(subtitle, currentUser);
    }

    @PostMapping("/test")
    public Subtitle create(@RequestBody Subtitle subtitle){
        System.out.println(subtitle.toString());

        return null;
    }

}
