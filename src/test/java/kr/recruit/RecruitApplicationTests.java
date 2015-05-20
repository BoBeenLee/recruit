package kr.recruit;

import kr.recruit.repository.SiteRepository;

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
public class RecruitApplicationTests {
	@Autowired
	private SiteRepository siteRepository;
	
	@Test
	@Ignore
	public void insertSite(){
		// TODO
//		siteRepository.save(1)
	}
	
}
