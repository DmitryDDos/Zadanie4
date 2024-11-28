import java.util.List;
import java.util.function.BinaryOperator;

public class Reducer {
    public static <T> T reduce(List<T> values, BinaryOperator<T> reducer) {
    // Обобщённый Т метод принимает значения из списка List<T>, а также функцию BinaryOperator<T>, определяющую, как два элемента объединяются в один.
        if (values == null || values.isEmpty()) { // Проверка на пустой список
            return null;
        }

        T result = values.getFirst(); // Начинаем с первого элемента
        for (int i = 1; i < values.size(); i++) {
            result = reducer.apply(result, values.get(i)); // Применяем функцию сокращения
        }
        return result;
    }
}
