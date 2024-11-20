import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // менюшка
            System.out.println("Выберите действие от 0 до 7: ");
            System.out.println("1 - Задание с коробкой;");
            System.out.println("2 - Задание со сравнением;");
            System.out.println("3 - Задание с поиском максимума;");
            System.out.println("4 - Задание с функцией;");
            System.out.println("5 - Задание с фильтром;");
            System.out.println("6 - Задание с сокращением;");
            System.out.println("7 - Задание с коллекционированием;");
            System.out.println("0 - Выход из программы.");
            System.out.print("Выбранное действие: ");

            while (!scanner.hasNextInt()) { // Проверка на ввод числа
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next(); // Очистка ввода
            }
            int d = scanner.nextInt();
            System.out.println();
            if (d < 0 || d > 7) { // Проверка на диапазон допустимых значений числа
                System.out.println("Введено неверное значение!");
                continue;
            }
            switch (d) {
                case 0: // Остановка программы
                    System.out.println("Программа остановлена.");
                    return;

                case 1: // Задание с коробкой
                    // Создаем коробку для хранения целочисленного значения
                    Box<Integer> integerBox = new Box<>();

                    // Проверяем, пуста ли коробка до размещения
                    System.out.println("Коробка пуста до размещения: " + integerBox.isEmpty());

                    // Размещаем число 3 в коробке
                    integerBox.put(3);
                    System.out.println("Разместили число 3 в коробку");

                    // Проверяем, пуста ли коробка после размещения
                    System.out.println("Коробка пуста после размещения: " + integerBox.isEmpty());

                    // Попытка положить еще одно значение в коробку
                    try {
                        System.out.println("Попытка положить число 5 в коробку.");
                        integerBox.put(5);
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }

                    // Извлекаем значение из коробки
                    Integer value = integerBox.get();
                    System.out.println("Получаем число " + value + " из коробки");

                    // Проверяем, пуста ли коробка после извлечения
                    System.out.println("Коробка пуста после извлечения: " + integerBox.isEmpty());
                    System.out.println("Ссылка на объект обнулена.");


                    // Выводим извлеченное значение на экран
                    System.out.println("Извлеченное значение: " + value);

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 2: // Задание со сравнением
                    // Создаем 2 пустых числа
                    Число число1 = null;
                    Число число2 = null;

                    // Ввод первого числа
                    while (число1 == null) {
                        System.out.print("Введите первое целое число: ");
                        if (scanner.hasNextInt()) {
                            int значение1 = scanner.nextInt();
                            число1 = new Число(значение1);
                        } else {
                            System.out.println("Ошибка: введенное значение не является целым числом.");
                            scanner.next(); // очищаем неверный ввод
                        }
                    }

                    // Ввод второго числа
                    while (число2 == null) {
                        System.out.print("Введите второе целое число: ");
                        if (scanner.hasNextInt()) {
                            int значение2 = scanner.nextInt();
                            число2 = new Число(значение2);
                        } else {
                            System.out.println("Ошибка: введенное значение не является целым числом.");
                            scanner.next(); // очищаем неверный ввод
                        }
                    }

                    // Сравнение двух чисел
                    int результатСравнения = число1.сравнить(число2);

                    if (результатСравнения < 0) {
                        System.out.println(число1.getЗначение() + " меньше " + число2.getЗначение());
                    } else if (результатСравнения > 0) {
                        System.out.println(число1.getЗначение() + " больше " + число2.getЗначение());
                    } else {
                        System.out.println(число1.getЗначение() + " равно " + число2.getЗначение());
                    }

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 3: // Задание с поиском максимума
                    List<Box<? extends Number>> boxes = new ArrayList<>(); // Список для хранения коробок
                    System.out.print("Введите количество коробок для поиска максимума: "); // Запрашиваем у пользователя количество коробок
                    while (!scanner.hasNextInt()) {
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка неверного ввода
                    }
                    int количествоКоробок = scanner.nextInt();

                    // Заполнение списка коробок
                    for (int i = 0; i < количествоКоробок; i++) {
                        System.out.print("Введите значение для коробки " + (i + 1) + ": ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Ошибка! Введите число: ");
                            scanner.next(); // Очистка неверного ввода
                        }
                        double значениеКоробки = scanner.nextDouble();
                        Box<Double> box = new Box<>();
                        box.put(значениеКоробки);
                        boxes.add(box);
                    }

                    // Находим максимальное значение
                    double максимальноеЗначение = findMaxValue(boxes);
                    System.out.println("Максимальное значение среди коробок: " + максимальноеЗначение);

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 4: // Задание с функцией
                    List<Integer[]> moreArrays = new ArrayList<>(); // Создаём пустой список для массивов
                    System.out.print("Введите количество массивов: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка неверного ввода
                    }
                    int количествоМассивов = scanner.nextInt();

                    // Заполнение списка массивов
                    for (int i = 0; i < количествоМассивов; i++) {
                        System.out.print("Введите размер массива " + (i + 1) + ": ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Ошибка! Введите целое число: ");
                            scanner.next(); // Очистка неверного ввода
                        }
                        int размерМассива = scanner.nextInt();
                        Integer[] массив = new Integer[размерМассива]; // Изменяем на Integer[]

                        for (int j = 0; j < размерМассива; j++) {
                            System.out.print("Введите элемент " + (j + 1) + ": ");
                            while (!scanner.hasNextInt()) {
                                System.out.print("Ошибка! Введите целое число: ");
                                scanner.next(); // Очистка неверного ввода
                            }
                            массив[j] = scanner.nextInt(); // Сохраняем значение как Integer
                        }
                        moreArrays.add(массив);
                    }

                    // Получаем максимальные значения из массивов
                    List<Integer> maxValues = transform(moreArrays, arr -> {
                        int max = 0;
                        for (Integer num : arr) { // Изменяем на Integer
                            if (num > max) {
                                max = num; // Находим максимальное значение в массиве
                            }
                        }
                        return max; // Возвращаем максимальное значение
                    });

                    System.out.println("Максимальные значения из массивов: " + maxValues); // Выводим максимальные значения

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 5: // Задание с фильтрацией
                    while (true) {
                        System.out.println("Выберите тип фильтрации (введите 0 для выхода):");
                        System.out.println("1 - Фильтрация строк (длина >= 3)");
                        System.out.println("2 - Фильтрация чисел (неположительные)");
                        System.out.println("3 - Фильтрация массивов (без положительных элементов)");
                        System.out.print("Ваш выбор: ");

                        int filterChoice = scanner.nextInt();

                        if (filterChoice == 0) {
                            System.out.println("Выход из фильтрации.");
                            break; // Выход из цикла фильтрации
                        }

                        switch (filterChoice) {
                            case 1:
                                List<String> strings = List.of("qwerty", "asdfg", "zx");
                                List<String> filteredStrings = filter(strings, str -> str.length() >= 3);
                                System.out.println("Отфильтрованные строки: " + filteredStrings);
                                break;

                            case 2:
                                List<Integer> numbers = List.of(1, -3, 7);
                                List<Integer> filteredNumbers = filter(numbers, num -> num <= 0);
                                System.out.println("Отфильтрованные числа: " + filteredNumbers);
                                break;

                            case 3:
                                List<Integer[]> arrays = new ArrayList<>();
                                arrays.add(new Integer[]{1, -1, -2});
                                arrays.add(new Integer[]{-3, -4});
                                arrays.add(new Integer[]{2, 3});
                                arrays.add(new Integer[]{-5, -6});
                                List<Integer[]> filteredArrays = filter(arrays, arr -> {
                                    for (Integer num : arr) {
                                        if (num > 0) {
                                            return false; // Если есть положительный элемент, возвращаем false
                                        }
                                    }
                                    return true; // Если положительных нет, возвращаем true
                                });

                                // Выводим отфильтрованные массивы
                                System.out.println("Отфильтрованные массивы:");
                                for (Integer[] filteredArray : filteredArrays) {
                                    System.out.println(Arrays.toString(filteredArray)); // Выводим каждый отфильтрованный массив
                                }
                                break;

                            default:
                                System.out.println("Неверный выбор фильтрации.");
                                break;
                        }
                        System.out.println(); // Оставляем пустую строку для красоты
                    }
                    break;

                case 6: // Задание с сокращением
                    // 1: Объединение строк
                    List<String> stringList = List.of("qwerty", "asdfg", "zx");
                    String concatenatedString = reduce(stringList, (list) -> {
                        StringBuilder sb = new StringBuilder(); // Используем StringBuilder для формирования новой строки
                        for (String str : list) { // Добавляем из списка строки в новую строку
                            sb.append(str);
                        }
                        return sb.toString();
                    });
                    System.out.println("1. Объединенная строка: " + concatenatedString);

                    // 2: Сумма чисел
                    List<Integer> numberList = List.of(1, -3, 7);
                    Integer sum = reduce(numberList, (list) -> {
                        int total = 0;
                        for (Integer num : list) {
                            total += num;
                        }
                        return total;
                    });
                    System.out.println("2. Сумма чисел: " + sum);

                    // 3: Общее количество элементов в списках
                    List<List<Integer>> listOfLists = List.of(
                            List.of(1, 2, 3),
                            List.of(4, 5),
                            List.of(6, 7, 8, 9)
                    );

                    // Здесь мы используем reduce для подсчета общего количества элементов
                    Integer totalCount = reduce(listOfLists, (lists) -> {
                        int count = 0; // Начинаем с нуля
                        for (List<Integer> innerList : lists) {
                            count += innerList.size(); // Суммируем размеры всех вложенных списков
                        }
                        return count; // Возвращаем общее количество элементов
                    });
                    System.out.println("3. Общее количество элементов: " + totalCount);

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 7: // Задание с коллекционированием
                    // 1. Разделение на положительные и отрицательные числа
                    List<Integer> numbers = List.of(1, -3, 7); // Создаем список из целых чисел
                    Map<Boolean, List<Integer>> splitNumbers = splitCollection(
                            numbers, // Список, который нужно разделить
                            () -> new ArrayList<>(), // Используем лямбда-выражение для создания нового ArrayList
                            num -> num > 0 // Условие для разделения
                    );

                    System.out.println("Положительные числа: " + splitNumbers.get(true));
                    System.out.println("Отрицательные числа: " + splitNumbers.get(false));

                    // 2. Группировка строк по длине
                    List<String> strings = List.of("qwerty", "asdfg", "zx", "qw");
                    Map<Integer, List<String>> groupedStrings = groupByLength(
                            strings, // Список строк, который нужно сгруппировать.
                            () -> new ArrayList<>() // Способ создания нового списка для каждой группы.
                    );

                    System.out.println("Строки, сгруппированные по длине:");
                    for (Map.Entry<Integer, List<String>> entry : groupedStrings.entrySet()) {
                        System.out.println("Длина " + entry.getKey() + ": " + entry.getValue());
                    }

                    // 3. Уникальные строки
                    List<String> uniqueStrings = List.of("qwerty", "asdfg", "qwerty", "qw");
                    Set<String> uniqueSet = getUniqueSet(
                            uniqueStrings, // Исходный список, из которого нужно получить уникальные значения.
                            () -> new HashSet<>() // Способ создания нового набора
                    );

                    System.out.println("Уникальные строки: " + uniqueSet);

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;
            }
        }
    }

    public static double findMaxValue(List<Box<? extends Number>> boxes) { // метод для поиска максимального значения из коробок из списка
        double max = 0; // Начальное значение для максимума

        for (Box<? extends Number> box : boxes) { // Проверяем все коробки и находим максимальное значение
            if (!box.isEmpty()) { // Проверяем, что коробка не пустая
                double value = box.get().doubleValue(); // Получаем значение и преобразуем в double
                if (value > max) {
                    max = value; // Обновляем максимум
                }
            }
        }
        return max;
    }

    // Метод преобразования
    public static <T, P> List<P> transform(List<T[]> inputList, Function<T[], P> function) {
        List<P> resultList = new ArrayList<>(); // Создаём пустой Р-список
        for (T[] item : inputList) { // Проходим по каждому массиву в списке
            resultList.add(function.apply(item)); // Применяем функцию к элементу и добавляем в новый список
        }
        return resultList;
    }

    // Метод фильтрации
    public static <T> List<T> filter(List<T> inputList, Predicate<T> predicate) {
        List<T> resultList = new ArrayList<>(); // Создаём пустой результирующий список
        for (T item : inputList) { // Проходимся по списку
            if (predicate.test(item)) { // Проверяем условие
                resultList.add(item); // Если условие выполнено, добавляем элемент в результат
            }
        }
        return resultList; // Возвращаем отфильтрованный список
    }

    // Метод Сокращения
    public static <T, R> R reduce(List<T> list, Function<List<T>, R> reducer) {
        if (list == null || list.isEmpty()) { // Проверяем, пуст ли список
            return null; // Возвращаем null или значение по умолчанию в зависимости от ваших требований
        }
        return reducer.apply(list); // Применение функции reducer к переданному списку
    }


    // Метод для возврата значения по умолчанию в зависимости от типа T
    @SuppressWarnings("unchecked") //  Подавляем предупреждения компилятора о небезопасных операциях, связанных с приведением типов.
    private static <T> T getDefaultValue() {
        return (T) (Integer) 0; // Возвращаем 0 для Integer и других типов
    }

    // Метод для разделения коллекции
    public static <T, P extends Collection<T>> Map<Boolean, P> splitCollection(
            List<T> source, // Список, который нужно разделить
            Supplier<P> collectionSupplier, // Способ создания новой коллекции
            Predicate<T> predicate // предикат (условие)
    ) {
        Map<Boolean, P> result = new HashMap<>(); // Создается Map<Boolean, P>, где true соответствует подколлекции, удовлетворяющей условию, а false — остальным элементам.
        result.put(true, collectionSupplier.get());
        result.put(false, collectionSupplier.get());

        for (T item : source) { // Проходится по каждому элементу исходного списка
            result.get(predicate.test(item)).add(item);
        }

        return result;
    }

    // Метод для группировки строк по длине
    public static Map<Integer, List<String>> groupByLength(
            List<String> source, // Список строк, который нужно сгруппировать.
            Supplier<List<String>> collectionSupplier) { // Способ создания нового списка для каждой группы.
        Map<Integer, List<String>> result = new HashMap<>(); // Создается Map<Integer, List<String>>, где ключ — это длина строки, а значение — список строк этой длины.

        for (String str : source) { //  Используется метод computeIfAbsent, который добавляет строку в соответствующий список, создавая новый список, если ключ (длина) отсутствует.
            result.computeIfAbsent(str.length(), k -> collectionSupplier.get()).add(str);
        }

        return result;
    }

    // Метод для получения уникальных значений
    public static <T> Set<T> getUniqueSet(
            List<T> source, // Исходный список, из которого нужно получить уникальные значения.
            Supplier<Set<T>> collectionSupplier) { // Способ создания нового набора
        Set<T> resultSet = collectionSupplier.get(); // Создается новый набор
        for (T item : source) { // Проходится по каждому элементу исходного списка и добавляет его в набор, не допуская дубликатов
            resultSet.add(item);
        }
        return resultSet;
    }
}