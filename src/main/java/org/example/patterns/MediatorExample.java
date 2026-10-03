package org.example.patterns;

interface SmartHomeMediator {

    void notify(Device sender, String event);
}

abstract class Device {

    protected SmartHomeMediator mediator;

    public Device(SmartHomeMediator mediator) {
        this.mediator = mediator;
    }
}

class SecuritySystem extends Device {

    public SecuritySystem(SmartHomeMediator mediator) {
        super(mediator);
    }

    public void activate() {
        System.out.println("Система безопасности включена");
        mediator.notify(this, "SECURITY_ON");
    }
}

class Camera extends Device {

    public Camera(SmartHomeMediator mediator) {
        super(mediator);
    }

    public void startRecording() {
        System.out.println("Камера начала запись");
    }
}

class Siren extends Device {

    public Siren(SmartHomeMediator mediator) {
        super(mediator);
    }

    public void turnOn() {
        System.out.println("Сирена включена");
    }
}

class HomeController implements SmartHomeMediator {

    private Camera camera;
    private Siren siren;

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setSiren(Siren siren) {
        this.siren = siren;
    }

    @Override
    public void notify(Device sender, String event) {

        if (event.equals("SECURITY_ON")) {
            camera.startRecording();
            siren.turnOn();
        }
    }
}

public class MediatorExample {

    public static void main(String[] args) {

        HomeController controller = new HomeController();

        Camera camera = new Camera(controller);
        Siren siren = new Siren(controller);
        SecuritySystem securitySystem =
                new SecuritySystem(controller);

        controller.setCamera(camera);
        controller.setSiren(siren);

        securitySystem.activate();
    }
}