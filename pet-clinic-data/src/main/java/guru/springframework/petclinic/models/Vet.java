package guru.springframework.petclinic.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_vet")
public class Vet extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_vet_speciality", joinColumns = @JoinColumn(name="vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();
	
}
