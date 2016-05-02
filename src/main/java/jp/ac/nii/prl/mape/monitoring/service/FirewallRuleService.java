package jp.ac.nii.prl.mape.monitoring.service;

import com.amazonaws.services.ec2.model.IpPermission;

import jp.ac.nii.prl.mape.monitoring.model.FirewallRule;

public interface FirewallRuleService {

	/**
	 * Creates a FirewallRule object from an AWS IpPermission
	 * @param ipPermission IpPermission from AWS
	 * @return a FirewallRule object
	 */
	FirewallRule fromAWS(IpPermission ipPermission);

}