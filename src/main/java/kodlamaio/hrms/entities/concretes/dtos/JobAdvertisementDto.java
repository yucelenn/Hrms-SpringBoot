package kodlamaio.hrms.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int freePositionAmount;
	private Date startDate;
	private Date endDate;
	private String title;
	private String companyName;
}