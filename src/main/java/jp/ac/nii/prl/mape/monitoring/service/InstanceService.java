package jp.ac.nii.prl.mape.monitoring.service;

import java.util.List;

import jp.ac.nii.prl.mape.monitoring.model.Instance;

public interface InstanceService {

	Instance fromAWS(com.amazonaws.services.ec2.model.Instance instance);

	List<String> getInstancesInSG(String sg);
}
