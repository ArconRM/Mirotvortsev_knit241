package org.knit;

import org.knit.lab4.DictionaryStatistic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/assets/dictionary.txt"));
        int wordsCount = 0;
        while (scanner.hasNext()) {
            wordsCount++;
            scanner.nextLine();
        }
//        System.out.println(wordsCount);
        scanner.close();

        scanner = new Scanner(new File("src/main/java/assets/dictionary.txt"));
        String[] words = new String[wordsCount];
        int curWordsIndex = 0;
        while (scanner.hasNext()) {
            words[curWordsIndex] = scanner.nextLine().toLowerCase();
            curWordsIndex++;
        }

//        for (String word : words) {
//            System.out.println(word);
//        }
        scanner.close();

        int alphabetCount = 0;
        for (int i = 'а'; i <= 'я'; i++) {
            alphabetCount += 1;
        }

        char[] alphabet = new char[alphabetCount];
        int curAlphabetIndex = 0;
        for (int i = 'а'; i <= 'я'; i++) {
            alphabet[curAlphabetIndex] = (char) i;
            curAlphabetIndex++;
        }

        DictionaryStatistic dictionaryStatistic = new DictionaryStatistic(words, alphabet);
//        System.out.println(dictionaryStatistic.getMaxWordLength());
//        System.out.println(dictionaryStatistic.getMinWordLength());
//        dictionaryStatistic.printSymbolsStat();
//        System.out.println(dictionaryStatistic.getRandomWord());
        dictionaryStatistic.game("библиотека");
    }
}
