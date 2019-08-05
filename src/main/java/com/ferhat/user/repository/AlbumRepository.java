package com.ferhat.user.repository;

import com.ferhat.user.entity.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlbumRepository extends MongoRepository<Album, String> {

	List<Album> findOneByUserId(String id);
}
