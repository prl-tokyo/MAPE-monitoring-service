package jp.ac.nii.prl.mape.monitoring.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SecurityGroup {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	private String sgID;
	
	@ElementCollection
	private List<String> instRefs;
	
	@OneToMany(mappedBy="securityGroup")
	private List<FirewallRule> firewallRules;
	
	@ManyToOne
	@JsonIgnore
	private Model model;

	public List<FirewallRule> getFirewallRules() {
		return firewallRules;
	}

	public Long getId() {
		return id;
	}

	public List<String> getInstRefs() {
		return instRefs;
	}

	public Model getModel() {
		return model;
	}

	public String getSgID() {
		return sgID;
	}

	public void setFirewallRules(List<FirewallRule> firewallRules) {
		this.firewallRules = firewallRules;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstRefs(List<String> instRefs) {
		this.instRefs = instRefs;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setSgID(String sgID) {
		this.sgID = sgID;
	}
}
