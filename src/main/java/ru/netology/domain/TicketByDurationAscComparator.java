package ru.netology.domain;

import java.util.Comparator;

public class TicketByDurationAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getDurationMins() - o2.getDurationMins();
    }
}
