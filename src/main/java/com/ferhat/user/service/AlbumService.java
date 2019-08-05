package com.ferhat.user.service;

import com.ferhat.user.entity.Album;

import java.util.List;

public interface AlbumService {
	void createAlbums(List<Album> albumList);

	List<Album> findByUserId(String id);
}
