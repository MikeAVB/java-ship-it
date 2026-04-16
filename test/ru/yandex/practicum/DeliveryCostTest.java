package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.yandex.practicum.delivery.Tariffs;
import ru.yandex.practicum.delivery.parcels.FragileParcel;
import ru.yandex.practicum.delivery.parcels.PerishableParcel;
import ru.yandex.practicum.delivery.parcels.StandardParcel;

public class DeliveryCostTest {
    @Test
    void checkStandardParcelGetCostIsCorrect() {
        StandardParcel standardParcel = new StandardParcel("Стандартная посылка", 1000, "Адрес", 1);
        assertEquals(Tariffs.STANDARD.getCost() * 1000, standardParcel.calculateDeliveryCost());
    }

    @Test
    void checkPerishableParcelGetCostIsCorrect() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1000, "Адрес", 1, 1);
        assertEquals(Tariffs.PERISHABLE.getCost() * 1000, perishableParcel.calculateDeliveryCost());
    }

    @Test
    void checkFragileParcelGetCostIsCorrect() {
        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка", 1000, "Адрес", 1);
        assertEquals(Tariffs.FRAGILE.getCost() * 1000, fragileParcel.calculateDeliveryCost());
    }
}
