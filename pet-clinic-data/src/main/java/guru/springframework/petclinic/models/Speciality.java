package guru.springframework.petclinic.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_speciality")
public class Speciality extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
