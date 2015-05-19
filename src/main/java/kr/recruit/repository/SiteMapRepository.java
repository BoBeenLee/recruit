package kr.recruit.repository;

import java.util.List;

import kr.recruit.domain.SiteMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SiteMapRepository extends JpaRepository<SiteMap, Long> {
	@Query("SELECT sm IS NOT NULL FROM SiteMap sm WHERE sm.smKey = :smKey AND sm.smValue = :smValue")
	public Boolean isExistsByKeyAndValue(@Param("smKey") String smKey, @Param("smValue") String smValue);
}
