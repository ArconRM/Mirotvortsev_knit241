package org.knit;

import org.knit.lab5.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Task9();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Task9() throws FileNotFoundException {
        TypingSpeedApp app = new TypingSpeedApp();
        app.start("assets/dictionary.txt");
    }

//    private static void Task8() {
//        ShopItemGenerator generator = new ShopItemGenerator();
//        ShopItem[] shopItems = generator.generateShopItems(100);
//
//        System.out.println("По наименованию");
////        Arrays.sort(shopItems, new ShopItemNameComparator());
//        Arrays.sort(shopItems, Comparator.comparing(ShopItem::getName).thenComparing(ShopItem::getPrice));
//
//        for (ShopItem item : shopItems) {
//            System.out.println(item);
//        }

//        System.out.println("\nПо цене");
//        Arrays.sort(shopItems, new ShopItemPriceComparator());
//
//        for (ShopItem item : shopItems) {
//            System.out.println(item);
//        }

//        countEqual(shopItems);
//    }

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
