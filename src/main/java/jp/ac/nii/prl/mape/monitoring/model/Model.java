package jp.ac.nii.prl.mape.monitoring.model;

import java.util.ArrayList;
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
	private List<Instance> instances = new ArrayList<>();
	
	@OneToMany(mappedBy="model")
	private List<SecurityGroup> securityGroups = new ArrayList<>();

	@OneToMany(mappedBy="model")
	private List<InstanceType> instanceTypes = new ArrayList<>();
	
	public void addInstance(Instance instance) {
		instances.add(instance);
	}
	
	public void addInstanceType(InstanceType instanceType) {
		instanceTypes.add(instanceType);
	}
	
	public void addSecurityGroups(SecurityGroup securityGroup) {
		securityGroups.add(securityGroup);
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
