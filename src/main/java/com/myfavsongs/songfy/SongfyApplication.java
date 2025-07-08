package com.myfavsongs.songfy;

import com.myfavsongs.songfy.model.Song;
import com.myfavsongs.songfy.principal.Principal;
import com.myfavsongs.songfy.repository.ArtistRepository;
import com.myfavsongs.songfy.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongfyApplication implements CommandLineRunner {

	@Autowired
	ArtistRepository artistRepository;
	@Autowired
	SongRepository songRepository;

	public static void main(String[] args) {
		SpringApplication.run(SongfyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(songRepository, artistRepository);
		principal.showMenu();
	}



}
