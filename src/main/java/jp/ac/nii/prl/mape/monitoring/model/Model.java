package jp.ac.nii.prl.mape.monitoring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Model {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	@OneToMany(mappedBy="instance")
	private List<Instance> instance;
	
	@OneToMany(mappedBy="securityGroup")
	private List<SecurityGroup> securityGroups;

	@OneToMany(mappedBy="instanceType")
	private List<InstanceType> instanceTypes;

	public Long getId() {
		return id;
	}

	public List<Instance> getInstance() {
		return instance;
	}

	public List<InstanceType> getInstanceTypes() {
		return instanceTypes;
	}

	public List<SecurityGroup> getSecurityGroups() {
		return securityGroups;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstance(List<Instance> instance) {
		this.instance = instance;
	}

	public void setInstanceTypes(List<InstanceType> instanceTypes) {
		this.instanceTypes = instanceTypes;
	}
	
	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}
}
