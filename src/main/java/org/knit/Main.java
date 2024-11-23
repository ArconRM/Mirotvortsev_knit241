package org.knit;

import org.knit.additional.EventAnalyser;
import org.knit.lab7.FileTreeWalker;
import org.knit.lab8.UserManager;
import org.knit.lab9.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Task14();
//        Task15();
//        Task16();
        Task17();
    }

    private static void Task14() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        TrafficLight inputtedLight = null;
        while (inputtedLight == null) {
            try {
                inputtedLight = TrafficLight.valueOf(scanner.nextLine());
                System.out.println("Следующий сигнал: " + inputtedLight.getNext());
            } catch (Exception e) {
                System.out.println("Некорректный ввод, давай еще раз.");
            }
        }
    }

    private static void Task15() {
        for (var season : Seasons.values()) {
            System.out.println(season.getInfo());
        }
    }

    private static void Task16() {
        for (var suit : Suit.values()) {
            for (var rank: Rank.values()) {
                System.out.println(rank.getName() + " " + suit.getName());
            }
        }
    }

    private static void Task17() {
        User user = new User(null, "Очень некорректный username", 16);
        try {
            Validator.validate(user);
        } catch (IllegalAccessException e) {
            System.out.println("Выкинулось " + e);
        }
    }


//    private static void Task7() {
//        Scanner scanner = new Scanner(new File("src/main/java/assets/dictionary.txt"));
//        int wordsCount = 0;
//        while (scanner.hasNext()) {
//            wordsCount++;
//            scanner.nextLine();
//        }
////        System.out.println(wordsCount);
//        scanner.close();
//
//        scanner = new Scanner(new File("src/main/java/assets/dictionary.txt"));
//        String[] words = new String[wordsCount];
//        int curWordsIndex = 0;
//        while (scanner.hasNext()) {
//            words[curWordsIndex] = scanner.nextLine().toLowerCase();
//            curWordsIndex++;
//        }
//
////        for (String word : words) {
////            System.out.println(word);
////        }
//        scanner.close();
//
//        int alphabetCount = 0;
//        for (int i = 'а'; i <= 'я'; i++) {
//            alphabetCount += 1;
//        }
//
//        char[] alphabet = new char[alphabetCount];
//        int curAlphabetIndex = 0;
//        for (int i = 'а'; i <= 'я'; i++) {
//            alphabet[curAlphabetIndex] = (char) i;
//            curAlphabetIndex++;
//        }
//
//        DictionaryStatistic dictionaryStatistic = new DictionaryStatistic(words, alphabet);
////        System.out.println(dictionaryStatistic.getMaxWordLength());
////        System.out.println(dictionaryStatistic.getMinWordLength());
////        dictionaryStatistic.printSymbolsStat();
////        System.out.println(dictionaryStatistic.getRandomWord());
//        dictionaryStatistic.game("библиотека");
//    }

//    private static void countEqual(ShopItem[] shopItems) {
//        HashMap<String, Integer> itemsAndCount = new HashMap<>();
//        for (int i = 0; i < shopItems.length; i++) {
//            if (itemsAndCount.containsKey(shopItems[i].getPartNumber()))
//                continue;
//
//            itemsAndCount.put(shopItems[i].getPartNumber(), 0);
//            for (int j = i + 1; j < shopItems.length; j++) {
//                if (shopItems[i].equals(shopItems[j])) {
//                    itemsAndCount.put(shopItems[i].getPartNumber(), itemsAndCount.get(shopItems[i].getPartNumber()) + 1);
//                }
//            }
//
//            System.out.println(shopItems[i].getPartNumber());
//            System.out.println(itemsAndCount.get(shopItems[i].getPartNumber()));
//        }
//    }
}
