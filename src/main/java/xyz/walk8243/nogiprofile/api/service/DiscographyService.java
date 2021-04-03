package xyz.walk8243.nogiprofile.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.walk8243.nogiprofile.api.model.Discography;
import xyz.walk8243.nogiprofile.api.model.DiscographyExInfo;
import xyz.walk8243.nogiprofile.api.model.SongsOnDisc;
import xyz.walk8243.nogiprofile.api.repository.DiscographyRepository;
import xyz.walk8243.nogiprofile.api.repository.SongsOnDiscRepository;
import xyz.walk8243.nogiprofile.api.util.ListUtil;

@Service
public class DiscographyService {
	@Autowired
	private DiscographyRepository discographyRepository;

	@Autowired
	private SongsOnDiscRepository songsOnDiscRepository;

	public List<Discography> getAll() {
		List<Discography> discs = ListUtil.convertFromIterable(discographyRepository.findAll());
		return discs;
	}

	public Optional<Discography> getById(Integer discId) {
		Optional<Discography> disc = discographyRepository.findById(discId);
		return disc;
	}

	public Optional<DiscographyExInfo> getDiscExInfoById(Integer discId) {
		Optional<Discography> disc = discographyRepository.findById(discId);
		if(disc.isPresent() == false) {
			return Optional.empty();
		}
		List<SongsOnDisc> songsOnDiscsList = songsOnDiscRepository.findByDiscographyId(discId);
		DiscographyExInfo info = new DiscographyExInfo(disc.get(), songsOnDiscsList);
		return Optional.of(info);
	}
}
