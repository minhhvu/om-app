package com.minhvu.omapp.backend.repository;

import com.minhvu.omapp.backend.model.Audio;
import org.springframework.data.repository.CrudRepository;

public interface AudioRepository extends CrudRepository<Audio, Long> {
    Audio findAudioById(Long id);
}
