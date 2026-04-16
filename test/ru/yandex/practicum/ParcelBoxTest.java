package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.yandex.practicum.delivery.parcels.Parcel;
import ru.yandex.practicum.delivery.parcels.ParcelBox;
import ru.yandex.practicum.delivery.parcels.StandardParcel;

public class ParcelBoxTest {
    private static ParcelBox<Parcel> box;

    @BeforeEach
    void init() {
        box = new ParcelBox<>(1000);
    }

    @Test
    void shouldPutTheParcelInBoxWhenWeightLessThanBoxMaxWeight() {
        Parcel parcel = new StandardParcel("Посылка", 500, "Адрес", 1);
        int expectedSize = 1;
        box.addParcel(parcel);
        int actualSize = box.getAllParcels().size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldPutTheParcelInBoxWhenWeightEqualsBoxMaxWeight() {
        Parcel parcel = new StandardParcel("Посылка", 1000, "Адрес", 1);
        int expectedSize = 1;
        box.addParcel(parcel);
        int actualSize = box.getAllParcels().size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldNotPutTheParcelInBoxWhenWeightMoreThanBoxMaxWeight() {
        Parcel parcel = new StandardParcel("Посылка", 1500, "Адрес", 1);
        int expectedSize = 0;
        box.addParcel(parcel);
        int actualSize = box.getAllParcels().size();
        assertEquals(expectedSize, actualSize);
    }
}
