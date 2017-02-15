package ir.seefa.utils;

/**
 * This class used for Persian formatting characters as Proxy pattern for Datecs printers
 * @author Saman Delfani
 * @version 1.0
 * @since 3 Feb 2017
 */
public class DatecPersianFormatterUtil implements PersianFormatter {

    public enum PrinterType{
        DPP250, DPP450
    }

    public String persianFormatter(String inputText) {
        PersianFormatter formatter = new PersianFormatterUtil();
        return formatter.persianFormatter(inputText);
    }

    public String datecsLineController(String input,PrinterType type) {
        switch (type){
            case DPP250:
                return wrapString(input, 23);
            case DPP450:
                return wrapString(input, 50);
        }
        return input;
    }

    public static String wrapString(String string, int charWrap) {
        int lastBreak = 0;
        int nextBreak = charWrap;
        if (string.length() > charWrap) {
            String setString = "";
            do {
                while (string.charAt(nextBreak) != ' ' && nextBreak > lastBreak) {
                    nextBreak--;
                }
                if (nextBreak == lastBreak) {
                    nextBreak = lastBreak + charWrap;
                }
                setString += string.substring(lastBreak, nextBreak).trim() + "\n";
                lastBreak = nextBreak;
                nextBreak += charWrap;

            } while (nextBreak < string.length());
            setString += string.substring(lastBreak).trim();
            return setString;
        } else {
            return string;
        }
    }

    public static void main(String[] args) {
        DatecPersianFormatterUtil test = new DatecPersianFormatterUtil();
        String text = "شرکت پخش سایه سمن (سهامی خاص)";
        String result =  test.datecsLineController(text,PrinterType.DPP250);
        System.out.println(text);
        System.out.println(result);
    }
}