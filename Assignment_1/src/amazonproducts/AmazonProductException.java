package amazonproducts;
public class AmazonProductException extends Exception{
	private static final long serialVersionUID = 8450907732051066312L;

	public AmazonProductException(String errorMessage){
		super(errorMessage);
		System.err.println("AmazonProductException: " + errorMessage);
	}
}