package org.example.patterns;

interface Command {

    void execute();
}

class Television {

    public void turnOn() {
        System.out.println("Телевизор включён");
    }

    public void turnOff() {
        System.out.println("Телевизор выключен");
    }

    public void increaseVolume() {
        System.out.println("Громкость увеличена");
    }
}

class TurnOnCommand implements Command {

    private final Television television;

    public TurnOnCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.turnOn();
    }
}

class TurnOffCommand implements Command {

    private final Television television;

    public TurnOffCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.turnOff();
    }
}

class IncreaseVolumeCommand implements Command {

    private final Television television;

    public IncreaseVolumeCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.increaseVolume();
    }
}

class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandExample {

    public static void main(String[] args) {

        Television television = new Television();

        RemoteControl remote = new RemoteControl();

        remote.setCommand(
                new TurnOnCommand(television)
        );
        remote.pressButton();

        remote.setCommand(
                new IncreaseVolumeCommand(television)
        );
        remote.pressButton();

        remote.setCommand(
                new TurnOffCommand(television)
        );
        remote.pressButton();
    }
}