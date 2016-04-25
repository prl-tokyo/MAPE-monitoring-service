package jp.ac.nii.prl.mape.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.nii.prl.mape.monitoring.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
