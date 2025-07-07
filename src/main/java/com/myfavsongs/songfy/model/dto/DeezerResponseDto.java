package com.myfavsongs.songfy.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeezerResponseDto(
        @JsonAlias("data") List<SongDto> songDtoList
) {
}
