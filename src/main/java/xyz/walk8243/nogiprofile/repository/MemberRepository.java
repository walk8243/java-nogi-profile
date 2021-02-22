package xyz.walk8243.nogiprofile.repository;

import org.springframework.data.repository.CrudRepository;

import xyz.walk8243.nogiprofile.model.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {
	
}
