package jp.ac.nii.prl.mape.monitoring.properties;

public class InstanceTypeProperty {
	private String typeID;
	private Integer typeCPUs;
	private Double typeRAM;
	private Double typeCost;

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public Integer getTypeCPUs() {
		return typeCPUs;
	}

	public void setTypeCPUs(Integer typeCPUs) {
		this.typeCPUs = typeCPUs;
	}

	public Double getTypeRAM() {
		return typeRAM;
	}

	public void setTypeRAM(Double typeRAM) {
		this.typeRAM = typeRAM;
	}

	public Double getTypeCost() {
		return typeCost;
	}

	public void setTypeCost(Double typeCost) {
		this.typeCost = typeCost;
	}
}