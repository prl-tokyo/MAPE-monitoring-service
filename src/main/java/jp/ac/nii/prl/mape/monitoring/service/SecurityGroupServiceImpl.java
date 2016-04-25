package jp.ac.nii.prl.mape.monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.ec2.model.IpPermission;

import jp.ac.nii.prl.mape.monitoring.model.SecurityGroup;

@Service("securityGroupService")
public class SecurityGroupServiceImpl implements SecurityGroupService {

	private final FirewallRuleService firewallRuleService;
	
	@Autowired
	public SecurityGroupServiceImpl(FirewallRuleService firewallRuleService) {
		this.firewallRuleService = firewallRuleService;
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.SecurityGroupService#fromAWS(com.amazonaws.services.ec2.model.SecurityGroup)
	 */
	@Override
	public SecurityGroup fromAWS(com.amazonaws.services.ec2.model.SecurityGroup aws) {
		SecurityGroup sg = new SecurityGroup();
		
		sg.setSgID(aws.getGroupId());
		
		for (IpPermission ipPermission:aws.getIpPermissions())
			sg.addFirewallRule(firewallRuleService.fromAWS(ipPermission));
		
		return sg;
	}
}
