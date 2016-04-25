package jp.ac.nii.prl.mape.monitoring.service;

import java.util.Optional;

import jp.ac.nii.prl.mape.monitoring.model.Model;

public interface ModelService {

	Model save(Model model);

	Optional<Model> findById(Long modelId);

}