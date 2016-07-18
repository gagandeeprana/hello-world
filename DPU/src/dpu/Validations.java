package dpu;

public class Validations {

    public static boolean hasSpace(String str) {
        if (str.indexOf(" ") > 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        if (str.equals("")) {
            return true;
        }
        return false;
    }

    public static boolean checkDropDown(String str) {
        if (str.equals("Select")) {
            return true;
        }
        return false;
    }

    public static boolean hasNumerals(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAlphabets(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= 'a' && ch <= 'z')) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDecimals(String str) {
        int dotCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '.') {
                dotCounter++;
            }
        }
        if (dotCounter > 1) {
            return true;
        }
        if (dotCounter == 0 || dotCounter == 1) {
            if (dotCounter == 1 && str.indexOf(".") == 0) {
                return true;
            }
            if (str.indexOf(".") == str.length() - 1) {
                return true;
            }
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!(ch >= '0' && ch <= '9' || ch == '.')) {
                    return true;
                }
            }
        }
        return false;
    }
}
