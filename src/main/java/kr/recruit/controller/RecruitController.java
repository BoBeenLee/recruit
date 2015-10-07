package kr.recruit.controller;

import kr.recruit.domain.Site;
import kr.recruit.domain.SiteGroup;
import kr.recruit.service.SiteGroupService;
import kr.recruit.service.SiteMapService;
import kr.recruit.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/recruit")
public class RecruitController {
	private static final Logger logger = LoggerFactory.getLogger(RecruitController.class);
	@Autowired
	private SiteService siteService;
	@Autowired
	private SiteMapService siteMapService;
	@Autowired
	private SiteGroupService siteGroupService;

	@RequestMapping(value = "")
	public ModelAndView viewSites(Model model) {
		ModelAndView mv = new ModelAndView();

		List<Site> sites = siteService.findAll();
		model.addAttribute("sites", sites);

		mv.setViewName("/site/main");
		return mv;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> ajaxSiteMaps(@RequestParam int id) throws IOException {
		List<SiteGroup> siteGroups = siteGroupService.findByStId(id);
		Site site = siteService.findById(id);

		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("siteGroups", siteGroups);
		response.put("site", site);
		return response;
	}

	@RequestMapping(value = "/manage/{code}")
	public String processSite(@PathVariable String code, @ModelAttribute Site site, Model model) {
		String url = "redirect:/recruit/main";

		// logger.info("processSite : " + site);

		if (code.equals("add")) {
			if (site.getName() == null)
				url = "/site/" + code;
			else {
				siteService.saveSite(site);
			}
		} else if (code.equals("remove")) {
			siteService.deleteById(site.getStId());
		} else if (code.equals("list")) {
			model.addAttribute("sites", siteService.findAll());
			url = "/site/" + code;
		}
		return url;
	}
	
	@RequestMapping(value="/update/site")
	public void updateSite() {
		List<Site> sites = siteService.findAll();

		for (int i = 0; i < sites.size(); i++) {
			Site site = sites.get(i);
			try {
				siteGroupService.deleteByStId(site.getStId());
				siteService.saveSiteGroups(site);
			} catch (IOException e) {
			}
		}
	}
}



