package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("index is outside the scope of the array");
        }
        return result;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        try {
            FindEl.indexOf(new String[]{"a", "b", "c"}, "1");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
