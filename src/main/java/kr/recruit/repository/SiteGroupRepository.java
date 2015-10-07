package kr.recruit.repository;

import kr.recruit.domain.SiteGroup;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

public interface SiteGroupRepository extends PagingAndSortingRepository<SiteGroup, Long> {
	List<SiteGroup> findByStId(int stId, Pageable pageable);
	List<SiteGroup> findFirst10ByStIdOrderByCreatedDescGroupIdAsc(int stId);
	
	@Transactional
	int deleteByStIdAndGroupIdNotIn(int stId, Collection<Long> groupIds);
	@Transactional
	int deleteByStId(int stId);
}
