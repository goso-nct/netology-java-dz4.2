package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketManager {

    private ProductRepository<Ticket> repository;

    public TicketManager(ProductRepository<Ticket> repository) {
        this.repository = repository;
    }

    public void add(Ticket ... ticket) {
        for (Ticket t : ticket) repository.save(t);
    }

    public Ticket[] getAll() {
        Ticket[] tickets = new Ticket[repository.getStorage().size()];
        repository.getStorage().toArray(tickets);
        return tickets;
    }

    public Ticket[] findAll(String fromAp, String toAp) {
        Ticket[] tickets = searchBy(fromAp, toAp);
        if (tickets != null) {
            Arrays.sort(tickets);
        }
        return tickets;
    }

    public Ticket[] searchBy(String searchFrom, String searchTo) {
        List<Ticket> finded = new ArrayList<>();
        for (Ticket item : repository.getStorage()) {
            if (matches(item, searchFrom, searchTo)) {
                finded.add(item);
            }
        }
        if (finded.isEmpty()) return null;
        Ticket[] items = new Ticket[finded.size()];
        finded.toArray(items);
        return items;
    }

    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        return ticket.getFromAp().contains(searchFrom) && ticket.getToAp().contains(searchTo);
    }

}
