package jp.ac.nii.prl.mape.monitoring.service;

import com.amazonaws.services.ec2.model.IpPermission;

import jp.ac.nii.prl.mape.monitoring.model.FirewallRule;

public interface FirewallRuleService {

	FirewallRule fromAWS(IpPermission ipPermission);

}