package com.ferhat.user.service;

import com.ferhat.user.entity.Photo;
import com.ferhat.user.model.AlbumWithDetail;

import java.util.List;

public interface PhotoService {
	void createPhotos(List<Photo> photoList);

	List<Photo> findByAlbumId(String albumId);
}
