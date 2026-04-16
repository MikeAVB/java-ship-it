package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parcels.PerishableParcel;

import static org.junit.jupiter.api.Assertions.*;

/*
    Тут, честно говоря, была мысль, что слишком длинные имена методов, но подумал что тестов это не касается))
 */

public class PerishableParcelTest {
    @Test
    void shouldReturnFalseWhenLessThanTimeToLive() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1000, "Адрес", 1, 3);
        assertFalse(perishableParcel.isExpired(2));
    }

    @Test
    void shouldReturnFalseWhenEqualsTimeToLive() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1000, "Адрес", 1, 3);
        assertFalse(perishableParcel.isExpired(4));
    }

    @Test
    void shouldReturnTrueWhenMoreThanTimeToLive() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1000, "Адрес", 1, 3);
        assertTrue(perishableParcel.isExpired(5));
    }
}