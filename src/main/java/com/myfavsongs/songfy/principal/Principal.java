package com.myfavsongs.songfy.principal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.myfavsongs.songfy.model.Artist;
import com.myfavsongs.songfy.model.Song;
import com.myfavsongs.songfy.model.dto.DeezerResponseDto;
import com.myfavsongs.songfy.model.dto.SongDto;
import com.myfavsongs.songfy.service.Converter;
import com.myfavsongs.songfy.service.DeezerApi;

import java.util.List;
import java.util.Scanner;

public class Principal {
    Converter converter = new Converter();
    private Scanner reader = new Scanner(System.in);
    private final String BASE_URL = "https://api.deezer.com/search?q=";

    public void showMenu(){
        
    }

    public void getSongData (){

    }

    public Song selectASong(){
        System.out.println("Enter song's name: ");
        String songToSearch = reader.nextLine();
        songToSearch = songToSearch.contains(" ") ?
                songToSearch.replaceAll(" ", "+") :
                songToSearch;
        String json = DeezerApi.getData(BASE_URL+songToSearch);
        DeezerResponseDto deezerResponse = converter.getData(json, DeezerResponseDto.class);
        List<SongDto> songDtos = deezerResponse.songDtoList();
        for (int i = 0; i < deezerResponse.songDtoList().size(); i++){
            System.out.println((i+1)+" - "+songDtos.get(i).title()+" by "+songDtos.get(i).artistDto().name());
        }

        System.out.println("Select song's index: ");
        int index = reader.nextInt();

        if(index < 0 || index > songDtos.size()){
            System.out.println("Invalid selection");
            return null;
        }

        Song song = new Song(songDtos.get(index));
        song.setArtist(new Artist(songDtos.get(index).artistDto()));
        return song;
    }

    //public void getSongData()
}
