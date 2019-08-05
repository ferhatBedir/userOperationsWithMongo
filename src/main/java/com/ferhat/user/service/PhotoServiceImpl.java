package com.ferhat.user.service;

import com.ferhat.user.entity.Photo;
import com.ferhat.user.model.AlbumWithDetail;
import com.ferhat.user.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

	private PhotoRepository photoRepository;

	@Autowired
	public PhotoServiceImpl(PhotoRepository photoRepository) {
		this.photoRepository = photoRepository;
	}


	@Override
	public void createPhotos(List<Photo> photoList) {
		photoList.forEach(photo -> photoRepository.save(photo));
	}

	@Override
	public List<Photo> findByAlbumId(String albumId) {
		return photoRepository.findOneByAlbumId(albumId);
	}


}
