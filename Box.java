public class Box<T> {
    private T object;

    // Метод для размещения объекта в коробке
    public void put(T object) { // Обобщённый метод принимает входные данные Т
        if (this.object != null) { // Если коробка заполнена, то нельзя разместить другие значения
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.object = object; // Размещаем Т в коробке
    }

    // Метод для получения объекта из коробки
    public T get() { // Обобщённый метод принимает входные данные Т
        T temp = this.object; // Получаем объект из коробки
        this.object = null; // После обнуляем ссылку на объект
        return temp; // Выводим полученный объект
    }

    // Метод проверки на заполненность
    public boolean isEmpty() {
        return this.object == null;
    }
}
