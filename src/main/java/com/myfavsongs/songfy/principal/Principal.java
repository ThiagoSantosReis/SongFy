package com.myfavsongs.songfy.principal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.myfavsongs.songfy.model.Artist;
import com.myfavsongs.songfy.model.Song;
import com.myfavsongs.songfy.model.dto.DeezerResponseDto;
import com.myfavsongs.songfy.model.dto.SongDto;
import com.myfavsongs.songfy.repository.ArtistRepository;
import com.myfavsongs.songfy.repository.SongRepository;
import com.myfavsongs.songfy.service.Converter;
import com.myfavsongs.songfy.service.DeezerApi;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    SongRepository songRepository;
    ArtistRepository artistRepository;

    Converter converter = new Converter();
    private Scanner reader = new Scanner(System.in);
    private final String BASE_URL = "https://api.deezer.com/search?q=";

    public Principal(SongRepository songRepository, ArtistRepository artistRepository){
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    public void showMenu(){
        String menu = """
                0. Exit
                1. Register a song
                2. List all songs
                3. List all songs by given artist
                """;
        int option = -1;

        while(option != 0){
            System.out.println(menu);
            System.out.print("Enter an option: ");
            option = Integer.parseInt(reader.nextLine());

            if(option == 0){
                System.out.println("Exiting...");
                break;
            }

            switch (option){
                case 1:
                    getSongData();
                break;
                case 2:
                    listAllSongs();
                case 3:
                    listAllSongsByGivenArtist();
                break;
                default:
                    System.out.println("Invalid option!");
            }
        }

    }

    private void listAllSongsByGivenArtist() {
        System.out.println("Enter an artist: ");
        String artistName = reader.nextLine();
        List<Song> songs = songRepository.findSongsByArtist(artistName);
        System.out.println("All songs by: "+artistName.toUpperCase());
        songs.forEach(s -> System.out.println(s.getTitle()));
    }

    private void listAllSongs() {
        List<Song> songs = songRepository.findAll();
        songs.forEach(s -> System.out.println(s.getTitle() + " by " + s.getArtist().getName()));
    }

    public void getSongData (){
        Song song = selectASong();
        Optional<Song> existingSong = songRepository.findByTitleAndArtistName(song.getTitle(), song.getArtist().getName());
        Optional<Artist> existingArtist = artistRepository.findByName(song.getArtist().getName());

        if (existingArtist.isEmpty()){
            artistRepository.save(song.getArtist());
        }else{
            song.setArtist(existingArtist.get());
        }

        if(existingSong.isPresent()){
            System.out.println("This song is already in the database.");

        }else{
            songRepository.save(song);
        }

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
        int index = Integer.parseInt(reader.nextLine());
        index -=1;

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
