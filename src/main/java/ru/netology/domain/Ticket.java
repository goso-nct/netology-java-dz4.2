package ru.netology.domain;

import java.util.Objects;

public class Ticket extends Product implements Comparable<Ticket> {

    private String fromAp;
    private String toAp;

    public Ticket(int id,String fromAp, String toAp, int price, String company) {
        super(id, company, price);
        this.fromAp = fromAp;
        this.toAp = toAp;
    }

    public String getFromAp() { return fromAp; }
    public String getToAp() { return toAp; }
    public String getCompany() { return getName(); }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + getId() +
                ", fromAp='" + fromAp + '\'' +
                ", toAp='" + toAp + '\'' +
                ", price=" + getPrice() +
                ", company='" + getCompany() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        if (!super.equals(o)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(fromAp, ticket.fromAp) && Objects.equals(toAp, ticket.toAp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fromAp, toAp);
    }

    @Override
    public int compareTo(Ticket o) {
        return getPrice() - o.getPrice();
    }
}