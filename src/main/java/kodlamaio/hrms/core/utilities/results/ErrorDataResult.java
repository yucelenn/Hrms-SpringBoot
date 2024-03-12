package kodlamaio.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult() {
		super(null, false); //ana sınıfa data'yı null, success bilgisine de false gönder
	}
	
	public ErrorDataResult(T data) {
		super(data, false); //ana sınıfa data'yı, success bilgisine de false gönder
	}
	
	public ErrorDataResult(String message) {
		super(null, false, message); //ana sınıfa message'ı, success bilgisine de false gönder
	}
	
	public ErrorDataResult(T data, String message) {
		super(data, false, message); //ana sınıfa data ve message'ı, success bilgisine de false gönder
	}

}
