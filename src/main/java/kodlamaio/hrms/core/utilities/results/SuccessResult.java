package kodlamaio.hrms.core.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true); // ana sınıfa success'i true gönder
	}

	public SuccessResult(String message) {
		super(true,message); // ana sınıfa success'i true ve mesajı gönder 
	}
}