package com.musicstore;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicstore.model.Song;
import com.musicstore.service.SongService;

@Controller
public class SongController {

	private SongService songService;

	@Autowired(required = true)
	@Qualifier(value = "songService")
	public void setSongService(SongService ps) {
		this.songService = ps;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String display(Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/viewSongs", method = RequestMethod.GET)
	public String getSongsListPage(Model model) {

		model.addAttribute("songs", songService.listSongs());
		return "songsList";		
	}

	@RequestMapping(value = "/getAddSongPage", method = RequestMethod.GET)
	public String getAddSongPage(Model model) {

		model.addAttribute("newSong", new Song());
		return "addSong";
	}

	@RequestMapping(value = "/addSong", method = RequestMethod.POST)
	public String addSong(@ModelAttribute("newSong") @Valid Song song, BindingResult result,
			Model model) {

		if(result.hasErrors())
		{
			return "addSong";
		}
		
		try{
		songService.addSong(song);
		}catch(Exception ex){			
			model.addAttribute("error","The name and artist pair you entered already exists");
		    return "addSong";
		}
		return "redirect:/viewSongs/";
	}

	@RequestMapping(value = "/editSong/{id}", method = RequestMethod.GET)
	public String getEditSongPage(@PathVariable("id") int id, Model model) {

		Song song = songService.getSongById(id);
		model.addAttribute("song", song);
		return "editSong";
	}

	@RequestMapping(value = "/updateSong", method = RequestMethod.POST)
	public String updateSong(@ModelAttribute("song") @Valid Song song,
			Model model) {

		songService.updateSong(song);

		model.addAttribute("songs", songService.listSongs());
		return "redirect:/viewSongs";
	}

	@RequestMapping("/removeSong/{id}")
	public String removeSong(@PathVariable("id") int id) {

		this.songService.removeSong(id);
		return "redirect:/viewSongs/";
	}

	@RequestMapping(value = "/searchSong", method = RequestMethod.GET)
	public String searchSong(@RequestParam("criteria") String criteria,
			Model model) {
		List<Song> songs = songService.findSongs(criteria);
		model.addAttribute("songs", songs);
		return "songsList";
	}

}