package kodlamaio.hrms.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

	private int id;
	private String firstName;
	private String lastName;
	private String identityNumber;
	private String birthYear;
	private String schoolName;
	private String departmantName;
	private String degree;
	private Date startDate;
	private Date endDate;
	private String companyName;
	private String role;
	private Date jobStartDate;
	private Date jobEndDate;
	private String languageName;
	private int languageLevel;
	private String imagePath;
	private String githubLink;
	private String linkedinLink;
	private String technology;
	private String coverLetterDescription;
	//private String imagePath2;
}
