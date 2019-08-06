package com.ferhat.user.controller;


import com.ferhat.user.entity.Album;
import com.ferhat.user.model.LogModel;
import com.ferhat.user.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userAlbums")
@Component
public class AlbumController {

	private AlbumService albumService;
	public static final Logger log = LoggerFactory.getLogger(AlbumController.class);
	private LogModel Q4 = new LogModel();

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
	public List<Album> findByUserId_Q4(@RequestParam(value = "id") String id) {
		Q4.setRequestType("GetMapping");
		Q4.setRequestCount(Q4.getRequestCount() + 1);
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

	@Scheduled(fixedRate = 10000)
	private void log() {
		log.info("Q4 Methoduna " + Q4.getRequestType() + " tipinde 10sn içerisinde toplam " + Q4.getRequestCount() + " adet istek yapılmıştır.");

		Q4.setRequestType("");
		Q4.setRequestCount(0);
	}
}
