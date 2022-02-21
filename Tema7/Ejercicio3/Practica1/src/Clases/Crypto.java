package Clases;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import java.util.Random;

public class Crypto {
    public static void testHashing() {
        String storedPassword = hashFunc("CastilloComemeLosCojones");
        System.out.println("PBKDF2 TEST HASH_FUNC - " + storedPassword);
        System.out.println("TEST OK - " + checkHash("CastilloComemeLosCojones", storedPassword));
        System.out.println("TEST NOK - " + checkHash("CastilloComemeLosHuevos", storedPassword));
    }

    public static String hashFunc(String input) {
        try {
            String salt = saltGenerator();
            int iterations = 1000;
            KeySpec spec = new PBEKeySpec(
                    input.toCharArray(),
                    Base64.getDecoder().decode(salt),
                    iterations,
                    64 * 8
            );

            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            return iterations + ":" + salt + ":" + Base64.getEncoder().withoutPadding().encodeToString(f.generateSecret(spec).getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String saltGenerator() {
        Random rd = new Random();
        byte[] arr = new byte[7];
        rd.nextBytes(arr);

        return stringtoHex(arr);
    }

    public static boolean checkHash(String input, String storedData) {

        try {
            String[] parts = storedData.split(":");
            int iterations = Integer.parseInt(parts[0]);
            byte[] salt = Base64.getDecoder().decode(parts[1]);
            byte[] hash = Base64.getDecoder().decode(parts[2]);

            PBEKeySpec spec = new PBEKeySpec(input.toCharArray(), salt, iterations, hash.length * 8);

            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            byte[] testHash = skf.generateSecret(spec).getEncoded();

            int diff = hash.length ^ testHash.length;
            for (int i = 0; i < hash.length && i < testHash.length; i++) {
                diff |= hash[i] ^ testHash[i];
            }

            return diff == 0;

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error validando contraseña");
            return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String hextoString(String hex) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = hex.toCharArray();

        for (char c : charArray) {
            String charToHex = Integer.toHexString(c);
            stringBuilder.append(charToHex);

        }
        return stringBuilder.toString();
    }

    private static String stringtoHex (String string){
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        BigInteger bigInteger = new BigInteger(1, bytes);

        return String.format("%x", bigInteger);
    }
}
