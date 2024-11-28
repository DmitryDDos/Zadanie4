import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Collector {

    // Метод для разделения элементов на две группы
    public static <T> Map<Boolean, List<T>> partition(List<T> source, Predicate<T> predicate) {
        // Этот метод принимает список элементов и условие, по которому происходит разделение
        return source.stream().collect(Collectors.partitioningBy(predicate));
        // Возвращает карту, где ключ — это булево значение (true или false), а значение — список элементов, удовлетворяющих условию
    }

    // Метод для группировки строк по длине
    public static Map<Integer, List<String>> groupByLength(List<String> source) {
        // Этот метод принимает список строк и группирует их по длине.
        return source.stream().collect(Collectors.groupingBy(String::length));
        // Возвращает карту, где ключ — это длина строки, а значение — список строк, имеющих эту длину.
    }

    // Метод для создания набора без дубликатов
    public static <T> Set<T> toSet(List<T> source) {
        // Этот метод принимает список и возвращает набор (Set).
        return new HashSet<>(source); // Удаляет дубликаты из списка
    }
}
