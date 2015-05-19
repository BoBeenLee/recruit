package kr.recruit.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import kr.recruit.util.JacksonUtils;
import lombok.Data;

@Entity
@Data
public class Site {
	@Id
	@GeneratedValue
	@Column(name = "st_id")
	private int stId;
	private String name;
	private String url;
	private String location;
	private String keyset;
	private String valueset;

	@Transient
	public List<String> keyCollection;
	@Transient
	public List<String> valueCollection;

	public void setKeyset(List<String> keyset) {
		this.keyset = JacksonUtils.objectToJson(keyset);
	}

	public void setValueset(List<String> valueset) {
		this.valueset = JacksonUtils.objectToJson(valueset);
	}

	public void setKeyset(String keyset) {
		this.keyset = JacksonUtils.objectToJson(keyset.split(","));
	}

	public void setValueset(String valueset) {
		this.valueset = JacksonUtils.objectToJson(valueset.split(","));
	}
	
	public List<String> getKeyCollection() {
		if (keyset == null)
			return null;
		if (keyCollection == null)
			this.keyCollection = JacksonUtils.jsonToObject(keyset, List.class);
		return keyCollection;
	}

	public List<String> getValueCollection() {
		if (valueset == null)
			return null;
		if (valueCollection == null)
			this.valueCollection = JacksonUtils.jsonToObject(valueset, List.class);
		return valueCollection;
	}
}
