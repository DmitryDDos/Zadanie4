import java.util.List;
public class findMaxValue {
    // Метод для нахождения максимального значения среди коробок
    public static double FindMaxValue(List<Box<? extends Number>> boxes) { // Задаем параметр метода, который принимает список коробок, которые могут содержать числа
        double max = Double.NEGATIVE_INFINITY; // Начальное значение для максимума -∞

        for (Box<? extends Number> box : boxes) { // Проходимся по коробкам из списка коробок
            if (!box.isEmpty()) { // Проверяем, что коробка не пустая
                Number value = box.get(); // Получаем значение из коробки
                if (value.doubleValue() > max) { // Сравниваем с текущим максимумом
                    max = value.doubleValue(); // Если число из коробки больше максимума, то оно становится максимумом
                }
            }
        }

        if (max == Double.NEGATIVE_INFINITY) { // Если максимум остался равен первоначальному значению
            throw new IllegalArgumentException("Все коробки пустые!");
        }

        return max; // Возвращаем максимальное значение
    }
}
