package kr.recruit.domain;

import kr.recruit.util.JacksonUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
	@Column(name = "s_key")
	private String sKey;
	@Column(name = "s_value")
	private String sValue;

	@Transient
	public List<String> keyCollection;
	@Transient
	public List<String> valueCollection;

	public void setsKey(List<String> sKey) {
		this.sKey = JacksonUtils.objectToJson(sKey);
	}

	public void setsValue(List<String> sValue) {
		this.sValue = JacksonUtils.objectToJson(sValue);
	}

	public void setKeyset(String keyset) {
		this.sKey = JacksonUtils.objectToJson(keyset.split(","));
	}

	public void setValueset(String valueset) {
		this.sValue = JacksonUtils.objectToJson(valueset.split(","));
	}
	
	public List<String> getKeyCollection() {
		if (sKey == null)
			return null;
		if (keyCollection == null)
			this.keyCollection = JacksonUtils.jsonToObject(sKey, List.class);
		return keyCollection;
	}

	public List<String> getValueCollection() {
		if (sValue == null)
			return null;
		if (valueCollection == null)
			this.valueCollection = JacksonUtils.jsonToObject(sValue, List.class);
		return valueCollection;
	}
}
