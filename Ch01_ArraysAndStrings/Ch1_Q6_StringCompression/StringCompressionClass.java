//String Compression: Implement a method to perform basic string compression using the counts
//of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
//"compressed" string would not become smaller than the original string, your method should return
//the original string. You can assume the string has only uppercase and lowercase letters (a - z).

public class StringCompressionClass {

    public static String compressString(String String){
        if(string == null || string.length() == 0) return "Invalid Input String";
        StringBuilder sb = new stringBuilder();
        char pervious = string.charAt(0);
        int counter = 1;
        for(int i=1;i<string.length();i++){
            if(previous == string.charAt(i)){
                counter++;
            } else {
                sb.append(previous).append(counter);
                previous = string.charAt(i);
                counter=1;
            }
        }
        sb.append(previous).append(counter);
        if(string.length() > sb.toString())
            return sb.toString();
        else return string;
    }
    //aabcccc a a a  i=9 p=a c=3 sb -- a2b1c4a3  -- return compressed.
    //abc i=2, p = c, c=1  sb--- a1b1c1 --- return abc

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abc"));
    }
}