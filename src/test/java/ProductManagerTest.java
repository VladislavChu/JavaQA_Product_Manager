import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "На фронте Бес перемен", 210, "Центр принятия решений");
    Product item2 = new Smartphone(2, "VladiIzKastbl", 48_200, "Apple");
    Product item3 = new Product(3, "Сахар", 99);
    Product item4 = new Product(4, "Сахар", 79);
    Product item5 = new Product(5, "Что-то непонятное", 1_000);
    Product item6 = new Product(6, "Javi с говядиной", 75);


    @Test
    public void shouldSearchSomeItemsByText() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item3, item4};
        Product[] actual = manager.searchBy("Сахар");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchItemsByText() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("VladiIzKastbl");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemsByTextIfNoAdd() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Сахар");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemsByTextIfOneAdd() {
        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("На фронте Бес перемен");

        Assertions.assertArrayEquals(expected, actual);
    }
}
