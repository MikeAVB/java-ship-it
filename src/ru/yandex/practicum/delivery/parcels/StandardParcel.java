package ru.yandex.practicum.delivery.parcels;

import ru.yandex.practicum.delivery.Tariffs;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * Tariffs.STANDARD.getCost();
    }
}
