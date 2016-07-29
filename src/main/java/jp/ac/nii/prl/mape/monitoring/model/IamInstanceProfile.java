package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IamInstanceProfile {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private String id;
	private String Arn;
	private int hashCode;
	
	@OneToOne
	public String getArn() {
		return Arn;
	}
	public void setArn(String arn) {
		Arn = arn;
	}
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}


	
}
