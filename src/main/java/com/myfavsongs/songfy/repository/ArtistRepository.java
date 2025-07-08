package com.myfavsongs.songfy.repository;

import com.myfavsongs.songfy.model.Artist;
import com.myfavsongs.songfy.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByName(String name);
}
