

public class ZigZagString {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (numRows == s.length()) return s;
        int jump = (numRows - 1)*2;
        char[] charArray = s.toCharArray();
        char[] resArray = new char[s.length()];
        int index = 0;
        for (int i = 0 ; i < numRows; i++) {
            for (int j = i; j < s.length(); j=j+jump) {
                resArray[index] = charArray[j];
                index++;
                if(i > 0 && i < numRows-1 && (j+jump)-2*i < s.length()) {
                    resArray[index] = charArray[j+jump - 2*i];
                    index++;
                }
            }
        }
        return new String(resArray);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 5));
    }
}
