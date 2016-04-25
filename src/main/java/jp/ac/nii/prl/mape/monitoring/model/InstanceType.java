package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstanceType {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	private String typeID;
	
	private Integer typeCPUs;
	
	private Double typeRAM;
	
	private Double typeCost;
	
	@ManyToOne
	@JsonIgnore
	private Model model;

	public Long getId() {
		return id;
	}

	public Model getModel() {
		return model;
	}

	public Double getTypeCost() {
		return typeCost;
	}

	public Integer getTypeCPUs() {
		return typeCPUs;
	}

	public String getTypeID() {
		return typeID;
	}

	public Double getTypeRAM() {
		return typeRAM;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setTypeCost(Double typeCost) {
		this.typeCost = typeCost;
	}

	public void setTypeCPUs(Integer typeCPUs) {
		this.typeCPUs = typeCPUs;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public void setTypeRAM(Double typeRAM) {
		this.typeRAM = typeRAM;
	}
}
