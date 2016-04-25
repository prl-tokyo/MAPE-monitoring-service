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
	
	@OneToMany(mappedBy="model")
	private List<Instance> instances;
	
	@OneToMany(mappedBy="model")
	private List<SecurityGroup> securityGroups;

	@OneToMany(mappedBy="model")
	private List<InstanceType> instanceTypes;
	
	public void addInstance(Instance instance) {
		instances.add(instance);
	}

	public Long getId() {
		return id;
	}

	public List<Instance> getInstances() {
		return instances;
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

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	public void setInstanceTypes(List<InstanceType> instanceTypes) {
		this.instanceTypes = instanceTypes;
	}
	
	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}
}
