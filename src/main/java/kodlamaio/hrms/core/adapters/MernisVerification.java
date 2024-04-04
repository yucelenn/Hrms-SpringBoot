package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisVerification {

	public boolean checkIfRealPerson(Candidate candidate) {

		return true;
	}
	
	// mernis sistemi spring'te sorun çıkarıyor, simülasyon olarak kullanılacak.
	
}
