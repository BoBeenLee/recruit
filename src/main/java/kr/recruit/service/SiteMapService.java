package kr.recruit.service;

import kr.recruit.domain.SiteMap;
import kr.recruit.repository.SiteMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteMapService {
	@Autowired
	private SiteMapRepository siteMapRepository;
	
	public void saveSiteMap(SiteMap siteMap) {
		siteMapRepository.save(siteMap);
	}
	
	public boolean isExistsByKeyAndValue(String key, String value){
		Boolean isExists = siteMapRepository.isExistsByKeyAndValue(key, value);
		return (isExists == null) ? false : isExists;
	}
}
