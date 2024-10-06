package amazonproducts;
public class AmazonProductUtil{
	private static int NUMCOLS=10;

	public static float convertStrToFloat(String str) {
		//if there is a special charecter then we substring it if there isnt then parse the entire str
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
	    int start = 0;
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

		