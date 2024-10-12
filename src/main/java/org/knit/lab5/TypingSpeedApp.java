package org.knit.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedApp {
    public void start(String wordsPath) throws FileNotFoundException {
        long timeMillis = System.currentTimeMillis();
        List<String> words = getWords(wordsPath);

    }

    public static List<String> getWords(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext() && System.currentTimeMillis() ) {
            words.add(scanner.next());
        }
        scanner.close();
        return words;
    }
}
