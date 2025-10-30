package org.example;

/**
 * Класс {@code Container} реализует простой контейнер для хранения произвольного количества объектов.
 *
 * <p>Контейнер использует внутренний массив и автоматически увеличивает его размер
 * при переполнении. Поддерживаются операции добавления, извлечения, изменения,
 * удаления и полной очистки элементов.</p>
 *
 *
 * <p>Данный класс предназначен для демонстрации работы с динамическими массивами
 * без использования встроенных коллекций Java.</p>
 *
 * @author Твоё_Имя
 * @version 1.0
 */
public class Container {

    /** Внутренний массив для хранения элементов контейнера. */
    private Object[] data;

    /** Текущее количество элементов в контейнере. */
    private int size;

    /**
     * Создаёт новый пустой контейнер начальной ёмкостью 10 элементов.
     */
    public Container() {
        data = new Object[10];
        size = 0;
    }

    /**
     * Увеличивает размер внутреннего массива в два раза.
     * <p>Метод вызывается автоматически при переполнении контейнера.</p>
     */
    public void growMas() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Добавляет элемент в конец контейнера.
     * <p>Если внутренний массив заполнен, его размер увеличивается автоматически.</p>
     *
     * @param element элемент, который нужно добавить
     */
    public void addElement(Object element) {
        if (size == data.length) {
            growMas();
        }
        data[size] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента (начиная с 0)
     * @return объект, находящийся по указанному индексу
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше текущего размера контейнера
     */
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        return data[index];
    }

    /**
     * Заменяет элемент по указанному индексу.
     *
     * @param index индекс, по которому нужно установить новый элемент
     * @param element новый элемент
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше текущего размера контейнера
     */
    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        data[index] = element;
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     *
     * @return количество элементов
     */
    public int getSize() {
        return size;
    }

    /**
     * Удаляет элемент по указанному индексу.
     * <p>После удаления элементы, стоящие справа, сдвигаются влево.</p>
     *
     * @param index индекс элемента, который нужно удалить
     * @throws IndexOutOfBoundsException если индекс меньше 0 или больше текущего размера контейнера
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
    }

    /**
     * Полностью очищает контейнер, удаляя все элементы.
     * <p>После вызова метода размер контейнера становится равным 0.</p>
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
}
