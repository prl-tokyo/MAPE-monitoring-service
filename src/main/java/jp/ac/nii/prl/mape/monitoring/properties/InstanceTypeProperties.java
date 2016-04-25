package jp.ac.nii.prl.mape.monitoring.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class InstanceTypeProperties {
	
	private List<InstanceTypeProperty> instanceTypes;

	public List<InstanceTypeProperty> getInstanceTypes() {
		return instanceTypes;
	}

	public void setInstanceTypes(List<InstanceTypeProperty> instanceTypes) {
		this.instanceTypes = instanceTypes;
	}

}
