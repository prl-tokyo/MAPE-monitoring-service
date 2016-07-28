package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Monitoring {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	private int hashCode;
	private String State;

	@JsonIgnore
	@OneToOne
	private Instance instance;
	
	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
	this.hashCode = hashCode;
	}
}
