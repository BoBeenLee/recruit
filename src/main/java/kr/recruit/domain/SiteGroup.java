package kr.recruit.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "site_group")
@Data
public class SiteGroup {
	@Id
	@GeneratedValue
	@Column(name = "group_id")
	private long groupId;
	@Column(name = "st_id")
	private int stId;
	private Timestamp created;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "groupId", cascade = CascadeType.ALL)
	private List<SiteMap> siteMaps;
	
	@PrePersist
	public void onCreate() {
		created = new Timestamp((new Date()).getTime());
	}
}
