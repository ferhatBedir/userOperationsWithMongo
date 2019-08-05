package com.ferhat.user.model;

import com.ferhat.user.entity.Album;
import com.ferhat.user.entity.Photo;

import java.util.List;

public class AlbumWithDetail {

	private List<Album> albumList;
	private List<Photo> photoList;

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}
}
