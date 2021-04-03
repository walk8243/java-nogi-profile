package xyz.walk8243.nogiprofile.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.walk8243.nogiprofile.api.model.MemberInfo;
import xyz.walk8243.nogiprofile.api.repository.MemberInfoRepository;
import xyz.walk8243.nogiprofile.api.util.ListUtil;

@Service
public class MemberService {
	@Autowired
	MemberInfoRepository memberInfoRepository;

	public List<MemberInfo> getAll() {
		List<MemberInfo> members = ListUtil.convertFromIterable(memberInfoRepository.findAll());
		return members;
	}

	public List<MemberInfo> getAllByClass(Integer memberClass) {
		List<MemberInfo> members = ListUtil.convertFromIterable(memberInfoRepository.findByMemberClass(memberClass));
		return members;
	}
}
