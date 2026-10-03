package org.example.patterns;

import java.util.ArrayList;
import java.util.List;

interface PriceObserver {

    void update(String productName, double newPrice);
}

class Customer implements PriceObserver {

    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName, double newPrice) {
        System.out.println(
                name + ": цена товара \"" +
                        productName +
                        "\" теперь " +
                        newPrice +
                        " руб."
        );
    }
}

class Product {

    private final String name;
    private double price;

    private final List<PriceObserver> observers =
            new ArrayList<>();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void subscribe(PriceObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(PriceObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(double newPrice) {

        if (newPrice != price) {
            price = newPrice;
            notifyObservers();
        }
    }

    private void notifyObservers() {

        for (PriceObserver observer : observers) {
            observer.update(name, price);
        }
    }
}

public class ObserverExample {

    public static void main(String[] args) {

        Product laptop =
                new Product("Ноутбук", 80000);

        Customer alex = new Customer("Алексей");
        Customer maria = new Customer("Мария");

        laptop.subscribe(alex);
        laptop.subscribe(maria);

        laptop.setPrice(75000);

        laptop.unsubscribe(maria);

        laptop.setPrice(70000);
    }
}