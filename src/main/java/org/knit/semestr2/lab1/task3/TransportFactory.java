package org.knit.semestr2.lab1.task3;

public class TransportFactory {
    public Transport makeTransport(String typeOfTrip) {
        switch (typeOfTrip) {
            case "business":
                return new BusinessCar();
            case "family":
                return new FamilyVan();
            case "delivery":
                return new Motorbike();
            default:
                throw new IllegalArgumentException("Нет транспорта для " + typeOfTrip);
        }
    }
}
