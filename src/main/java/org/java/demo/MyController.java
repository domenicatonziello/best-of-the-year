package org.java.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {
	
	private List<Movie> bestMovies(){
		List<Movie> movieList = new ArrayList<>();
		Movie movie1 = new Movie(1, "film1");
		Movie movie2 = new Movie(2, "film2");
		movieList.add(movie1);
		movieList.add(movie2);
		return movieList;
	}
	private List<Song> bestSongs(){
		List<Song> songList = new ArrayList<>();
		Song song1 = new Song(1, "song1");
		Song song2 = new Song(2, "song2");
		songList.add(song1);
		songList.add(song2);
		return songList;
	}


	
	@GetMapping("/")
	public String getHome(Model model) {
		String name = "Domenica";
		
		model.addAttribute("name",name);
		return "index";
	}
	
	
	@GetMapping("/movies")
	public String getMovies(Model model) {

//		String list = "";
		List<Movie> movies = bestMovies();

//		for(int i = 0; i<movies.size(); i++) {
//			
//			if (i < movies.size()-1) {
//				list += movies.get(i).getTitolo() + ", ";
//			} else {
//				list += movies.get(i).getTitolo() + ".";
//			}
//		}

		model.addAttribute("movies", movies);

		return "movies";
	}
	
	
	@GetMapping("/songs")
	public String getSongs(Model model) {

//		String list = "";
		List<Song> songs = bestSongs();

//		for(int i = 0; i < songs.size(); i++) {
//			
//			if (i < songs.size()-1) {
//				list += songs.get(i).getTitolo() + ", ";
//			} else {
//				list += songs.get(i).getTitolo() + ".";
//			}
//		}

		model.addAttribute("songs", songs);

		return "songs";
	}
	@GetMapping("/movies/{id}")
	public String getMovieDetail(Model model, @PathVariable("id") int id) {
		
		List<Movie> movies = bestMovies();
		Movie movie = null;
		
		for(int i = 0; i < movies.size(); i++) {
			if(id == movies.get(i).getId()) {
				movie = movies.get(i);
				break;
			}
		}
		
		model.addAttribute("movie", movie);
		
		return "MovieDetail";
	}
	
	@GetMapping("/songs/{id}")
	public String getSongDetail(Model model, @PathVariable("id") int id) {
		
		List<Song> songs = bestSongs();
		Song song = null;
		
		for(int i = 0; i<songs.size(); i++) {
			if(id == songs.get(i).getId()) {
				song = songs.get(i);
				break;
			}
		}
		
		model.addAttribute("song", song);
		
		return "SongDetail";
	}
	

}
