package jp.ac.nii.prl.mape.monitoring.service;

import jp.ac.nii.prl.mape.monitoring.model.SecurityGroup;

public interface SecurityGroupService {

	SecurityGroup fromAWS(com.amazonaws.services.ec2.model.SecurityGroup aws);

}