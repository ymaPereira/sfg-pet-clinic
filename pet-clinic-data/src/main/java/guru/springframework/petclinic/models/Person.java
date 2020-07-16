package guru.springframework.petclinic.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class Person extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "first_name")
	@NotNull
	private String firstName;
	@Column(name = "last_name")
	@NotNull
	private String lastName;
	
}
