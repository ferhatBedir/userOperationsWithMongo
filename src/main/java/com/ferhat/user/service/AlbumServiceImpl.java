package com.ferhat.user.service;


import com.ferhat.user.entity.Album;
import com.ferhat.user.repository.AlbumRepository;
import com.ferhat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

	private UserRepository userRepository;
	private AlbumRepository albumRepository;

	@Autowired
	public AlbumServiceImpl(UserRepository userRepository, AlbumRepository albumRepository) {
		this.userRepository = userRepository;
		this.albumRepository = albumRepository;
	}

	@Override
	public void createAlbums(List<Album> albumList) {
		albumList.forEach(album -> albumRepository.save(album));
	}

	@Override
	public List<Album> findByUserId(String id) {
		return albumRepository.findOneByUserId(id);
	}
}
