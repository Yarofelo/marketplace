package ru.inno.market;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.inno.market.core.MarketService;
import ru.inno.market.model.Client;

import static org.junit.Assert.assertEquals;

public class MarketServiceTest {

    MarketService newMarketService;

    @Before
    public void setUp() {
        newMarketService = new MarketService();
    }

    @Test
    public void shouldGetOrder() {
        Client client1 = new Client(1, "Dima");
        int orderId = newMarketService.createOrderFor(client1);
        assertEquals(0, orderId);
    }

    @After
    public void remove() {
        newMarketService = null;
    }
}