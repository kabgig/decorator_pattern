interface Cake {
    void decorate();
}

class BasicCake implements Cake {
    @Override
    public void decorate() {
        System.out.println("Adding frosting to the cake");
    }
}

abstract class CakeDecorator implements Cake {
    protected Cake cake;
    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }
    @Override
    public void decorate() {
        cake.decorate();
    }
}

class SprinkleDecorator extends CakeDecorator {
    public SprinkleDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("Adding sprinkles to the cake");
    }
}

class CherryDecorator extends CakeDecorator {
    public CherryDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("Adding a cherry on top of the cake");
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        Cake basicCake = new BasicCake();  // Create the basic cake
        Cake sprinkledCake = new SprinkleDecorator(basicCake);  // Wrap with SprinkleDecorator
        Cake cakeWithCherry = new CherryDecorator(sprinkledCake);  // Wrap with CherryDecorator

        cakeWithCherry.decorate();  // Decorate the cake
    }
}