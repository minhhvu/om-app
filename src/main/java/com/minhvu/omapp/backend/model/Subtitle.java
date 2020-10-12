package com.minhvu.omapp.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "subtitles")
public class Subtitle {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String sub_url;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "audio_id", nullable = false)
    private Audio audio;

    public Subtitle(){}

    public Subtitle(String name, String sub_url){
        this.name = name;
        this.sub_url = sub_url;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub_url() {
        return sub_url;
    }

    public void setSub_url(String sub_url) {
        this.sub_url = sub_url;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "Subtitle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sub_url='" + sub_url + '\'' +
                ", user=" + user +
                ", audio=" + audio +
                '}';
    }
}
