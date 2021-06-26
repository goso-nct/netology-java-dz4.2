package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    Ticket t1 = new Ticket(1,"CIA", "DRS", 1000, "Победа");
    Ticket t2 = new Ticket(2,"CIA", "DRS", 2000, "Аэрофлот");
    Ticket t1copy = new Ticket(1,"CIA", "DRS", 1000, "Победа");
    Ticket t1id = new Ticket(2,"CIA", "DRS", 1000, "Победа");
    Ticket t1fromAp = new Ticket(1,"***", "DRS", 1000, "Победа");
    Ticket t1toAp = new Ticket(1,"CIA", "***", 1000, "Победа");
    Ticket t1price = new Ticket(1,"CIA", "DRS", 1500, "Победа");
    Ticket t1company = new Ticket(1,"CIA", "DRS", 1000, "Pegas Fly");


    @Test
    void testEquals() {
        assertEquals(t1, t1);
        assertEquals(t1, t1copy);
        assertNotEquals(t1, t2);
        assertNotEquals(t1, t1id);
        assertNotEquals(t1, t1fromAp);
        assertNotEquals(t1, t1toAp);
        assertNotEquals(t1, t1price);
        assertNotEquals(t1, t1company);
        assertNotEquals(t1, null);
        assertNotEquals(t1, "b1");
    }

    @Test
    void testHashCode() {
        assertEquals(t1.hashCode(), t1copy.hashCode());
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Ticket{id=1, fromAp='CIA', toAp='DRS', price=1000, company='Победа'}";
        String actual = t1.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testCompareTo() {
        assertEquals(-1000, t1.compareTo(t2));
    }
}