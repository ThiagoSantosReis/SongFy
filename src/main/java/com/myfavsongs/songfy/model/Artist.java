package com.myfavsongs.songfy.model;

import com.myfavsongs.songfy.model.dto.ArtistDto;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private Long id;
    private String name;
    private String link;
    private String picture;
    private List<Song> songs = new ArrayList<>();

    public Artist(){}

    public Artist(ArtistDto data){
        this.name = data.name();
        this.link = data.link();
        this.picture = data.picture();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString(){
        return """
                %s
                Link: %s
                Picture: %s
                """.formatted(name, link, picture);
    }

}
