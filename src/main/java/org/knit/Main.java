package org.knit;

import org.knit.semestr2.lab2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
//        Task2_6();
//        Task2_7();
//        Task2_8();
//        Task2_9();
        Task2_10();
    }

    static void Task2_10() {
        final int COUNT_OF_RUNNERS = 10;
        CyclicBarrier barrier = new CyclicBarrier(COUNT_OF_RUNNERS);
        AtomicBoolean allAlive = new AtomicBoolean(true);
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_OF_RUNNERS);

        List<Runner> runners = new ArrayList<>(COUNT_OF_RUNNERS);
        for (int i = 0; i < COUNT_OF_RUNNERS; i++) {
            runners.add(new Runner(allAlive, barrier, i));
        }

        for (int i = 0; i < COUNT_OF_RUNNERS; i++) {
            executor.submit(runners.get(i)::prepareForStart);
        }
        try {
            barrier.await();
            System.out.println("Все приготовились, гонка началась");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < COUNT_OF_RUNNERS; i++) {
            executor.submit(runners.get(i)::run);
        }
        try {
            barrier.await();
            if (allAlive.get()) {
                System.out.println("Все добежали, гонка закончилась");
            } else {
                System.out.println("Гонка закончилась из-за травмы бегуна");
                executor.shutdown();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
//            System.out.println("Гонка закончилась из-за травмы бегуна");
//            executor.shutdownNow();
        }

        executor.shutdownNow();
    }

    static void Task2_8() {
        TrafficLight trafficLight = new TrafficLight();

        Thread threadTrafficLight = new Thread(() -> {
            while (true) {
                trafficLight.changeColor();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadCar = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                Car car = new Car(String.valueOf(i));
                car.pass(trafficLight);
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadTrafficLight.start();
        threadCar.start();
    }

    static void Task2_7() {
        Warehouse warehouse = new Warehouse();

        Thread threadManufacturer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                warehouse.addProduct(String.valueOf(i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadBuyer = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                warehouse.buyProduct();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadManufacturer.start();
        threadBuyer.start();
    }

    static void Task2_6() {
        Railway railway = new Railway();

        Thread threadCars = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                railway.passCar(i + " машина");
            }
        });

        Thread threadTrain = new Thread(() -> {
            try {
                Thread.sleep(2000);
                railway.trainIsPassing();
                Thread.sleep(2000);
                railway.trainPassed();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadCars.start();
        threadTrain.start();
    }

    static void Task2_9() {
        Factory factory = new Factory();
        factory.initProduction();
    }

    static void Task2_5() {
        Restaraunt restaraunt = new Restaraunt();

        Thread threadCooker = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaraunt.cook("Блюдо " + i);
            }
        });

        Thread threadWaiter = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                restaraunt.serve();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadCooker.start();
        threadWaiter.start();
    }

    static void Task2_4() {
        GasStation gasStation = new GasStation(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                gasStation.Refuel(String.valueOf(finalI) + " машина");
            }).start();
        }
    }
}

//    public static void Task3() {
//        TransportFactory transportFactory = new TransportFactory();
//        System.out.println(transportFactory.makeTransport("business").getSpecifications());
//        System.out.println(transportFactory.makeTransport("family").getSpecifications());
//        System.out.println(transportFactory.makeTransport("delivery").getSpecifications());
//    }
//
//    private static void Task2() {
//        Coffee coffee = new Espresso();
//        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost());
//
//        // Добавляем размер (medium)
//        coffee = new SizeDecorator(coffee, CoffeeSize.MEDIUM);
//        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost());
//
//        // Добавляем молоко
//        coffee = new Milk(coffee);
//        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost());
//
//        // Добавляем карамель
//        coffee = new Caramel(coffee);
//        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost());
//
//        // Добавляем шоколад
//        coffee = new Chocolate(coffee);
//        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost());
//    }
//
//    private static void Task1() {
//        Handler callCenter = new CallCenter();
//        Handler manager = new Manager();
//        Handler legalDepartment = new LegalDepartment();
//
//        callCenter.setNextHandler(manager);
//        manager.setNextHandler(legalDepartment);
//
//        callCenter.processRequest(Difficulty.EASY);
//        callCenter.processRequest(Difficulty.MEDIUM);
//        callCenter.processRequest(Difficulty.HARD);
//        callCenter.processRequest(Difficulty.TOTALLY_FUCKED);
//    }

//    private static void Task25() {
//        try (Connection conn = DbConnection.getConnection()) {
//            FileDAO fileDAO = new FileDAOImpl(conn);
//            FileApp fileApp = new FileApp(fileDAO);
//            fileApp.start();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void Task24() {
//        try (Connection conn = DbConnection.getConnection()) {
//            UserDAO userDAO = new UserDAOImpl(conn);
//            UserService userService = new UserServiceImpl(userDAO);
//            UserManager userManager = new UserManager(userService);
//            userManager.start();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

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
//        System.out.println(wordsCount);
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
//        for (String word : words) {
//            System.out.println(word);
//        }
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
//        System.out.println(dictionaryStatistic.getMaxWordLength());
//        System.out.println(dictionaryStatistic.getMinWordLength());
//        dictionaryStatistic.printSymbolsStat();
//        System.out.println(dictionaryStatistic.getRandomWord());
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
//        }fsdfsdfsdf
