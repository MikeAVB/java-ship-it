package ru.yandex.practicum.delivery;

public enum Tariffs {
    STANDARD(2),
    PERISHABLE(3),
    FRAGILE(4);

    private final int cost;

    Tariffs(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
