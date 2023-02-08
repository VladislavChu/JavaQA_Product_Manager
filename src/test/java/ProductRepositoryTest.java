import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product item1 = new Book(1, "На фронте Бес перемен", 210, "Центр принятия решений");
    Product item2 = new Smartphone(2, "VladiIzKastbl", 48_200, "Apple");
    Product item3 = new Product(3, "Сахар", 99);
    Product item4 = new Product(4, "Хлеб", 72);
    Product item5 = new Product(5, "Что-то непонятное", 1_000);
    Product item6 = new Product(6, "Javi с говядиной", 75);


    @Test
    public void shouldAddItems() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Product[] expected = {item1, item2, item3, item4, item5, item6};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        repo.removeById(item3.getId());
        repo.removeById(item6.getId());

        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


}
