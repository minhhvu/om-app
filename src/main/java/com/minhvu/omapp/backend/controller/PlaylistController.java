package com.minhvu.omapp.backend.controller;

import com.minhvu.omapp.backend.model.Playlist;
import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.PlaylistRepository;
import com.minhvu.omapp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable Long id){
        System.out.println(id);
        System.out.println(playlistRepository.findPlaylistById(id));
        return playlistRepository.findPlaylistById(id);
    }

    @PostMapping("")
    public Playlist createPlaylist(@RequestBody Playlist newPlaylist, Principal principal){
        User currentUser = userRepository.findUserByGoogleSub(principal.getName());
        newPlaylist.setUser(currentUser);
        return playlistRepository.save(newPlaylist);
    }

    @GetMapping("/test")
    public User test(Principal principal){
        User user = userRepository.findUserByGoogleSub(principal.getName());
        return user;
    }

}
