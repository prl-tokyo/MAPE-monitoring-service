package jp.ac.nii.prl.mape.monitoring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.SecurityGroup;

import jp.ac.nii.prl.mape.monitoring.ModelConstructionException;
import jp.ac.nii.prl.mape.monitoring.SecurityGroupNotFoundException;
import jp.ac.nii.prl.mape.monitoring.model.Model;
import jp.ac.nii.prl.mape.monitoring.properties.InstanceTypeProperties;
import jp.ac.nii.prl.mape.monitoring.service.EC2Service;
import jp.ac.nii.prl.mape.monitoring.service.ModelService;

@RestController
@RequestMapping("/monitor")
@Component
public class MonitoringController {
	
	private static final Logger logger = LoggerFactory.getLogger(MonitoringController.class);

	@Autowired
	private EC2Service ec2Service;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private InstanceTypeProperties instanceTypeProperties;
	
	@RequestMapping(value="/instances", method=RequestMethod.GET)
	public List<Instance> getInstances() {
		logger.info("Getting list of instances");
		List<Instance> instances = ec2Service.getInstances();
		logger.debug(String.format("List of instances contains %s elements", instances.size()));
		return instances;
	}
	
	@RequestMapping(value="/securityGroups", method=RequestMethod.GET)
	public List<SecurityGroup> getSecurityGroups() {
		logger.info("Getting list of security groups");
		List<SecurityGroup> sgs = ec2Service.getSecurityGroups();
		logger.debug(String.format("List of security groups contains %s elements", sgs.size()));
		return sgs;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Model getModel() {
		logger.info("Building model from AWS API");
		Model model = null;
		try {
			model = modelService.createModel(ec2Service.getInstances(), 
					ec2Service.getSecurityGroups(),
					instanceTypeProperties);
		} catch (SecurityGroupNotFoundException e) {
			logger.error(String.format("SecurityGroupNotFoundException: %s", e.getMessage()));
			logger.trace(e.getStackTrace().toString());
			throw new ModelConstructionException("Could not construct model");
		}
		logger.debug(String.format("Model contains %s instances, %s instance types, and %s security groups", 
				model.getInstances().size(), 
				model.getInstanceTypes().size(), 
				model.getSecurityGroups().size()));
		return model;
	}
}
