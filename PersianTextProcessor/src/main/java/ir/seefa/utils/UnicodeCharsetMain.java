package ir.seefa.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sami
 * @version 1.0
 * @since 1/26/2017
 */
public class UnicodeCharsetMain {
    /***
     * This method used for return list of UTF-8 unicode characters index(hex), char and char names with each other
     * @return used to return provided to return list of UTF-8 charset
     */
    public static List<String> getUTF8Characters() {
        List<String> utf8CharList = new ArrayList<String>();
        for (char charset = 0x0000; charset < 0x0FFFF; charset++) {
            int intChar = (int) charset;
            String hex = String.format("%04X", intChar);
            String character;
            if(intChar >= 0 && intChar <=32)
//                character = intChar + "(" + hex + ") : " + CharacterName.get(charset); + "\t";
                character = intChar + "(" + hex + ") : " + "<Control>" + "\t";
            else
                character = intChar + "(" + hex + ") : " + charset + "\t";
            utf8CharList.add(character);
        }
        return utf8CharList;
    }

    public static void main(String[] args) {
        List<String> utf8Characters = UnicodeCharsetMain.getUTF8Characters();
        for (int i = 0; i < utf8Characters.size(); i++) {
            System.out.print(utf8Characters.get(i));
            if (i % 10 == 0)
                System.out.println();
        }
    }
}
