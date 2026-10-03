package org.example.patterns;

abstract class SupportHandler {

    private SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public void handle(String problem) {

        if (canHandle(problem)) {
            solve(problem);
        } else if (next != null) {
            next.handle(problem);
        } else {
            System.out.println(
                    "Никто не смог решить проблему: " + problem
            );
        }
    }

    protected abstract boolean canHandle(String problem);

    protected abstract void solve(String problem);
}

class FirstLineSupport extends SupportHandler {

    @Override
    protected boolean canHandle(String problem) {
        return problem.equals("password");
    }

    @Override
    protected void solve(String problem) {
        System.out.println(
                "Оператор восстановил пароль"
        );
    }
}

class SecondLineSupport extends SupportHandler {

    @Override
    protected boolean canHandle(String problem) {
        return problem.equals("payment");
    }

    @Override
    protected void solve(String problem) {
        System.out.println(
                "Специалист по платежам решил проблему"
        );
    }
}

class TechnicalSupport extends SupportHandler {

    @Override
    protected boolean canHandle(String problem) {
        return problem.equals("server");
    }

    @Override
    protected void solve(String problem) {
        System.out.println(
                "Технический специалист исправил проблему сервера"
        );
    }
}

public class ChainOfResponsibilityExample {

    public static void main(String[] args) {

        SupportHandler firstLine = new FirstLineSupport();
        SupportHandler secondLine = new SecondLineSupport();
        SupportHandler technical = new TechnicalSupport();

        firstLine.setNext(secondLine);
        secondLine.setNext(technical);

        firstLine.handle("password");
        firstLine.handle("payment");
        firstLine.handle("server");
        firstLine.handle("delivery");
    }
}