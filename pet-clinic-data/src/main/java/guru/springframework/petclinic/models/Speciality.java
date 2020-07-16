package guru.springframework.petclinic.models;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_speciality")
public class Speciality extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
}
