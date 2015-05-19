package kr.recruit.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

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
