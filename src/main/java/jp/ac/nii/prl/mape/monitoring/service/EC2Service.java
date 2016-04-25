package jp.ac.nii.prl.mape.monitoring.service;

import java.util.List;

import com.amazonaws.services.ec2.model.Instance;

public interface EC2Service {

	List<Instance> getInstances();

}