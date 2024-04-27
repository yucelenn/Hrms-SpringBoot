package kodlamaio.hrms.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})//maplerden dolayı loop oluşmasın diye
public class Employer extends User{

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int employerId;*/
	
	@Column(name="company_name")
	@NotBlank(message = "Şirket adı alanı boş bırakılamaz!")
	private String companyName;
	
	@Column(name="web_address")
	@NotBlank(message = "Web adresi alanı boş bırakılamaz!")
	private String webAdress;
	
	@Column(name="phone_number")
	@NotBlank(message = "Telefon numarası alanı boş bırakılamaz!")
	private String phoneNumber;
	
	@OneToMany(mappedBy ="employer")
	private List<JobAdvertisement> jobAdvertisements;
	
}