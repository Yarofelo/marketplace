package ru.inno.market;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.inno.market.model.Category;
import ru.inno.market.model.Client;
import ru.inno.market.model.Item;
import ru.inno.market.model.Order;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    Client newClient;
    Item newItem;
    Order newOrder;

    @Before
    public void setUp() {
        newClient = new Client(1, "Dima");
        newItem = new Item(1, "Apple MacBook Air 13 2020", Category.LAPTOPS, 89990);
        newOrder = new Order(1, newClient);
    }

    @Test
    public void shouldEnterClient() {
        Client enter = newOrder.getClient();
        assertEquals(newClient, enter);
    }

    @After
    public void remove() {
        newOrder = null;
        newClient = null;
    }
}