package com.ferhat.user.controller;

import com.ferhat.user.entity.Album;
import com.ferhat.user.entity.Photo;
import com.ferhat.user.model.AlbumWithDetail;
import com.ferhat.user.service.AlbumService;
import com.ferhat.user.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userAlbumsWithDetails")
public class PhotoController {

	private PhotoService photoService;
	private AlbumService albumService;

	@Autowired
	public PhotoController(PhotoService photoService, AlbumService albumService) {
		this.photoService = photoService;
		this.albumService = albumService;
	}

	@PostMapping("/create")
	public void createPhotos(@RequestBody @Valid List<Photo> photoList,
	                         BindingResult bindingResult,
	                         HttpServletResponse httpServletResponse) throws IOException {
		if (bindingResult.hasErrors()) {
			httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameters invalid..");
		} else {
			photoService.createPhotos(photoList);
		}
	}

	@PutMapping()
	public AlbumWithDetail findByUserId_Q5(@RequestParam(value = "userId") String userId) {
		AlbumWithDetail albumWithDetail = new AlbumWithDetail();
		List<Album> albumList;
		List<Photo> photoList;
		try {
			albumList = albumService.findByUserId(userId);
			if (albumList == null || albumList.isEmpty()) {
				throw new Exception("Sisteme kayıtlı album ve resim bulunamadı.");
			}else {
				photoList = photoService.findByAlbumId(albumList.get(0).getId());
				albumWithDetail.setAlbumList(albumList);
				albumWithDetail.setPhotoList(photoList);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return albumWithDetail;
	}
}
