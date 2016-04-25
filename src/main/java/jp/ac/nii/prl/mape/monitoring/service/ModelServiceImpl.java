package jp.ac.nii.prl.mape.monitoring.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jp.ac.nii.prl.mape.monitoring.model.Model;
import jp.ac.nii.prl.mape.monitoring.repository.ModelRepository;

@Service("modelService")
public class ModelServiceImpl implements ModelService {

	private final ModelRepository modelRepository;
	
	public ModelServiceImpl(ModelRepository modelRepository) {
		this.modelRepository = modelRepository;
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
}
