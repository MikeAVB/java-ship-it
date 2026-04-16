package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void packageItem() {
        System.out.printf("Посылка %s упакована%n", description);
    }

    public void deliver() {
        System.out.printf("Посылка %s доставлена по адресу %s%n", description, deliveryAddress);
    }

    public abstract int calculateDeliveryCost();
}
