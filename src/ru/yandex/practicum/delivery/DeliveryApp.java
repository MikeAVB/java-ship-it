package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.parcels.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(5000);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(5000);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(5000);

    static void main() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportTrackableStatus();
                    break;
                case 5:
                    showBoxContent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showBoxContent() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 - обычные посылки");
        System.out.println("2 - скоропортящиеся посылки");
        System.out.println("3 - хрупкие посылки");

        int boxType = Integer.parseInt(scanner.nextLine());
        ParcelBox<? extends Parcel> parcelBox = switch (boxType) {
            case 1 -> standardBox;
            case 2 -> perishableBox;
            case 3 -> fragileBox;
            default -> null;
        };
        if (parcelBox == null) {
            System.out.println("Неверно выбран тип коробки: " + boxType);
        } else {
            List<? extends Parcel> parcels = parcelBox.getAllParcels();
            if (!parcels.isEmpty()) {
                for (Parcel parcel : parcels) {
                    System.out.println("Посылка: " + parcel.getDescription() + ", вес: " + parcel.getWeight());
                }
            } else {
                System.out.println("Посылок нет. Коробка пуста.");
            }
        }
    }

    private static void reportTrackableStatus() {
        System.out.println("Запрос о местонахождении посылок...");
        for (Trackable trackableParcel : trackableParcels) {
            System.out.print("Введите новое местоположение посылки: ");
            trackableParcel.reportStatus(scanner.nextLine());
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - отследить посылки");
        System.out.println("5 - показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        System.out.println("1 - стандартная посылка");
        System.out.println("2 - скоропортящаяся посылка");
        System.out.println("3 - хрупкая посылка");
        int parcelType = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();

        System.out.println("Введите вес посылки (в граммах):");
        int parcelWeight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки:");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки посылки:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        int timeToLive = 0;
        if (parcelType == 2) {
            System.out.println("Введите срок хранения посылки:");
            timeToLive = Integer.parseInt(scanner.nextLine());
        }

        switch (parcelType) {
            case 1 -> {
                StandardParcel parcel = new StandardParcel(description, parcelWeight, deliveryAddress, sendDay);
                allParcels.add(parcel);
                standardBox.addParcel(parcel);
            }
            case 2 -> {
                PerishableParcel parcel = new PerishableParcel(description, parcelWeight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(parcel);
                perishableBox.addParcel(parcel);
            }
            case 3 -> {
                FragileParcel parcel = new FragileParcel(description, parcelWeight, deliveryAddress, sendDay);
                allParcels.add(parcel);
                fragileBox.addParcel(parcel);
                trackableParcels.add(parcel);
            }
            default -> System.out.println("Не существующий тип посылки " + parcelType);
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        if (allParcels.isEmpty()) {
            System.out.println("Нет посылок, готовых к отправке!");
            return;
        }

        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        allParcels.clear();
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + totalCost);
    }

}