package ru.inno.market;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.inno.market.core.Catalog;
import ru.inno.market.core.MarketService;
import ru.inno.market.model.Client;

import ru.inno.market.model.Item;
import ru.inno.market.model.Order;


import static org.junit.Assert.assertEquals;


public class MarketServiceTest {

    MarketService newMarketService;
    Catalog newCatalog;

    @Before
    public void setUp() {
        newMarketService = new MarketService();
        newCatalog = new Catalog();
    }

    @Test
    public void shouldGetOrder() {
        Client client1 = new Client(1, "Dima");
        int orderId = newMarketService.createOrderFor(client1);
        assertEquals(0, orderId);
    }

    @Test
    public void shouldAddItemForOrder() {
        Client client1 = new Client(1, "Dima");
        int orderId = newMarketService.createOrderFor(client1);
        Order newOrder = newMarketService.getOrderInfo(orderId);
        assertEquals(orderId, newOrder.getId());
        assertEquals(client1, newOrder.getClient());
    }

    @Test
    public void shouldDeletedItemInCatalog() {
        Client client1 = new Client(1, "Dima");
        int orderId = newMarketService.createOrderFor(client1);
        Item addItem = newCatalog.getItemById(5);
        newMarketService.addItemToOrder(addItem, orderId);
        assertEquals(newCatalog.getCountForItem(addItem), newCatalog.getCountForItem(addItem));
    }

    @Test
    public void shouldEndItemInCatalog() {
        Client client1 = new Client(1, "Dima");
        int orderId = newMarketService.createOrderFor(client1);
        Item addItem = newCatalog.getItemById(5);
        newMarketService.addItemToOrder(addItem, orderId);
        assertEquals(newCatalog.getCountForItem(addItem), newCatalog.getCountForItem(addItem) - 4);
        AssertionError endItem = new AssertionError("Товара  нет  в нужном количестве");
    }

    @After
    public void remove() {
        newMarketService = null;
        newCatalog = null;
    }
}