package jp.ac.nii.prl.mape.monitoring.service;

import java.util.List;

import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.SecurityGroup;

public interface EC2Service {

	/**
	 * Gets a list of all instances, satisfying filters passed to the EC2Service constructor
	 * @return a list of Instance elements (possibly empty)
	 */
	List<Instance> getInstances();

	/**
	 * Gets a list of all security groups
	 * @return a list of SecurityGroup elements (possibly empty)
	 */
	List<SecurityGroup> getSecurityGroups();

}