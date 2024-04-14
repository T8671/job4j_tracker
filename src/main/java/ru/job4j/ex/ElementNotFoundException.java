package ru.job4j.ex;

import static java.lang.Integer.parseInt;

public class ElementNotFoundException extends Exception {

    public class FindEl {
        public static int indexOf(String[] value, String key) throws UserInputException {
            if (parseInt(key) > value.length) {
                throw new UserInputException("index is outside the scope of the array");
            }
            int result = -1;
            for (int i = 0; i < value.length; i++) {
                if (value[i].equals(key)) {
                    result = i;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[]{"a", "b", "c"}, "1");
        } catch (UserInputException e) {
            e.printStackTrace();
        }
    }
}
