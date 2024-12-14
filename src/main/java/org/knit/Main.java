package org.knit;

import org.knit.lab11.*;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Task25();
    }

    private static void Task25() {
        try (Connection conn = DbConnection.getConnection()) {
            FileDAO fileDAO = new FileDAOImpl(conn);
            FileApp fileApp = new FileApp(fileDAO);
            fileApp.start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Task24() {
        try (Connection conn = DbConnection.getConnection()) {
            UserDAO userDAO = new UserDAOImpl(conn);
            UserService userService = new UserServiceImpl(userDAO);
            UserManager userManager = new UserManager(userService);
            userManager.start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    private static void Task18() {
//        Pair<String, Integer> pair = new Pair<>("Age", 30);
//        System.out.println(pair.getFirst()); // Age
//        System.out.println(pair.getSecond()); // 30
//        pair.setSecond(35);
//        System.out.println(pair.getSecond()); // 35
//    }
//
//    private static void Task19() {
//        Integer[] numbers = {1, 2, 3, 4, 5};
//        findMax(numbers).ifPresent(System.out::println);
//
//        String[] words = {"apple", "banana", "cherry"};
//        findMax(words).ifPresent(System.out::println);
//    }
//
//    private static void Task20() {
//        Box<Integer> integerBox = new Box<>();
//        integerBox.add(10);
//        integerBox.add(20);
//        System.out.println(integerBox.sum()); // 30
//
//        Box<Double> doubleBox = new Box<>();
//        doubleBox.add(1.5);
//        doubleBox.add(2.5);
//        System.out.println(doubleBox.sum()); // 4.0
//    }
//
//    private static void Task21() {
//        List<String> words = Arrays.asList("apple", "banana", "cherry");
//        List<String> filtered = filter(words, s -> s.startsWith("b"));
//        System.out.println(filtered); // [banana]
//    }
//
//    private static void Task22() {
//        Dictionary<String, Integer> dictionary = new Dictionary<>();
//        dictionary.put("Alice", 25);
//        System.out.println(dictionary.get("Alice")); // 25
//        dictionary.put("Alice", 30);
//        System.out.println(dictionary.get("Alice")); // 30
//        dictionary.remove("йцукен");
//        System.out.println(dictionary.get("йцукен")); // :(
//    }
//
//    private static void Task23() {
//        printType(123); // java.lang.Integer
//        printType("Hello"); // java.lang.String
//    }

//    private static void Task14() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
//        TrafficLight inputtedLight = null;
//        while (inputtedLight == null) {
//            try {
//                inputtedLight = TrafficLight.valueOf(scanner.nextLine());
//                System.out.println("Следующий сигнал: " + inputtedLight.getNext());
//            } catch (Exception e) {
//                System.out.println("Некорректный ввод, давай еще раз.");
//            }
//        }
//    }
//
//    private static void Task15() {
//        for (var season : Seasons.values()) {
//            System.out.println(season.getInfo());
//        }
//    }
//
//    private static void Task16() {
//        for (var suit : Suit.values()) {
//            for (var rank: Rank.values()) {
//                System.out.println(rank.getName() + " " + suit.getName());
//            }
//        }
//    }
//
//    private static void Task17() {
//        User user = new User(null, "Очень некорректный username", 16);
//        try {
//            Validator.validate(user);
//        } catch (IllegalAccessException e) {
//            System.out.println("Выкинулось " + e);
//        }
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
