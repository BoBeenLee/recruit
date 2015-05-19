package kr.recruit.service;

import java.io.IOException;
import java.util.List;

import kr.recruit.domain.Site;
import kr.recruit.domain.SiteGroup;
import kr.recruit.domain.SiteMap;
import kr.recruit.repository.SiteMapRepository;

import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
