package com.minhvu.omapp.backend.service;

import com.minhvu.omapp.backend.exception.IDNotFoundException;
import com.minhvu.omapp.backend.model.Audio;
import com.minhvu.omapp.backend.model.Subtitle;
import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.AudioRepository;
import com.minhvu.omapp.backend.repository.SubtitleRepository;
import com.minhvu.omapp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.Principal;

@Service
public class SubtitleService {
    private SubtitleRepository subtitleRepository;
    private AudioRepository audioRepository;
    private UserRepository userRepository;

    public SubtitleService(SubtitleRepository subtitleRepository, AudioRepository audioRepository, UserRepository userRepository) {
        this.subtitleRepository = subtitleRepository;
        this.audioRepository = audioRepository;
        this.userRepository = userRepository;
    }

    public Subtitle getSubtitle(Long id){
        return subtitleRepository.findById(id).orElseThrow(() -> new IDNotFoundException("Subtitle", id));
    }

    public Subtitle createSubtitle(Subtitle subtitle, User currentUser){

        subtitle.setUser(currentUser);

        Audio audio = subtitle.getAudio();
        if (audio == null) throw new IDNotFoundException("Audio", "Missing audio information");
        Long audio_id = audio.getId();
        audio = audioRepository.findAudioById(audio_id);
        if (!audioRepository.existsById(audio_id)) throw new IDNotFoundException("Audio", audio_id);
        subtitle.setAudio(audio);

        return subtitleRepository.save(subtitle);
    }

    public Subtitle updateSubtitle(Long id, Subtitle newSubtitle){
        return subtitleRepository.findById(id)
                .map(subtitle -> {
                    if (newSubtitle.getName() != null) subtitle.setName(newSubtitle.getName());
                    if (newSubtitle.getAudio() != null) subtitle.setAudio(newSubtitle.getAudio());
                    if (newSubtitle.getSub_url() != null) subtitle.setSub_url(newSubtitle.getSub_url());
                    System.out.println("-----------------------------------");
                    System.out.println(subtitle.toString());
                    return subtitleRepository.save(subtitle);
                })
                .orElseThrow(() -> new IDNotFoundException("Subtitle", id));

    }

    public void deleteSubtitle(Long id){
        subtitleRepository.findById(id)
                .map(sub -> {
                    subtitleRepository.deleteById(id);
                    return true;
                })
                .orElseThrow(() -> new IDNotFoundException("Subtitle", id));
    }
}
