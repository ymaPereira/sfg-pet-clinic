package guru.springframework.petclinic.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pet_type")
public class PetType extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
