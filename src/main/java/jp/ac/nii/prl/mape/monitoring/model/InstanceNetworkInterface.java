package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstanceNetworkInterface {
	@Id
	@GeneratedValue
	@JsonIgnore
	private long id;
	private String description;
	private String macAddress;
	private String networkInterfaceId;
	private Boolean SourceDestCheck;
	
	@ManyToOne
	@JsonIgnore
	private Instance instance;
	
	public Instance getInstance() {
		return instance;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getNetworkInterfaceId() {
		return networkInterfaceId;
	}
	public void setNetworkInterfaceId(String networkInterfaceId) {
		this.networkInterfaceId = networkInterfaceId;
	}
	public Boolean getSourceDestCheck() {
		return SourceDestCheck;
	}
	public void setSourceDestCheck(Boolean sourceDestCheck) {
		SourceDestCheck = sourceDestCheck;
	}

	

}
