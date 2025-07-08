package com.myfavsongs.songfy.repository;

import com.myfavsongs.songfy.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Song, Long> {
}
