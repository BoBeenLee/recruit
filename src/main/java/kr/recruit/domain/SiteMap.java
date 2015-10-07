package kr.recruit.domain;

import lombok.Data;

import javax.persistence.*;

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
