package jp.ac.nii.prl.mape.monitoring.service;

import jp.ac.nii.prl.mape.monitoring.model.Instance;

public interface InstanceService {

	Instance fromAWS(com.amazonaws.services.ec2.model.Instance instance);

}
