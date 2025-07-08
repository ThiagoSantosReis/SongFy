package com.myfavsongs.songfy.repository;

import com.myfavsongs.songfy.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTitleAndArtistName(String title, String name);

    @Query("SELECT s FROM Song s JOIN s.artist a WHERE LOWER(a.name) = LOWER(:artistName)")
    List<Song> findSongsByArtist(String artistName);

    Optional<Song> findByTitleContainingIgnoreCase(String name);

    @Query("SELECT s FROM Song s WHERE s.duration BETWEEN :min AND :max")
    List<Song> findByDurationBetween(int min, int max);

    @Query("SELECT COUNT(s) FROM Song s WHERE LOWER(s.artist.name) = LOWER(:name)")
    Long countByArtist(String name);

    List<Song> findByOrderByRankDesc();
}
