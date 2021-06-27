package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.NonFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {

    ProductRepository<Ticket> ticketRepository = new ProductRepository<>();
    Ticket[] expected;

    Ticket t1 = new Ticket(1,"CIA", "DRS", 1000, "Победа", 100);
    Ticket t2 = new Ticket(2,"CIA", "DRS", 2000, "Аэрофлот", 100);
    Ticket t3 = new Ticket(3,"CIA", "DRS", 3000, "Люфтганза", 100);
    Ticket t4 = new Ticket(4,"CIA", "DRS", 3000, "Газпром авиа", 100);

    Ticket[] getAll() {
        // creating an array from the list
        Ticket[] tickets = new Ticket[ticketRepository.getStorage().size()];
        ticketRepository.getStorage().toArray(tickets);
        return tickets;
    }

    @Test
    void save_shouldSave() {
        ticketRepository.save(t1);
        ticketRepository.save(t2);
        ticketRepository.save(t3);
        ticketRepository.save(t4);
        expected = new Ticket[] {t1, t2, t3, t4};
        assertArrayEquals(expected, getAll());
    }

    @Test
    void save_shouldNotSave() {
        // fill:
        ticketRepository.save(t1);
        ticketRepository.save(t2);
        ticketRepository.save(t3);
        // should not save:
        ticketRepository.save(t2); // already have
        ticketRepository.save(null); // don't store null
        // check:
        expected = new Ticket[] {t1, t2, t3};
        assertArrayEquals(expected, getAll());
    }

    @Test
    void findById_shouldFind() {
        ticketRepository.save(t1);
        ticketRepository.save(t2);
        ticketRepository.save(t3);
        ticketRepository.save(t4);
        Ticket found = ticketRepository.findById(3);
        assertEquals(t3, found);
    }

    @Test
    void findById_shouldNotFind() {
        ticketRepository.save(t1);
        ticketRepository.save(t2);
        Ticket found = ticketRepository.findById(50);
        assertNull(found);
    }

    @Test
    void removeById_shouldRemove() throws NonFoundException {
        ticketRepository.save(t1);
        ticketRepository.save(t2);
        ticketRepository.save(t3);
        ticketRepository.save(t4);
        ticketRepository.removeById(3);
        expected = new Ticket[] {t1, t2, t4};
        assertArrayEquals(expected, getAll());
    }

    @Test
    void removeById_shouldGenerateException() {
        ticketRepository.save(t1);
        ticketRepository.save(t2);
        assertThrows(NonFoundException.class, ()->ticketRepository.removeById(100));
    }
}
