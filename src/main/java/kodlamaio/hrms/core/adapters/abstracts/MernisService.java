package kodlamaio.hrms.core.adapters.abstracts;

import java.rmi.RemoteException;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {

	boolean checkIfRealPerson(Candidate candidate) throws NumberFormatException, RemoteException;
}
