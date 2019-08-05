package com.ferhat.user.controller;


import com.ferhat.user.entity.Album;
import com.ferhat.user.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userAlbums")
public class AlbumController {

	private AlbumService albumService;

	@Autowired
	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}

	@PostMapping("/create")
	public void createAlbums(@RequestBody @Valid List<Album> albumList,
	                         BindingResult bindingResult,
	                         HttpServletResponse httpServletResponse) throws IOException {
		if (bindingResult.hasErrors()) {
			httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameters invalid..");
		} else {
			albumService.createAlbums(albumList);
		}
	}

	@PutMapping()
	public List<Album> findByUserId_Q5(@RequestParam(value = "id") String id) {
		List<Album> albumList = new ArrayList<>();
		try {
			albumList = albumService.findByUserId(id);
			if (albumList == null || albumList.isEmpty()) {
				throw new Exception("Sisteme kayıtlı album bulunamadı.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return albumList;
	}
}
