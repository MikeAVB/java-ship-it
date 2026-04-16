package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private final ArrayList<T> parcels;

    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.parcels = new ArrayList<>();
    }

    public ArrayList<T> getAllParcels() {
        return parcels;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
        } else {
            System.out.printf(
                    "Невозможно добавить посылку %s, с весом %d, так как будет превышен максимальный вес %d. " +
                            "Текущий вес коробки - %d%n",
                    parcel.getDescription(), parcel.getWeight(), maxWeight, currentWeight
            );
        }
    }
}
