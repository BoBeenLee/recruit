package kr.recruit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.recruit.domain.Site;
import kr.recruit.service.SiteGroupService;
import kr.recruit.service.SiteService;
import kr.recruit.util.HttpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class ScheduleConfig {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private static final String REQUEST_URL = "https://recruitdev.herokuapp.com/test/get";
	@Autowired
	private SiteService siteService;
	@Autowired
	private SiteGroupService siteGroupService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Scheduled( cron="0 0 2 * * *")
//	@Scheduled(fixedRate=5000)
	public void updateRecruit() {
		logger.info("The time is now " + dateFormat.format(new Date()) + " updateRecruit");
		
		List<Site> sites = siteService.findAll();
		
		for(int i=0; i<sites.size(); i++){
			siteGroupService.deleteByStId(sites.get(i).getStId());
			try {
				siteService.saveSiteGroups(sites.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Scheduled(fixedRate=1500000)
	public void repeatedRequest(){
//		logger.info("The time is now " + dateFormat.format(new Date()) + " repeatedRequest");
		logger.info("result : " + HttpUtils.getJson(restTemplate, REQUEST_URL, null));
	}
}
