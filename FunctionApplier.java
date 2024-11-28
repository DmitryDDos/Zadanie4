import java.util.ArrayList;
import java.util.List;

public class FunctionApplier {

    // Метод для применения функции к каждому элементу списка
    public static <T, P> List<P> applyFunction(List<T> values, Function<T, P> function) {
    // Обобщенный метод работает с данными Т и Р, принимая список входных значений List<T>, а затем передаёт нужные Т в функцию Function
        // (эта функция реализует интерфейс) и возвращает результат в список List <P>
        List<P> result = new ArrayList<>(); // Создаём пустой результирующий список
        for (T value : values) { // Проходимся по входным обобщенным данным
            result.add(function.apply(value)); // Применяем функцию и добавляем результат в новый список
        }
        return result;
    }

    // Интерфейс для функции, принимающей T и возвращающей P
    @FunctionalInterface // Аннотация, что это функциональный интерфейс (интерфейс, который содержит только один абстрактный метод)
    public interface Function<T, P> {
        P apply(T value); // Метод принимает значение T и возвращает значение типа Р
    }
}