package kodlamaio.hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="employees")
public class SystemWorker extends User{

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int systemWorkerId;*/
	
	@Column(name="first_name")
	@NotBlank(message = "İsim alanı boş bırakılamaz!")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "Soy isim alanı boş bırakılamaz!")
	private String lastName;

}