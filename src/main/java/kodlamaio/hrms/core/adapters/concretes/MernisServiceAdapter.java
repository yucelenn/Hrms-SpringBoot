package kodlamaio.hrms.core.adapters.concretes;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.adapters.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements MernisService {

	KPSPublicSoapProxy client = new KPSPublicSoapProxy();
	
	@Override
	public boolean checkIfRealPerson(Candidate candidate) throws NumberFormatException, RemoteException {
		
		boolean result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), 
				candidate.getFirstName().toUpperCase(), 
				candidate.getLastName().toUpperCase(), 
				Integer.parseInt(candidate.getBirthYear()));
		 
		 if(result == true){
				System.out.println("Successfully registered!");
				return true;
				
			}else {
				System.out.println("Failed to create an account! Your information does not match with E Devlet information.");
				return false;
			}
	}

}
