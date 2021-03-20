package xyz.walk8243.nogiprofile.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import xyz.walk8243.nogiprofile.model.SongsOnDisc;
import xyz.walk8243.nogiprofile.model.SongsOnDiscPK;

public interface SongsOnDiscRepository extends CrudRepository<SongsOnDisc, SongsOnDiscPK> {
	public List<SongsOnDisc> findBySongId(Integer songId);
	public List<SongsOnDisc> findByDiscographyId(Integer discographyId);
}
