package jp.ac.nii.prl.mape.monitoring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instance {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	private String instID;
	
	private String instType;
	
	private String ami;
	
	private Integer state;
	
	private Integer instStatus;
	
	private String securityGroupRef;
	
	private String platform;
	
	@OneToMany(mappedBy="instance")
	private List<Tag> tags;
	
	private Date launchTime;
	


	private Double load;

	@JsonIgnore
	@ManyToOne
	private Model model;
	
	public String getPlatform() {
		return platform;
	}

	public String getAmi() {
		return ami;
	}

	public Long getId() {
		return id;
	}

	public String getInstID() {
		return instID;
	}

	public Integer getInstStatus() {
		return instStatus;
	}

	public String getInstType() {
		return instType;
	}

	public Double getLoad() {
		return load;
	}

	public Model getModel() {
		return model;
	}

	public String getSecurityGroupRef() {
		return securityGroupRef;
	}

	public Integer getState() {
		return state;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setAmi(String ami) {
		this.ami = ami;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstID(String instID) {
		this.instID = instID;
	}

	public void setInstStatus(Integer instStatus) {
		this.instStatus = instStatus;
	}

	public void setInstType(String instType) {
		this.instType = instType;
	}

	public void setLoad(Double load) {
		this.load = load;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setSecurityGroupRef(String securityGroupRef) {
		this.securityGroupRef = securityGroupRef;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public void setTags(List<Tag> tags) {
	// TODO Auto-generated method stub
		this.tags =  tags;
	}
	
	public Date getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}
	
	
}
