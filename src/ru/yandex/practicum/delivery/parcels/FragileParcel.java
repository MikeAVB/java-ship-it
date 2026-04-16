package ru.yandex.practicum.delivery.parcels;

import ru.yandex.practicum.delivery.Tariffs;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * Tariffs.FRAGILE.getCost();
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка %s обёрнута в защитную плёнку%n", getDescription());
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.printf("Хрупкая посылка %s изменила местоположение на %s%n", getDescription(), newLocation);
    }
}
