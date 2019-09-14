package com.usaa.CodingChallenge.Service;

import com.usaa.CodingChallenge.Repo.USAACodingChallengeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Service
public class USAACodingChallengeService {

    private static final Logger logger = LogManager.getLogger(USAACodingChallengeService.class);

    @Autowired
    private USAACodingChallengeRepository usaaCodingChallengeRepository;

    public String question1(String question1Input) {
        Scanner scan = new Scanner(question1Input);
        StringBuilder secretPassword = new StringBuilder();

        while(scan.hasNextLine()) {

            String[] currentLine = scan.nextLine().split(" ");
            for (int i = 0; i < currentLine.length; i++) {

                String normal = currentLine[i];
                String reverse = new StringBuilder(currentLine[i]).reverse().toString();

                if (normal.equals(reverse)) {
                    secretPassword.append(normal.charAt(i));
                }
            }
        }

        return usaaCodingChallengeRepository.getAnswer(secretPassword.toString());
    }

    public byte[] question2(String question2Input) {
        byte[] byteArray = usaaCodingChallengeRepository.getImage(question2Input);
        return encrypt_decrypt(byteArray);
    }

    private static byte[] encrypt_decrypt(byte[] bytes) {
        byte enc = 1;
        int i = 0;
        byte[] result_array = new byte[bytes.length];
        for (byte b : bytes) {
            result_array[i] = (byte)(b ^ enc);
            i++;
        }
        return result_array;
    }

    public String question3() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> kLengthCombinations = getAllKLengthCombinations(alphabet, 3);
        String result = null;
        for(String s : kLengthCombinations) {
            String key = sha1Convert(s);
            if(!usaaCodingChallengeRepository.getAnswer(key).isEmpty()) {
                result = usaaCodingChallengeRepository.getAnswer(key);
            }
        }
        return result;
    }

    private List<String> getAllKLengthCombinations(char[] set, int k)
    {
        int n = set.length;
        List<String> results = new LinkedList<>();
        getAllKLengthCombinations(set, "", n, k, results);
        return results;
    }

    private void getAllKLengthCombinations(char[] set, String prefix, int n, int k, List<String> results) {
        if (k == 0) {
            results.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            getAllKLengthCombinations(set, newPrefix, n, k - 1, results);
        }
    }

    private static String sha1Convert(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(input.getBytes(StandardCharsets.UTF_8));

            //return the sha1 String
            return String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException  e) {
            throw new RuntimeException(e);
        }
    }
}
