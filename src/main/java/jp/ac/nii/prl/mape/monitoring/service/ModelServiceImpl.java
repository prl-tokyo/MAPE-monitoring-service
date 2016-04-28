package jp.ac.nii.prl.mape.monitoring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.ec2.model.InstanceStateName;

import jp.ac.nii.prl.mape.monitoring.model.InstanceType;
import jp.ac.nii.prl.mape.monitoring.model.Model;
import jp.ac.nii.prl.mape.monitoring.properties.InstanceTypeProperties;
import jp.ac.nii.prl.mape.monitoring.properties.InstanceTypeProperty;
import jp.ac.nii.prl.mape.monitoring.repository.ModelRepository;

@Service("modelService")
public class ModelServiceImpl implements ModelService {

	private final ModelRepository modelRepository;
	
	private final InstanceService instanceService;
	private final SecurityGroupService securityGroupService;
	
	@Autowired
	public ModelServiceImpl(ModelRepository modelRepository, 
			InstanceService instanceService,
			SecurityGroupService securityGroupService) {
		this.modelRepository = modelRepository;
		this.instanceService = instanceService;
		this.securityGroupService = securityGroupService;
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.ModelService#save(jp.ac.nii.prl.mape.monitoring.model.Model)
	 */
	@Override
	public Model save(Model model) {
		return modelRepository.save(model);
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.ModelService#findById(java.lang.Long)
	 */
	@Override
	public Optional<Model> findById(Long modelId) {
		return modelRepository.findById(modelId);
	}
	
	@Override
	public Model createModel(List<com.amazonaws.services.ec2.model.Instance> instances,
			List<com.amazonaws.services.ec2.model.SecurityGroup> securityGroups,
			InstanceTypeProperties instanceTypeProperties) {
		Model model = new Model();
		for (com.amazonaws.services.ec2.model.Instance instance:instances) {
			if (instance.getState().getCode().equals(new Integer(16)))
				model.addInstance(instanceService.fromAWS(instance));
		}
		for (com.amazonaws.services.ec2.model.SecurityGroup sg:securityGroups) {
			model.addSecurityGroups(securityGroupService.fromAWS(sg));
		}
		for (InstanceTypeProperty instanceTypeProperty:instanceTypeProperties.getInstanceTypes()) {
			System.out.println("Here");
			InstanceType instanceType = new InstanceType();
			instanceType.setTypeCost(instanceTypeProperty.getTypeCost());
			instanceType.setTypeCPUs(instanceTypeProperty.getTypeCPUs());
			instanceType.setTypeID(instanceTypeProperty.getTypeID());
			instanceType.setTypeRAM(instanceTypeProperty.getTypeRAM());
			model.addInstanceType(instanceType);
		}
		return model;
	}
}
