package by.balan.controller.functions;

/**
 * Created by Ultrabook on 21.04.2015.
 */
public class StrFuncions {
    public static String removeChar(String s, char c) {
        String r = "";
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != c) r += s.charAt(i);
        }
        return r;
    }
}
