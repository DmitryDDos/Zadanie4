import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static <T> List<T> filter(List<T> values, Predicate<T> predicate) {
    // Обобщенный метод принимает список List <T> и функциональный интерфейс, который определяет условие для фильтрации (возвращает true | false)
        List<T> result = new ArrayList<>(); // Создаем пустой список с входными обобщенными данными Т
        for (T value : values) { // Проходимся по заданным данным из входного списка values
            if (predicate.test(value)) { // Если условие выполняется, то добавляем только те элементы, которые прошли проверку
                result.add(value);
            }
        }
        return result;
    }
}
