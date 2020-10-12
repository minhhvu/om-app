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
}
