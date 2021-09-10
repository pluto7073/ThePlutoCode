package io.pex64;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

public class Pex64Encoder {

    private static final HashMap<Character, String> BINARY_VALUES = new HashMap<>();
    private static final String HEX_VALUES = "0123456789abcdef";

    static {
        BINARY_VALUES.put('0', "0000");
        BINARY_VALUES.put('1', "0001");
        BINARY_VALUES.put('2', "0010");
        BINARY_VALUES.put('3', "0011");
        BINARY_VALUES.put('4', "0100");
        BINARY_VALUES.put('5', "0101");
        BINARY_VALUES.put('6', "0110");
        BINARY_VALUES.put('7', "0111");
        BINARY_VALUES.put('8', "1000");
        BINARY_VALUES.put('9', "1001");
        BINARY_VALUES.put('a', "1010");
        BINARY_VALUES.put('b', "1011");
        BINARY_VALUES.put('c', "1100");
        BINARY_VALUES.put('d', "1101");
        BINARY_VALUES.put('e', "1110");
        BINARY_VALUES.put('f', "1111");
    }

    public static String encode(char testc) {
        StringBuilder binaryBuilder = new StringBuilder();
        int i = testc;
        String hex = "";
        for (int one = 0; one < HEX_VALUES.length(); one++) {
            for (int two = 0; two < HEX_VALUES.length(); two++) {
                if (((one * 16) + two) != i) continue;
                String hex1 = String.valueOf(HEX_VALUES.charAt(one));
                String hex2 = String.valueOf(HEX_VALUES.charAt(two));
                System.out.println(hex1 + hex2);
                hex = hex1 + hex2;
                break;
            }
        }
        String bin1 = BINARY_VALUES.get(hex.charAt(0));
        String bin2 = BINARY_VALUES.get(hex.charAt(1));
        String binary = bin1 + bin2;
        binaryBuilder.append(binary);
        return binaryBuilder.toString();
    }

    public static String encode(File f) throws IOException {
        StringBuilder content = new StringBuilder();
        for (byte b : Files.readAllBytes(f.toPath()))
            content.append(getBits(b));
        return content.toString();
    }

    private static String getBits(byte b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++)
            result.append((b & (1 << i)) == 0 ? "0" : "1");
        return result.toString();
    }

    private static void ga9() {}

}
