/**
 * 
 */
package jp.ac.nii.prl.mape.monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.nii.prl.mape.monitoring.model.Instance;

@Service("instanceService")
public class InstanceServiceImpl implements InstanceService {

	private final CloudWatchService cwService;
	
	@Autowired
	public InstanceServiceImpl(CloudWatchService cwService) {
		this.cwService = cwService;
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.InstanceService#fromAWS(com.amazonaws.services.ec2.model.Instance)
	 */
	@Override
	public Instance fromAWS(com.amazonaws.services.ec2.model.Instance aws) {
		Instance instance = new Instance();
		instance.setAmi(aws.getImageId());
		instance.setInstID(aws.getInstanceId());
		instance.setInstStatus(0);
		instance.setInstType(aws.getInstanceType());
		instance.setSecurityGroupRef(aws.getSecurityGroups().iterator().next().getGroupId());
		instance.setState(aws.getState().getCode());
		instance.setLoad(cwService.getLoad(instance.getInstID()));
		return instance;
	}

}
