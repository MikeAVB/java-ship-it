package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = 1;
    }

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * ParcelTariff.PERISHABLE.getCost();
    }

    public boolean isExpired(int currentDay) {
        return getSendDay() + timeToLive > currentDay;
    }
}
