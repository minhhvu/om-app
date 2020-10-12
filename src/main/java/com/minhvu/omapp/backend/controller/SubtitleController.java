package com.minhvu.omapp.backend.controller;

import com.minhvu.omapp.backend.model.Subtitle;
import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.SubtitleRepository;
import com.minhvu.omapp.backend.repository.UserRepository;
import com.minhvu.omapp.backend.service.SubtitleService;
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
    Iterable<Subtitle> getAllSubtitles(){
        return subtitleRepository.findAll();
    }

    @GetMapping("/{id}")
    Subtitle getSubtitle(@PathVariable Long id){

        return subtitleService.getSubtitle(id);
    }

    @PostMapping("")
    Subtitle createSubtitle(@RequestBody Subtitle subtitle, Principal principal){
        User currentUser = userRepository.findUserByGoogleSub(principal.getName());

        return subtitleService.createSubtitle(subtitle, currentUser);
    }

    @PutMapping("/{id}")
    Subtitle updateSubtitle(@PathVariable Long id, @RequestBody Subtitle subtitle){
        return subtitleService.updateSubtitle(id, subtitle);
    }

    @DeleteMapping("/{id}")
    void deleteSubtitle(@PathVariable Long id){
        subtitleService.deleteSubtitle(id);
    }

}
