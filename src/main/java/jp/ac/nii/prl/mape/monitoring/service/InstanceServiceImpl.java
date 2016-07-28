/**
 * 
 */
package jp.ac.nii.prl.mape.monitoring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.nii.prl.mape.monitoring.SecurityGroupNotFoundException;
import jp.ac.nii.prl.mape.monitoring.model.Instance;
import jp.ac.nii.prl.mape.monitoring.model.Tag;

@Service("instanceService")
public class InstanceServiceImpl implements InstanceService {

	private final CloudWatchService cwService;
	
	private Map<String, List<String>> sgToInstance;

//	private HashMap<Object, Object> tags;
	
	@Autowired
	public InstanceServiceImpl(CloudWatchService cwService) {
		this.cwService = cwService;
		sgToInstance = new HashMap<>();
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
		String sg = aws.getSecurityGroups().iterator().next().getGroupId();
		instance.setSecurityGroupRef(sg);
		addToSg(instance.getInstID(), sg);
		instance.setState(aws.getState().getCode());
		instance.setLoad(cwService.getLoad(instance.getInstID()));
		instance.setPlatform(aws.getPlatform());
		  
		List<Tag> tags = new ArrayList<Tag>();
		for(com.amazonaws.services.ec2.model.Tag tag: aws.getTags()){
		   jp.ac.nii.prl.mape.monitoring.model.Tag myTag = new jp.ac.nii.prl.mape.monitoring.model.Tag();
				myTag.setKey(tag.getKey());
				myTag.setValue(tag.getValue());
				tags.add(myTag);
		}
		instance.setTags(tags);
		
		instance.setLaunchTime(aws.getLaunchTime());
		return instance;
	}
	
	private void addToSg(String instance, String sg) {
		if (sgToInstance.containsKey(sg)) {
			List<String> instances = sgToInstance.get(sg);
			instances.add(instance);
			sgToInstance.put(sg, instances);
		} else {
			List<String> instances = new ArrayList<>();
			instances.add(instance);
			sgToInstance.put(sg, instances);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.InstanceService#getInstancesInSG(java.lang.String)
	 */
	@Override
	public List<String> getInstancesInSG(String sg) throws SecurityGroupNotFoundException {
		if (sgToInstance.containsKey(sg))
			return sgToInstance.get(sg);
		return new ArrayList<String>();
	}
}
