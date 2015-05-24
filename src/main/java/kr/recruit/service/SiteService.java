package kr.recruit.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.recruit.domain.Site;
import kr.recruit.domain.SiteGroup;
import kr.recruit.domain.SiteMap;
import kr.recruit.repository.SiteRepository;

import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private SiteGroupService siteGroupService;
	@Autowired
	private SiteMapService siteMapService;

	public void saveSite(Site site) {
		siteRepository.save(site);
	}

	public void deleteById(int id) {
		siteRepository.delete(id);
	}

	public List<Site> findAll() {
		return siteRepository.findAll();
	}

	public Site findById(int id) {
		return siteRepository.findOne(id);
	}

	public Site findByName(String name) {
		return siteRepository.findByName(name);
	}

	@Transactional
	public void saveSiteGroups(Site site) throws IOException {
		SiteMap siteMap = null;

		// URL
		Connection con = HttpConnection.connect(site.getUrl());
		Document doc = con.get();

		// Location
		Elements elements = doc.select(site.getLocation());

		int count = 0;
		
		for (Element elem : elements) {
			if(count >= 10)
				break;

			List<SiteMap> siteMaps = new ArrayList<SiteMap>();
			boolean isExist = true;
			
			count += 1;
			for (int i = 0; i < site.getKeyCollection().size(); i++) {
				siteMap = new SiteMap();
				siteMap.setSmKey(site.getKeyCollection().get(i));
				siteMap.setSmValue(elem.select(site.getValueCollection().get(i)).html());
				if (!siteMapService.isExistsByKeyAndValue(siteMap.getSmKey(), siteMap.getSmValue()))
					isExist = false;
				siteMaps.add(siteMap);
			}
			
			if(!isExist){
				SiteGroup siteGroup = siteGroupService.saveSiteGroup(site.getStId());
				for (int i = 0; i < siteMaps.size(); i++){
					siteMaps.get(i).setGroupId(siteGroup.getGroupId());
					siteMapService.saveSiteMap(siteMaps.get(i));
				}
			}
		}
	}
}
