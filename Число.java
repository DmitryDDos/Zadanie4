public class Число implements Сравнимое<Число> {
    private int значение;

    public Число(int значение) {
        this.значение = значение;
    }

    @Override
    public int сравнить(Число другоеЧисло) {
        return Integer.compare(this.значение, другоеЧисло.значение);
    }

    public int getЗначение() {
        return значение;
    }
}
