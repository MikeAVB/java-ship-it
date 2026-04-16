package ru.yandex.practicum.delivery;

public enum ParcelTariff {
    STANDARD(2),
    PERISHABLE(3),
    FRAGILE(4);

    private int cost;

    ParcelTariff(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
