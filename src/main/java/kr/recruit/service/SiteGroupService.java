package kr.recruit.service;

import java.util.Collection;
import java.util.List;

import kr.recruit.domain.SiteGroup;
import kr.recruit.repository.SiteGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SiteGroupService {
	@Autowired
	private SiteGroupRepository siteGroupRepository;
	
	public SiteGroup saveSiteGroup(int stId) {
		SiteGroup siteGroup = new SiteGroup();
		siteGroup.setStId(stId);
		return siteGroupRepository.save(siteGroup);
	}
	
	public List<SiteGroup> findByStId(int stId) {
		int page, size;
		Sort sort = null;
		
		page = 0; size = 10;
		Pageable pageable = new PageRequest(page, size, sort);
		
		return siteGroupRepository.findByStId(stId, pageable);
	}
	
	public int deleteByStId(int stId){
		return siteGroupRepository.deleteByStId(stId);
	}
	
	
	public List<SiteGroup> findFirst10ByStIdOrderByCreatedDescGroupIdAsc(int stId){
		return siteGroupRepository.findFirst10ByStIdOrderByCreatedDescGroupIdAsc(stId);
	}
	

	public void deleteByStIdAndGroupIdNotIn(int stId, Collection<Long> groupIds) {
		siteGroupRepository.deleteByStIdAndGroupIdNotIn(stId, groupIds);
	}
}
