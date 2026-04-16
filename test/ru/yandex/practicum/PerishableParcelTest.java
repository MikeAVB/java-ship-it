package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parcels.PerishableParcel;

import static org.junit.jupiter.api.Assertions.*;

public class PerishableParcelTest {
    @Test
    void shouldReturnFalseIsExpiredWhenCurrentDayLessThanTimeToLive() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1000, "Адрес", 1, 3);
        assertFalse(perishableParcel.isExpired(2));
    }

    @Test
    void shouldReturnFalseIsExpiredWhenCurrentDayEqualsTimeToLive() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1000, "Адрес", 1, 3);
        assertFalse(perishableParcel.isExpired(4));
    }

    @Test
    void shouldReturnTrueIsExpiredWhenCurrentMoreThanTimeToLive() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1000, "Адрес", 1, 3);
        assertTrue(perishableParcel.isExpired(5));
    }
}