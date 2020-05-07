package com.openstudio.Spring_test.functions;

import java.security.MessageDigest;
import java.util.Arrays;

public class Sha256 {
    public static String hash (byte[] bytes) {
        String hashOut = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bytes);
            byte[] digestedBytes = messageDigest.digest();

            hashOut = Arrays.toString(digestedBytes).toLowerCase();
        } catch (Exception e) {

        }

        return hashOut;
    }
}
