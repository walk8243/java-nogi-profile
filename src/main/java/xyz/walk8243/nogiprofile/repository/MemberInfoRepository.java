package xyz.walk8243.nogiprofile.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import xyz.walk8243.nogiprofile.model.MemberInfo;

public interface MemberInfoRepository extends CrudRepository<MemberInfo, Integer> {
	public List<MemberInfo> findByMemberClass(Integer memberClass);
}
