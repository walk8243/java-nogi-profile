package xyz.walk8243.nogiprofile.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import xyz.walk8243.nogiprofile.api.model.SongsOnDisc;
import xyz.walk8243.nogiprofile.api.model.SongsOnDiscPK;

public interface SongsOnDiscRepository extends CrudRepository<SongsOnDisc, SongsOnDiscPK> {
	public List<SongsOnDisc> findBySongId(Integer songId);
	public List<SongsOnDisc> findByDiscographyId(Integer discographyId);
}
