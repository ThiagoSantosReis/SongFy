package com.myfavsongs.songfy.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SongDto(
        @JsonAlias("title") String title,
        @JsonAlias("duration") Long duration,
        @JsonAlias("rank") Long rank,
        @JsonAlias("explicit_lyrics") boolean explicit_lyrics,
        @JsonAlias("artist") ArtistDto artistDto


) {
    @Override
    public String toString() {
        return "SongDto{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", rank=" + rank +
                ", explicit_lyrics=" + explicit_lyrics +
                ", artistDto=" + artistDto +
                '}';
    }
}
