/*
 * Students Names: Fouzi Haidar & Mohamed Amine Jmal
 * Student Number: 041157806 &     041138938
 * Professor Name: Paulo Sousa
 * Assignment 1
 * Description: Read the CSV, create proper classes, exception
handling, packages as well as perform operations using Collections (ArrayList), that
includes inclusion, edition, deletion and searching.*/
package amazonproducts;
public class AmazonProductException extends Exception{
	private static final long serialVersionUID = 8450907732051066312L;

	public AmazonProductException(String errorMessage){
		super(errorMessage);
		System.err.println("AmazonProductException: " + errorMessage);
	}
}