package com.minhvu.omapp.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "audios")
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String audio_url;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    //Constructors
    Audio(){}

    Audio(String name, String audio_url){
        this.name = name;
        this.audio_url = audio_url;
    }

    //Getters and Setters
    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
