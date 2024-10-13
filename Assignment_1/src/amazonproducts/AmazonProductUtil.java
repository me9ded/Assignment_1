/*
 * Students Names: Fouzi Haidar & Mohamed Amine Jmal
 * Student Number: 041157806 &     041138938
 * Professor Name: Paulo Sousa
 * Assignment 1
 * Description: Read the CSV, create proper classes, exception
handling, packages as well as perform operations using Collections (ArrayList), that
includes inclusion, edition, deletion and searching.*/
package amazonproducts;
public class AmazonProductUtil{
	private static int NUMCOLS=10;

	public static float convertStrToFloat(String str) {
		//if there is a special charecter then we substring it if there isn't then parse the entire string
		str=str.substring(1, str.length());
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return 0.0f;
        }
	}
	public String[] lineReader(String string) {
	    String[] str = new String[NUMCOLS];
	    int index = 0;
	    final char chComma = ',';
	    final char chQuotes = '"';
	    boolean insideQuotes = false;
	    StringBuilder currentField = new StringBuilder();

	    for (int i = 0; i < string.length(); i++) {
	        char currentChar = string.charAt(i);

	        if (currentChar == chQuotes) {
	            if (i > 0 && string.charAt(i - 1) == chQuotes) {

	                currentField.append(currentChar);
	                i++; 
	            } else {
	                insideQuotes = !insideQuotes;
	            }
	        } else if (currentChar == chComma && !insideQuotes) {
	            str[index++] = currentField.toString().trim();
	            currentField.setLength(0);
	        } else {
	            currentField.append(currentChar);
	        }
	    }

	    if (currentField.length() > 0) {
	        str[index++] = currentField.toString().trim();
	    }

	    return str;
	}


}

		