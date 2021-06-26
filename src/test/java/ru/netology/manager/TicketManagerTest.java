package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    ProductRepository<Ticket> repository = new ProductRepository<>();
    TicketManager testManager = new TicketManager(repository);

    Ticket t1 = new Ticket(1,"CIA", "DRS", 1500, "Победа");
    Ticket t2 = new Ticket(2,"CIA", "DRS", 3000, "Аэрофлот");
    Ticket t3 = new Ticket(3,"CIA", "DRS", 2000, "Люфтганза");
    Ticket t4 = new Ticket(4,"CIA", "DRS", 3000, "Газпром авиа");
    Ticket t5 = new Ticket(5,"CIA", "DRS", 1000, "Джет-2000");
    // sort: t5, t1, t3, t2, t4
    Ticket t6 = new Ticket(6,"CIA", "HAM", 2500, "Pegas Fly");
    Ticket t7 = new Ticket(7,"CIA", "HAM", 2100, "Аэрофлот");
    Ticket t8 = new Ticket(8,"CIA", "HAM", 1800, "Pegas Fly");
    Ticket t9 = new Ticket(9,"CIA", "HAM", 3200, "Аэрофлот");
    // sort: t8, t7, t6, t9


    @Test
    void testAdd() {
        testManager.add(t1, t2, t3, t4, t5);
        Ticket[] expected = new Ticket[] {t1, t2, t3, t4, t5};
        assertArrayEquals(expected, testManager.getAll());
    }


    @Test
    void testMatches() {
        assertTrue(testManager.matches(t1,"CIA", "DRS" ));
        assertFalse(testManager.matches(t1,"EDI", "HAM" ));
    }

    @Test
    void testFindAll() {
        testManager.add(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        Ticket[] expected = new Ticket[] {t5, t1, t3, t2, t4 };
        Ticket[] actual = testManager.findAll("CIA","DRS");
        assertArrayEquals(expected, actual);
        expected = new Ticket[] {t8, t7, t6, t9  };
        actual = testManager.findAll("CIA","HAM");
        assertArrayEquals(expected, actual);
        actual = testManager.findAll("111","222");
        assertNull(actual);
    }

}