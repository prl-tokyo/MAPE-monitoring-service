package jp.ac.nii.prl.mape.monitoring.service;

import java.util.List;
import java.util.Optional;

import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.SecurityGroup;

import jp.ac.nii.prl.mape.monitoring.SecurityGroupNotFoundException;
import jp.ac.nii.prl.mape.monitoring.model.Model;
import jp.ac.nii.prl.mape.monitoring.properties.InstanceTypeProperties;

public interface ModelService {

	Model save(Model model);

	Optional<Model> findById(Long modelId);

	Model createModel(List<Instance> instances, 
			List<SecurityGroup> securityGroups, 
			InstanceTypeProperties instanceTypeProperties) throws SecurityGroupNotFoundException;

}