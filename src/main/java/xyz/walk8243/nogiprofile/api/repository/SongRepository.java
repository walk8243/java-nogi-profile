package xyz.walk8243.nogiprofile.api.repository;

import org.springframework.data.repository.CrudRepository;

import xyz.walk8243.nogiprofile.api.model.Song;

public interface SongRepository extends CrudRepository<Song, Integer> {

}
