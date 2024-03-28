package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result {

	public ErrorResult() {
		super(false); // ana sınıfa success'i false gönder
	}

	public ErrorResult(String message) {
		super(false,message); // ana sınıfa success'i false ve mesajı gönder 
	}
}