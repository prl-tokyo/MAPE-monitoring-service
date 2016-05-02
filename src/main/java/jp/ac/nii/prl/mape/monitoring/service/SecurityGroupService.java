package jp.ac.nii.prl.mape.monitoring.service;

import jp.ac.nii.prl.mape.monitoring.SecurityGroupNotFoundException;
import jp.ac.nii.prl.mape.monitoring.model.SecurityGroup;

public interface SecurityGroupService {

	/**
	 * Creates a SecurityGroup from its AWS representation
	 * @param aws the AWS representation of a SecurityGroup
	 * @return a SecurityGroup
	 * @throws SecurityGroupNotFoundException
	 */
	SecurityGroup fromAWS(com.amazonaws.services.ec2.model.SecurityGroup aws) throws SecurityGroupNotFoundException;

}