package jp.ac.nii.prl.mape.monitoring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.nii.prl.mape.monitoring.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

	Optional<Model> findById(Long modelId);
	
}
