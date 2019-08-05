package com.ferhat.user.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class Photo {

	@Id
	private String id;
	@NotNull
	private String albumId;
	@NotNull
	private String title;
	@NotNull
	private String url;
	@NotNull
	private String thumbnailUrl;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
}
