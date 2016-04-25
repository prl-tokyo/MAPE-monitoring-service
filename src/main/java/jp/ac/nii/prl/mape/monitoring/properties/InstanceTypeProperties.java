package jp.ac.nii.prl.mape.monitoring.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.instance-types")
public class InstanceTypeProperties {
	
	public class InstanceTypeProperty {
		
		private String typeID;
		
		private Integer typeCPUs;
		
		private Double typeRAM;
		
		private Double typeCost;

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
	
	private List<InstanceTypeProperty> instanceTypes;

	public List<InstanceTypeProperty> getInstanceTypes() {
		return instanceTypes;
	}

	public void setInstanceTypes(List<InstanceTypeProperty> instanceTypes) {
		this.instanceTypes = instanceTypes;
	}

}
