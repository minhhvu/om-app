package com.minhvu.omapp.backend.repository;

import com.minhvu.omapp.backend.model.Subtitle;
import org.springframework.data.repository.CrudRepository;

public interface SubtitleRepository extends CrudRepository<Subtitle, Long> {
    Subtitle findSubtitleById(Long id);
}
