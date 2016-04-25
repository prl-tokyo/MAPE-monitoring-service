package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FirewallRule {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	private String fwRuleID;
	
	private Boolean outbound;
	
	private String port;

	private String ip;

	private String protocol;

	private Integer fwStatus;

	@ManyToOne
	@JsonIgnore
	private SecurityGroup securityGroup;

	public String getFwRuleID() {
		return fwRuleID;
	}

	public Integer getFwStatus() {
		return fwStatus;
	}

	public Long getId() {
		return id;
	}

	public String getIp() {
		return ip;
	}

	public Boolean getOutbound() {
		return outbound;
	}

	public String getPort() {
		return port;
	}

	public String getProtocol() {
		return protocol;
	}

	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setFwRuleID(String fwRuleID) {
		this.fwRuleID = fwRuleID;
	}

	public void setFwStatus(Integer fwStatus) {
		this.fwStatus = fwStatus;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setOutbound(Boolean outbound) {
		this.outbound = outbound;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}
}
