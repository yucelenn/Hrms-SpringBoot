package kodlamaio.hrms.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import kodlamaio.hrms.entities.concretes.cv.CoverLetter;
import kodlamaio.hrms.entities.concretes.cv.EducationInfo;
import kodlamaio.hrms.entities.concretes.cv.ExperienceInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="candidates")
public class Candidate extends User {
	
/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int candidateId;*/
	
	@Column(name="first_name")
	@NotBlank(message = "İsim alanı boş bırakılamaz!")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "Soy isim alanı boş bırakılamaz!")
	private String lastName;
	
	@Column(name="identity_number")
	@NotBlank(message = "TC kimlik numarası alanı boş bırakılamaz!")
	private String identityNumber;
	
	@Column(name="birth_year")
	@NotBlank(message = "Doğum yılı alanı boş bırakılamaz!")
	private String birthYear;

	@OneToMany(mappedBy = "candidate" )
	private List<EducationInfo> educationInfos;
	
	@OneToMany(mappedBy = "candidate")
	private List<ExperienceInfo> experienceInfos;
	
	@OneToOne(mappedBy = "candidate")
	private CoverLetter coverLetter;	
	
}