package kodlamaio.hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String eMail;
	
	@Column(name="password")
	private  String password;
	
}
