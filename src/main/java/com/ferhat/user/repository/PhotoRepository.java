package com.ferhat.user.repository;

import com.ferhat.user.entity.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository<Photo, String> {
	List<Photo> findOneByAlbumId(String albumId);
}
