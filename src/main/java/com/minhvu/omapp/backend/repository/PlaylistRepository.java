package com.minhvu.omapp.backend.repository;

import com.minhvu.omapp.backend.model.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Playlist findPlaylistById(Long id);
}
