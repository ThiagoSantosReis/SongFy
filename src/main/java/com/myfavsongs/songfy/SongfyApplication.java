package com.myfavsongs.songfy;

import com.myfavsongs.songfy.model.Song;
import com.myfavsongs.songfy.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongfyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SongfyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.showMenu();
	}



}
