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
                    double максимальноеЗначение = findMaxValue.FindMaxValue(boxes);
                    System.out.println("Максимальное значение среди коробок: " + максимальноеЗначение);

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 4:
                    //Получение длины строк
                    List<String> strings = List.of("qwerty", "asdfg", "zx");
                    System.out.println("Изначальные списки: " + strings);
                    List<Integer> lengths = FunctionApplier.applyFunction(strings, String::length);
                    System.out.println("Длины строк: " + lengths);

                    //Преобразование отрицательных чисел в положительные
                    List<Integer> numbers = List.of(1, -3, 7);
                    System.out.println("Изначальные числа: " + numbers);
                    List<Integer> absoluteValues = FunctionApplier.applyFunction(numbers,
                            Math::abs); // Используем модуль числа
                    System.out.println("Абсолютные значения: " + absoluteValues);

                    //Получение максимальных значений из массивов
                    List<int[]> arrays = List.of(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{4, 5});
                    System.out.println("Изначальные массивы целых чисел: " + Arrays.deepToString(arrays.toArray(new int[0][])));
                    List<Integer> maxValues = FunctionApplier.applyFunction(arrays,
                            array -> {
                                int max = Integer.MIN_VALUE;
                                for (int num : array) {
                                    if (num > max) {
                                        max = num;
                                    }
                                }
                                return max;
                            });
                    System.out.println("Максимальные значения из массивов: " + maxValues);

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 5: // Задание с фильтром
                    //Фильтрация строк с длиной менее 3 символов
                    List<String> strings1 = List.of("qwerty", "asdfg", "zx");
                    System.out.println("Изначальные строки: " + strings1);
                    List<String> filteredStrings = Filter.filter(strings1, s -> s.length() >= 3);
                    System.out.println("Отфильтрованные строки (длина >= 3): " + filteredStrings);

                    //Фильтрация положительных чисел
                    List<Integer> numbers1 = List.of(1, -3, 7);
                    System.out.println("Изначальные числа: " + numbers1);
                    List<Integer> filteredNumbers = Filter.filter(numbers1, n -> n < 0);
                    System.out.println("Отфильтрованные отрицательные числа: " + filteredNumbers);

                    //Фильтрация массивов целых чисел, в которых нет положительных элементов
                    List<int[]> arrays1 = List.of(new int[]{1, -2, 3}, new int[]{-1, -2, -3}, new int[]{-4, -5});
                    System.out.println("Изначальные массивы целых чисел: " + Arrays.deepToString(arrays1.toArray(new int[0][])));
                    List<int[]> filteredArrays = Filter.filter(arrays1, array -> {
                        for (int num : array) {
                            if (num > 0) {
                                return false; // Если есть положительный элемент, возвращаем false
                            }
                        }
                        return true; // Если положительных элементов нет, возвращаем true
                    });

                    // Преобразование списка массивов в массив массивов
                    int[][] resultArray = filteredArrays.toArray(new int[0][]);
                    System.out.println("Отфильтрованные массивы (без положительных элементов): " + Arrays.deepToString(resultArray));

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 6: // Задание с сокращением
                    //Объединение строк
                    List<String> strings2 = List.of("qwerty", "asdfg", "zx");
                    System.out.println("Изначальные строки: " + strings2); // Выводим изначальные строки
                    String concatenatedString = Reducer.reduce(strings2, (s1, s2) -> s1 + s2);
                    System.out.println("Объединенные строки: " + concatenatedString);

                    //Суммирование чисел
                    List<Integer> numbers2 = List.of(1, -3, 7);
                    System.out.println("Изначальные числа: " + numbers2); // Выводим изначальные числа
                    Integer sum = Reducer.reduce(numbers2, Integer::sum);
                    System.out.println("Сумма чисел: " + sum);

                    //Подсчет общего количества элементов в списках
                    List<List<Integer>> listOfLists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of(6));
                    System.out.println("Изначальные списки: " + listOfLists); // Выводим изначальные списки
                    Integer totalCount = Reducer.reduce(listOfLists, (list1, list2) -> {
                        List<Integer> mergedList = new ArrayList<>(list1); // Создаем изменяемый список на основе list1
                        mergedList.addAll(list2); // Объединяем с list2
                        return mergedList; // Возвращаем объединенный список
                    }).size();
                    System.out.println("Общее количество элементов во всех списках: " + totalCount);

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 7:
                    //Разделение на положительные и отрицательные числа
                    List<Integer> numbers3 = List.of(1, -3, 7);
                    System.out.println("Изначальные числа: " + numbers3);
                    Map<Boolean, List<Integer>> partitionedNumbers = Collector.partition(numbers3, n -> n > 0);
                    System.out.println("Положительные числа: " + partitionedNumbers.get(true));
                    System.out.println("Отрицательные числа: " + partitionedNumbers.get(false));
                    System.out.println(); // Оставляем пустую строку для красоты

                    //Группировка строк по длине
                    List<String> strings3 = List.of("qwerty", "asdfg", "zx", "qw");
                    System.out.println("Изначальные строки: " + strings3);
                    Map<Integer, List<String>> groupedStrings = Collector.groupByLength(strings3);
                    System.out.println("Группировка строк по длине: " + groupedStrings);
                    System.out.println(); // Оставляем пустую строку для красоты

                    //Создание набора без дубликатов
                    List<String> duplicateStrings = List.of("qwerty", "asdfg", "qwerty", "qw");
                    System.out.println("Изначальные строки с дубликатами: " + duplicateStrings);
                    Set<String> uniqueStrings = Collector.toSet(duplicateStrings);
                    System.out.println("Набор без дубликатов: " + uniqueStrings);
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;
            }
        }
    }
}
