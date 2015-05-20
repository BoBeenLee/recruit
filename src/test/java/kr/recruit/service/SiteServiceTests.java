package kr.recruit.service;

import java.io.IOException;
import java.util.List;

import kr.recruit.RecruitApplication;
import kr.recruit.domain.Site;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RecruitApplication.class)
@WebAppConfiguration
public class SiteServiceTests {
	@Autowired
	private SiteService siteService;

	@Test
	@Ignore
	public void saveSite() {
		Site site = new Site();
		site.setName("로켓펀치");
		site.setUrl("http://rocketpun.ch/recruit/tag/%EA%B0%9C%EB%B0%9C%EC%9E%90/1/");
		site.setLocation(".hr_list");
		site.setKeyset("[\"회사명\",\"태그\"]");
		site.setValueset("[\" .hr_text_company\",\".tag_box\"]");

		siteService.saveSite(site);
	}

	@Test
	@Ignore
	public void findByName() {
		String name = "로켓펀치";
		Site site = siteService.findByName(name);

		assertNotNull(site);
	}

	@Test
	@Ignore
	public void saveSiteGroups() throws IOException {
		List<Site> sites = siteService.findAll();

		for (int i = 0; i < sites.size(); i++) {
			Site site = siteService.findByName(sites.get(i).getName());
			siteService.saveSiteGroups(site);
		}
	}
}
