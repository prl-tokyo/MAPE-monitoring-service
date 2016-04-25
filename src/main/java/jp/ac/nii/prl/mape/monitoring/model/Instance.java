package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	private Double load;

	@JsonIgnore
	@ManyToOne
	private Model model;

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
	
}
