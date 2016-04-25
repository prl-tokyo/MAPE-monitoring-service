package jp.ac.nii.prl.mape.monitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.ec2.model.Instance;

import jp.ac.nii.prl.mape.monitoring.model.Model;
import jp.ac.nii.prl.mape.monitoring.service.EC2Service;

@RestController
@RequestMapping("/monitor")
@Component
public class MonitoringController {

	@Autowired
	private EC2Service ec2Service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Instance> monitor() {
		System.out.println("Here");
		return ec2Service.getInstances();
	}
}
