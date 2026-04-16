package ru.yandex.practicum.delivery.parcels;

import ru.yandex.practicum.delivery.Tariffs;

public class PerishableParcel extends Parcel {
    private final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * Tariffs.PERISHABLE.getCost();
    }

    public boolean isExpired(int currentDay) {
        return getSendDay() + timeToLive > currentDay;
    }
}
