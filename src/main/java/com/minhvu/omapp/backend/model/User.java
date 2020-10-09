package com.minhvu.omapp.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String role;

    private String name;

    private String email;

    private String googleSub;

//    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    private List<Playlist> playlists;

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoogleSub() {
        return googleSub;
    }

    public void setGoogleSub(String sub) {
        this.googleSub = sub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<Playlist> getPlaylists() {
//        return playlists;
//    }

//    public void setPlaylists(List<Playlist> playlists) {
//        this.playlists = playlists;
//    }
//
//    public void addPlaylist(Playlist tempPlaylist){
//        if (playlists == null) {
//            playlists = new ArrayList<>();
//        }
//
//        playlists.add(tempPlaylist);
//
//        tempPlaylist.setUser(this);
//    }
}
