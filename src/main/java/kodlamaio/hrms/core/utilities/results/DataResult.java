package kodlamaio.hrms.core.utilities.results;

public class DataResult<T> extends Result {

	private T data;
	
	public DataResult(T data, boolean success, String message) { //mesajlı
		super(success, message); //miras aldığı sınıfın constructorına gönder
		this.data=data;
	}

	public DataResult(T data, boolean success) { //mesajsız
		super(success);
		this.data=data;
	}

	public T getData() {
		return this.data;
	}
}