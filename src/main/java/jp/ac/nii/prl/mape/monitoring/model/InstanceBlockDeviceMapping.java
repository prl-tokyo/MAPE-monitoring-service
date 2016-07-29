package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstanceBlockDeviceMapping {

	@Id
	@GeneratedValue
	private long id;
	private String deviceName;
	private int hashCode;
	
	@ManyToOne
	@JsonIgnore
	private Instance instance;
	
	public Instance getInstance() {
		return instance;
	}

	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	
	
}
