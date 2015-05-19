package kr.recruit.repository;

import kr.recruit.domain.Site;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository  extends JpaRepository<Site, Integer> {
	Site findByName(String name);
}
