package jp.ac.nii.prl.mape.monitoring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.ec2.model.IpPermission;

import jp.ac.nii.prl.mape.monitoring.SecurityGroupNotFoundException;
import jp.ac.nii.prl.mape.monitoring.model.SecurityGroup;

@Service("securityGroupService")
public class SecurityGroupServiceImpl implements SecurityGroupService {

	private final FirewallRuleService firewallRuleService;
	private final InstanceService instanceService;
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityGroupServiceImpl.class);
	
	@Autowired
	public SecurityGroupServiceImpl(FirewallRuleService firewallRuleService,
			InstanceService instanceService) {
		this.firewallRuleService = firewallRuleService;
		this.instanceService = instanceService;
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.SecurityGroupService#fromAWS(com.amazonaws.services.ec2.model.SecurityGroup)
	 */
	@Override
	public SecurityGroup fromAWS(com.amazonaws.services.ec2.model.SecurityGroup aws) 
			throws SecurityGroupNotFoundException {
		SecurityGroup sg = new SecurityGroup();
		
		sg.setSgID(aws.getGroupId());
		
		logger.debug(String.format("Security Group set to %s", sg.getSgID()));
		
		sg.setInstRefs(instanceService.getInstancesInSG(sg.getSgID()));
		
		for (IpPermission ipPermission:aws.getIpPermissions())
			sg.addFirewallRule(firewallRuleService.fromAWS(ipPermission));
		
		return sg;
	}
}
