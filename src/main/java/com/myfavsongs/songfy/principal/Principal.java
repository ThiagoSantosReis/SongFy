package com.myfavsongs.songfy.principal;

import com.myfavsongs.songfy.service.Converter;
import com.myfavsongs.songfy.service.DeezerApi;

import java.util.Scanner;

public class Principal {
    Converter converter = new Converter();
    private Scanner reader = new Scanner(System.in);
    private final String BASE_URL = "https://api.deezer.com/search?q=";

    public void showMenu(){
        System.out.println("Enter song's name: ");
        String songToSearch = reader.nextLine();
        songToSearch = songToSearch.contains(" ") ?
                songToSearch.replaceAll(" ", "+") :
                songToSearch;
        String json = DeezerApi.getData(BASE_URL+songToSearch);
        System.out.println(json);
    }
}
