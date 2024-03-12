package kodlamaio.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{
	
	public SuccessDataResult() {
		super(null, true); //ana sınıfa data'yı null, success bilgisine de true gönder
	}
	
	public SuccessDataResult(T data) {
		super(data, true); //ana sınıfa data'yı, success bilgisine de true gönder
	}
	
	public SuccessDataResult(String message) {
		super(null, true, message); //ana sınıfa message'ı, success bilgisine de true gönder
	}
	
	public SuccessDataResult(T data, String message) {
		super(data, true, message); //ana sınıfa data ve message'ı, success bilgisine de true gönder
	}
	
}
