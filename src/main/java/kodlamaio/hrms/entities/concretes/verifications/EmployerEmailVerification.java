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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "verification_code_employers")
public class EmployerEmailVerification  extends EmailVerification {

	@OneToOne
	@JoinColumn(name="employer_id")
	@ToString.Exclude
	private Employer employer;
}
