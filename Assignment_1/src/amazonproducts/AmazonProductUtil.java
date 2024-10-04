package amazonproducts;
public class AmazonProductUtil{

	public static float convertStrToFloat(String str) {
		//if there is a special charecter then we substring it if there isnt then parse the entire str
		str=str.substring(1, str.length());
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return 0.0f;
        }
	}
	public static String[] lineReader(String line) {
        String[] result = new String[10];
        int index = 0;
        int start = 0;
        int end;

        while (start < line.length()) {
            if (line.charAt(start) == '"') {

                start++;
                end = line.indexOf('"', start);
            } else {
                end = line.indexOf(',', start);
            }
            if (end == -1) {
                end = line.length();
            }

            String value = line.substring(start, end).trim();
            result[index] = value;
            index++;

            if (end < line.length() && line.charAt(end) == '"') {
                start = end + 2;
            } else {
                start = end + 1;
            }
        }
        return result;
    }
}

		