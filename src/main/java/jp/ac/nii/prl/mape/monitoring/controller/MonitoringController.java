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
		return ec2Service.getInstances();
	}
	
	@RequestMapping(value="/securityGroups", method=RequestMethod.GET)
	public List<SecurityGroup> getSecurityGroups() {
		return ec2Service.getSecurityGroups();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Model getModel() {
		logger.info("Building model from AWS API");
		Model model = modelService.createModel(ec2Service.getInstances(), 
				ec2Service.getSecurityGroups(),
				instanceTypeProperties);
		logger.info("Model completed");
		return model;
	}
}
