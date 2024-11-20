public class Box<T> {
    private T object;

    // Метод для размещения объекта в коробке
    public void put(T object) {
        if (this.object != null) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.object = object;
    }

    // Метод для получения объекта из коробки
    public T get() {
        T temp = this.object; // Получаем объект
        this.object = null; // После обнуляем ссылку на объект
        return temp;
    }

    // Метод проверки на заполненность
    public boolean isEmpty() {
        return this.object == null;
    }
}
