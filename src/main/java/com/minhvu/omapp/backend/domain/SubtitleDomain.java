package com.minhvu.omapp.backend.domain;

import com.minhvu.omapp.backend.exception.IDNotFoundException;
import com.minhvu.omapp.backend.model.Subtitle;
import com.minhvu.omapp.backend.repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SubtitleDomain {
    private String name;
    private String sub_url;
    private Long audio_id;

    public Subtitle toSubtitle(){
        return new Subtitle(this.name, this.sub_url);
    }

    public String getSub_url() {
        return sub_url;
    }

    public void setSub_url(String sub_url) {
        this.sub_url = sub_url;
    }

    public Long getAudio_id() {
        return audio_id;
    }

    public void setAudio_id(Long audio_id) {
        this.audio_id = audio_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
