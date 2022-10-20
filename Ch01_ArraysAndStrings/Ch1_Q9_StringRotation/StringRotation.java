//String Rotation: Assume you have a method isSubstring which checks if one word is a substring
//of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
//call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
public class StringRotation {
    //assumptions -- case insensitive.
    //same length of strings, otherwise return false
    public static boolean isStringRotation(String s1,String s2){
        if(s1==null || s2 == null) return false;
        if(s1.length() != s2.length() ||
            s1.length()==0 || s2.length() ==0) return false;
        StringBuffer sb = new StringBuffer(s1.length*2);
        sb.append(s1).append(s1);
        s1 = sb.toString();
        return isSubString(s1,s2);
    }

    public static void main(String[] args) {
        System.out.println("IsStringRotation:"+isStringRotation("waterbottle","erbottlewat"));
        System.out.println("isStringRotation:"+isStringRotation("stringrotate","otatestringr"));
    }
}