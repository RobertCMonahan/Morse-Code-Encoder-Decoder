import java.util.HashMap;

public class Main {

// create hash map for alphabet
// ' / ' is a space (new word)
// ' ' a single space is character break (new char)
// match letters in hash map to the code
// create new string that is the decoded message
// the message to decode
// .... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--
// get the program to encode and decode messages
// get the program to flash a light for the code
public static void main(String args[]) {
        // setup system to access it via the termainal
        // arg0 encode or decode
        // arg1 raspi, screen, text
        // arg2 the message
        StringBuilder sb =  new StringBuilder();

        for (String item : args) {
                if (item == args[0]) {
                        // disregard the first command line arg as that is the command to encode to decode the message.
                } else {
                        sb.append(item);
                        sb.append(" ");
                }
        }

        String sourceMessage = sb.toString();

        if (args[0].equals("encode")) {
                System.out.println(encode(sourceMessage));
        } else if (args[0].equals("decode")) {
                System.out.println(decode(sourceMessage));
        } else {
                System.out.println("use 'encode' or 'decode' for the first command line argument");
        }
        System.out.println("\007");

}

public static String decode (String sourceMessage) {

        HashMap decodeDict = new HashMap(37);

        decodeDict.put(".-", "A");
        decodeDict.put("-...", "B");
        decodeDict.put("-.-.", "C");
        decodeDict.put("-..", "D");
        decodeDict.put(".", "E");
        decodeDict.put("..-.", "F");
        decodeDict.put("--.", "G");
        decodeDict.put("....", "H");
        decodeDict.put("..", "I");
        decodeDict.put(".---", "J");
        decodeDict.put("-.-", "K");
        decodeDict.put(".-..", "L");
        decodeDict.put("--", "M");
        decodeDict.put("-.", "N");
        decodeDict.put("---", "O");
        decodeDict.put(".--.", "P");
        decodeDict.put("--.-", "Q");
        decodeDict.put(".-.", "R");
        decodeDict.put("...", "S");
        decodeDict.put("-", "T");
        decodeDict.put("..-", "U");
        decodeDict.put("...-", "V");
        decodeDict.put(".--", "W");
        decodeDict.put("-..-", "X");
        decodeDict.put("-.--", "Y");
        decodeDict.put("--..", "Z");
        decodeDict.put(".----", "1");
        decodeDict.put("..---", "2");
        decodeDict.put("...--", "3");
        decodeDict.put("....-", "4");
        decodeDict.put(".....", "5");
        decodeDict.put("-....", "6");
        decodeDict.put("--...", "7");
        decodeDict.put("---..", "8");
        decodeDict.put("----.", "9");
        decodeDict.put("-----", "0");
        decodeDict.put("/", " ");

        // split up each letter in the message based on the one unit space (single space)
        String[] letters = sourceMessage.split(" ");

        StringBuilder sb =  new StringBuilder();

        for (String l : letters) {
                // for each encoded letter in the message replace with the decoded letter and append to sb
                sb.append(decodeDict.getOrDefault(l, "\u25AF"));
        }

        return sb.toString();
}

public static String encode (String sourceMessage) {

        HashMap encodeDict = new HashMap(37);

        // each item in encodeDict is the morse code verison of a letter with a space indicating the end of the letter
        encodeDict.put('A', ".- ");
        encodeDict.put('B', "-... ");
        encodeDict.put('C', "-.-. ");
        encodeDict.put('D', "-.. ");
        encodeDict.put('E', ". ");
        encodeDict.put('F', "..-. ");
        encodeDict.put('G', "--. ");
        encodeDict.put('H', ".... ");
        encodeDict.put('I', ".. ");
        encodeDict.put('J', ".--- ");
        encodeDict.put('K', "-.- ");
        encodeDict.put('L', ".-.. ");
        encodeDict.put('M', "-- ");
        encodeDict.put('N', "-. ");
        encodeDict.put('O', "--- ");
        encodeDict.put('P', ".--. ");
        encodeDict.put('Q', "--.- ");
        encodeDict.put('R', ".-. ");
        encodeDict.put('S', "... ");
        encodeDict.put('T', "- ");
        encodeDict.put('U', "..- ");
        encodeDict.put('V', "...- ");
        encodeDict.put('W', ".-- ");
        encodeDict.put('X', "-..- ");
        encodeDict.put('Y', "-.-- ");
        encodeDict.put('Z', "--.. ");
        encodeDict.put('1', ".---- ");
        encodeDict.put('2', "..--- ");
        encodeDict.put('3', "...-- ");
        encodeDict.put('4', "....- ");
        encodeDict.put('5', "..... ");
        encodeDict.put('6', "-.... ");
        encodeDict.put('7', "--... ");
        encodeDict.put('8', "---.. ");
        encodeDict.put('9', "----. ");
        encodeDict.put('0', "----- ");
        // a space (or end of word) is indcated by a /
        encodeDict.put(' ', "/ ");

        sourceMessage = sourceMessage.toUpperCase();

        StringBuilder sb =  new StringBuilder();

        for (char ch : sourceMessage.toCharArray()) {
                // for each encoded letter in the message replace with the decoded letter and append to sb
                sb.append(encodeDict.getOrDefault(ch, "\u25AF"));
        }

        return sb.toString();


}



}
