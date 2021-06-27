package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.ProductRepository;

import java.util.Comparator;

public class TicketManager {

    private ProductRepository<Ticket> repository;

    public TicketManager(ProductRepository<Ticket> repository) {
        this.repository = repository;
    }

    public void add(Ticket ... ticket) {
        for (Ticket t : ticket) {
            repository.save(t);
        }
    }

    // for task 1
    public Ticket[] findAll(String fromAp, String toAp) {
        Ticket[] tickets = repository.getStorage().stream()
                .filter(t -> t.getFromAp().contains(fromAp) && t.getToAp().contains(toAp))
                .sorted()
                .toArray(Ticket[]::new);
        return tickets.length == 0 ? null : tickets;
    }

    // for task 2
    public Ticket[] findAll(String fromAp, String toAp, Comparator<Ticket> comparator) {
        Ticket[] tickets = repository.getStorage().stream()
                .filter(t -> t.getFromAp().contains(fromAp) && t.getToAp().contains(toAp))
                .sorted(comparator)
                .toArray(Ticket[]::new);
        return tickets.length == 0 ? null : tickets;
    }

    public Ticket[] getAll() {
        return repository.getStorage().isEmpty()
                ? null
                : repository.getStorage().stream().toArray(Ticket[]::new);
    }

}
