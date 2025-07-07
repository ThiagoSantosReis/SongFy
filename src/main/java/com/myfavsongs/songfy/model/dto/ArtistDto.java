package com.myfavsongs.songfy.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistDto(
        @JsonAlias("name") String name,
        @JsonAlias("link") String link,
        @JsonAlias("picture") String picture
) {

}
