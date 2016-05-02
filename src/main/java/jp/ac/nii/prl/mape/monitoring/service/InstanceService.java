package jp.ac.nii.prl.mape.monitoring.service;

import java.util.List;

import jp.ac.nii.prl.mape.monitoring.SecurityGroupNotFoundException;
import jp.ac.nii.prl.mape.monitoring.model.Instance;

public interface InstanceService {

	/**
	 * 
	 * @param instance
	 * @return
	 */
	Instance fromAWS(com.amazonaws.services.ec2.model.Instance instance);

	/**
	 * Gets a list of the names of all the instances in a security group
	 * @param sg security group ID
	 * @return a list of the names of all the instances in a security group
	 * @throws SecurityGroupNotFoundException if a security group could not be found
	 * with the specified ID
	 */
	List<String> getInstancesInSG(String sg) throws SecurityGroupNotFoundException;
}
