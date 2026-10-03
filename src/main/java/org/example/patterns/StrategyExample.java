package org.example.patterns;

interface RouteStrategy {

    void buildRoute(String from, String to);
}

class CarRoute implements RouteStrategy {

    @Override
    public void buildRoute(String from, String to) {
        System.out.println(
                "Маршрут на автомобиле: " +
                        from + " -> " + to
        );
    }
}

class BicycleRoute implements RouteStrategy {

    @Override
    public void buildRoute(String from, String to) {
        System.out.println(
                "Маршрут на велосипеде: " +
                        from + " -> " + to
        );
    }
}

class WalkingRoute implements RouteStrategy {

    @Override
    public void buildRoute(String from, String to) {
        System.out.println(
                "Пешеходный маршрут: " +
                        from + " -> " + to
        );
    }
}

class Navigator {

    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void buildRoute(String from, String to) {
        strategy.buildRoute(from, to);
    }
}

public class StrategyExample {

    public static void main(String[] args) {

        Navigator navigator =
                new Navigator(new CarRoute());

        navigator.buildRoute(
                "Дом",
                "Университет"
        );

        navigator.setStrategy(
                new BicycleRoute()
        );

        navigator.buildRoute(
                "Дом",
                "Университет"
        );

        navigator.setStrategy(
                new WalkingRoute()
        );

        navigator.buildRoute(
                "Дом",
                "Университет"
        );
    }
}