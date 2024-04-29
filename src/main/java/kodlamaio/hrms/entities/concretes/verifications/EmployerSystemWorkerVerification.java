package kodlamaio.hrms.entities.concretes.verifications;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "employee_confirms_employers")
public class EmployerSystemWorkerVerification extends SystemWorkerVerification {

	@OneToOne
	@JoinColumn(name="employer_id")
	@ToString.Exclude	
	private Employer employer;
}