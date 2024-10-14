package org.knit.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TypingSpeedApp {
    public void start(String wordsPath) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        List<String> dictWords = getWords(wordsPath);
        List<String> inputttedWords = new ArrayList<>();
        int randomWordsCount = 0;
        long startTimeMillis = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - startTimeMillis >= 60_000)
                break;

            String randomWord = getRandomWord(dictWords);
            randomWordsCount += 1;
            System.out.println("Слово: " + randomWord);
            String inputtedWord = scanner.nextLine();
            if (inputtedWord.equals(randomWord)) {
                inputttedWords.add(inputtedWord);
                System.out.println("Счет (+1): " + inputttedWords.size());
            } else {
                System.out.println("Ошибочный ввод");
            }
            System.out.println();
        }


        System.out.println(
                "Всего было слов " +
                        randomWordsCount
        );
        System.out.println(
                "Итоговый счет: " +
                        inputttedWords.size()
        );
        System.out.println(
                "Количество введенных символов: " +
                        String.join("", inputttedWords).length()
        );
        System.out.println(
                "Скорость печати: " +
                         String.join("", inputttedWords).length() / 60 +
                        " симв/сек"
        );
    }

    private static List<String> getWords(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();
        return words;
    }

    private String getRandomWord(List<String> words) {
        Random rnd = new Random();
        return words.get(rnd.nextInt(words.size()));
    }
}
