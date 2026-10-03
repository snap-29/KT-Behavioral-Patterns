package org.example.patterns;

interface OrderState {

    void next(Order order);

    void printStatus();
}

class NewOrderState implements OrderState {

    @Override
    public void next(Order order) {
        System.out.println("Заказ оплачен");
        order.setState(new PaidOrderState());
    }

    @Override
    public void printStatus() {
        System.out.println("Заказ создан и ожидает оплаты");
    }
}

class PaidOrderState implements OrderState {

    @Override
    public void next(Order order) {
        System.out.println("Заказ передан в доставку");
        order.setState(new ShippedOrderState());
    }

    @Override
    public void printStatus() {
        System.out.println("Заказ оплачен");
    }
}

class ShippedOrderState implements OrderState {

    @Override
    public void next(Order order) {
        System.out.println("Заказ доставлен");
        order.setState(new DeliveredOrderState());
    }

    @Override
    public void printStatus() {
        System.out.println("Заказ находится в пути");
    }
}

class DeliveredOrderState implements OrderState {

    @Override
    public void next(Order order) {
        System.out.println("Заказ уже доставлен");
    }

    @Override
    public void printStatus() {
        System.out.println("Заказ доставлен");
    }
}

class Order {

    private OrderState state;

    public Order() {
        state = new NewOrderState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}

public class StateExample {

    public static void main(String[] args) {

        Order order = new Order();

        order.printStatus();

        order.nextState();
        order.printStatus();

        order.nextState();
        order.printStatus();

        order.nextState();
        order.printStatus();

        order.nextState();
    }
}