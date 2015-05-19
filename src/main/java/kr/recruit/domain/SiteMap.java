package kr.recruit.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "site_map")
@Data
public class SiteMap {
	@Id
	@GeneratedValue
	@Column(name = "sm_id")
	private long smId;
	@Column(name = "group_id")
	private long groupId;
	@Column(name = "sm_key")
	private String smKey;
	@Column(name = "sm_value")
	private String smValue;
}
