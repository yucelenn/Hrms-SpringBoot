package kodlamaio.hrms.entities.concretes.verifications;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.Candidate;
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
@Table(name = "verification_code_candidates")
public class CandidateEmailVerification extends EmailVerification{

	@OneToOne
	@JoinColumn(name ="candidate_id" )
	@ToString.Exclude
	private Candidate candidate;
}
