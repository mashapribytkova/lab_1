import org.example.Container;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности класса Container.
 * Содержит unit-тесты для всех основных операций контейнера.
 */
public class ContainerTest {

    private Container container;

    /**
     * Инициализация тестового окружения перед каждым тестом.
     * Создает новый экземпляр Container для изоляции тестов.
     */
    @BeforeEach
    void setUp() {
        container = new Container();
    }

    /**
     * Тестирует добавление элементов в контейнер и их последующее получение.
     * Проверяет корректность работы методов addElement() и get().
     */
    @Test
    void testAddAndGetElement() {
        container.addElement("A");
        container.addElement("B");
        container.addElement("C");

        assertEquals(3, container.getSize());
        assertEquals("A", container.get(0));
        assertEquals("B", container.get(1));
        assertEquals("C", container.get(2));
    }

    /**
     * Тестирует изменение элемента контейнера по индексу.
     * Проверяет корректность работы метода set().
     */
    @Test
    void testSetElement() {
        container.addElement("A");
        container.addElement("B");

        container.set(1, "Z");
        assertEquals("Z", container.get(1));
    }

    /**
     * Тестирует автоматическое увеличение размера внутреннего массива
     * при добавлении элементов сверх начальной емкости.
     * Проверяет работу метода growMas().
     */
    @Test
    void testGrow() {
        // заполняем до переполнения
        for (int i = 0; i < 15; i++) {
            container.addElement(i);
        }
        assertEquals(15, container.getSize());
        assertEquals(0, container.get(0));
        assertEquals(14, container.get(14));
    }

    /**
     * Тестирует удаление элемента контейнера по индексу.
     * Проверяет корректность работы метода remove(int index).
     */
    @Test
    void testRemoveByIndex() {
        container.addElement("A");
        container.addElement("B");
        container.addElement("C");

        container.remove(1);

        assertEquals(2, container.getSize());
        assertEquals("C", container.get(1));
    }

    /**
     * Тестирует поведение метода remove() при передаче неверного индекса.
     * Ожидается генерация исключения IndexOutOfBoundsException.
     */
    @Test
    void testRemoveByIndex_InvalidIndex() {
        container.addElement("A");
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(5));
    }

    /**
     * Тестирует очистку контейнера.
     * Проверяет, что после вызова clear() контейнер становится пустым.
     */
    @Test
    void testClear() {
        container.addElement("A");
        container.addElement("B");
        container.addElement("C");

        container.clear();

        assertEquals(0, container.getSize());
    }

    /**
     * Тестирует поведение метода get() при передаче неверного индекса.
     * Ожидается генерация исключения IndexOutOfBoundsException.
     */
    @Test
    void testGetElement_InvalidIndex() {
        container.addElement("A");
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(10));
    }

    /**
     * Тестирует поведение метода set() при передаче неверного индекса.
     * Ожидается генерация исключения IndexOutOfBoundsException.
     */
    @Test
    void testSetElement_InvalidIndex() {
        container.addElement("A");
        assertThrows(IndexOutOfBoundsException.class, () -> container.set(5, "X"));
    }
}