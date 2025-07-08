package com.myfavsongs.songfy.model;

import com.myfavsongs.songfy.model.dto.SongDto;
import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long duration;
    private Long rank;
    private Boolean explicit_lyrics;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Song(){}

    public Song(SongDto data){
        this.title = data.title();
        this.duration = data.duration();
        this.rank = data.rank();
        this.explicit_lyrics = data.explicit_lyrics();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Boolean getExplicit_lyrics() {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics(Boolean explicit_lyrics) {
        this.explicit_lyrics = explicit_lyrics;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString(){
        return """
                %s
                duration: %d
                rank: %d
                Has explicit lyrics? %b
                Artist: %s
                """.formatted(title, duration, rank, explicit_lyrics, artist);
    }

}
