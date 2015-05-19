package kr.recruit.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kr.recruit.Application;
import kr.recruit.domain.Site;
import kr.recruit.domain.SiteGroup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SiteGroupServiceTests {
	@Autowired
	private SiteGroupService siteGroupService;
	@Autowired
	private SiteService siteService;

	private Site site;

	@Before
	public void setUp() {
		String name = "광운대";
		site = siteService.findByName(name);
	}

	@Test
	public void findByStId() {
		List<SiteGroup> list = siteGroupService.findByStId(site.getStId());
		assertNotNull(list);
	}

	@Test
	public void findFirst10ByStIdOrderByCreatedDescGroupIdAsc() {
		List<SiteGroup> list = siteGroupService.findFirst10ByStIdOrderByCreatedDescGroupIdAsc(site.getStId());
		assertNotNull(list);
	}

//	@Test
//	@Ignore
	public void deleteByStIdAndGroupIdNotIn(Site site){
		List<Long> excludeGroupIdList = new ArrayList<Long>();
		
		List<SiteGroup> list = siteGroupService.findFirst10ByStIdOrderByCreatedDescGroupIdAsc(site.getStId());
		for(int i=0; i<list.size(); i++)
			excludeGroupIdList.add(list.get(i).getGroupId());
		System.out.println("excludeGroupIdList : " + excludeGroupIdList);
		
		siteGroupService.deleteByStIdAndGroupIdNotIn(site.getStId(), excludeGroupIdList);
	}
	
	@Test
	public void forEachDelete(){
		List<Site> sites = siteService.findAll();
		
		for(int i=0; i<sites.size(); i++)
			siteGroupService.deleteByStId(sites.get(i).getStId());
	}
	
}
