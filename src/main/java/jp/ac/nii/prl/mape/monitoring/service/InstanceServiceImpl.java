/**
 * 
 */
package jp.ac.nii.prl.mape.monitoring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.nii.prl.mape.monitoring.SecurityGroupNotFoundException;
import jp.ac.nii.prl.mape.monitoring.model.Instance;
import jp.ac.nii.prl.mape.monitoring.model.InstanceBlockDeviceMapping;
import jp.ac.nii.prl.mape.monitoring.model.InstanceNetworkInterface;
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
		instance.setEbsOptimized(aws.getEbsOptimized());
		
		com.amazonaws.services.ec2.model.Monitoring monitoring = aws.getMonitoring();
		jp.ac.nii.prl.mape.monitoring.model.Monitoring myMonitoring = new jp.ac.nii.prl.mape.monitoring.model.Monitoring();
		myMonitoring.setHashCode(monitoring.hashCode());
		myMonitoring.setState(monitoring.getState());
		instance.setMonitoring(myMonitoring);
		
		instance.setInstResponseTime((new Random()).nextInt(550 - 100 + 1) + 100);
		
		instance.setRootDeviceName(aws.getRootDeviceName());
		instance.withRootDeviceName(aws.getRootDeviceName());
		instance.setAmiLaunchIndex(aws.getAmiLaunchIndex());
		instance.setArchitecture(aws.getArchitecture());
		
		List<InstanceBlockDeviceMapping> blDeMs = new ArrayList<>();
		for(com.amazonaws.services.ec2.model.InstanceBlockDeviceMapping blDeM: aws.getBlockDeviceMappings()){
			jp.ac.nii.prl.mape.monitoring.model.InstanceBlockDeviceMapping myBlDeM = new jp.ac.nii.prl.mape.monitoring.model.InstanceBlockDeviceMapping();
			myBlDeM.setDeviceName(blDeM.getDeviceName());
			myBlDeM.setHashCode(blDeM.hashCode());
			blDeMs.add(myBlDeM);
		}
		instance.setBlockDeviceMapping(blDeMs);
		instance.setClientToken(aws.getClientToken());
		
	   //instance.setEnaSupport(aws.gete);
		instance.setHypervisor(aws.getHypervisor());
		
//		com.amazonaws.services.ec2.model.IamInstanceProfile iamInstPro = aws.getIamInstanceProfile();
//		jp.ac.nii.prl.mape.monitoring.model.IamInstanceProfile myIamInstPro = new jp.ac.nii.prl.mape.monitoring.model.IamInstanceProfile();
//		myIamInstPro.setArn(iamInstPro.getArn());
	//	instance.setIamInstanceProfile(myIamInstPro);
		
		instance.setImageId(aws.getImageId());
		instance.setKernelId(aws.getKernelId());
		instance.setKeyName(aws.getKeyName());
		
		List<InstanceNetworkInterface> instNetInters = new ArrayList<InstanceNetworkInterface>();
		for(com.amazonaws.services.ec2.model.InstanceNetworkInterface instNetInter: aws.getNetworkInterfaces()){
		   jp.ac.nii.prl.mape.monitoring.model.InstanceNetworkInterface myInstNetInter = new jp.ac.nii.prl.mape.monitoring.model.InstanceNetworkInterface();
		   myInstNetInter.setDescription(instNetInter.getDescription());
		   myInstNetInter.setMacAddress(instNetInter.getMacAddress());
		   myInstNetInter.setNetworkInterfaceId(instNetInter.getNetworkInterfaceId());
		   myInstNetInter.setSourceDestCheck(instNetInter.getSourceDestCheck());
		   instNetInters.add(myInstNetInter);
		}
		instance.setNetworkInterface(instNetInters);
		
		//instance.setPlacement(aws.getPlacement());
		com.amazonaws.services.ec2.model.Placement placement = aws.getPlacement();
		jp.ac.nii.prl.mape.monitoring.model.Placement myPlacement = new jp.ac.nii.prl.mape.monitoring.model.Placement();
		myPlacement.setHostId(placement.getHostId());
		myPlacement.setGroupName(placement.getGroupName());
		myPlacement.setHashCode(placement.hashCode());
		instance.setPlacement(myPlacement);
		
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
