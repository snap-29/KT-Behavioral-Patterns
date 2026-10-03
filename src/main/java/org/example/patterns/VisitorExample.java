package org.example.patterns;

interface AnimalVisitor {

    void visit(Lion lion);

    void visit(Elephant elephant);

    void visit(Parrot parrot);
}

interface Animal {

    void accept(AnimalVisitor visitor);
}

class Lion implements Animal {

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class Elephant implements Animal {

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class Parrot implements Animal {

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class Veterinarian implements AnimalVisitor {

    @Override
    public void visit(Lion lion) {
        System.out.println(
                "Ветеринар осматривает льва"
        );
    }

    @Override
    public void visit(Elephant elephant) {
        System.out.println(
                "Ветеринар осматривает слона"
        );
    }

    @Override
    public void visit(Parrot parrot) {
        System.out.println(
                "Ветеринар осматривает попугая"
        );
    }
}

public class VisitorExample {

    public static void main(String[] args) {

        Animal[] animals = {
                new Lion(),
                new Elephant(),
                new Parrot()
        };

        AnimalVisitor veterinarian =
                new Veterinarian();

        for (Animal animal : animals) {
            animal.accept(veterinarian);
        }
    }
}