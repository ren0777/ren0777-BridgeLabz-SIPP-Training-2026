// A transport company manages a fleet: Vehicle[] containing Car, Bus,
// Bike objects. Call fuelCost(km) on each — each type calculates
// differently. Use instanceof before casting. Add a new ElectricCar
// without changing existing code (open/closed principle preview).

abstract class Vehicle {

    public abstract double fuelCost(double km);
}

class Car extends Vehicle {

    @Override
    public double fuelCost(double km) {
        return km * 8;
    }
}

class Bus extends Vehicle {

    @Override
    public double fuelCost(double km) {
        return km * 15;
    }
}

class Bike extends Vehicle {

    @Override
    public double fuelCost(double km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {

    @Override
    public double fuelCost(double km) {
        return km * 2;
    }
}

public class Main {

    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car(),
                new Bus(),
                new Bike(),
                new ElectricCar()
        };

        double km = 100;

        System.out.println("===== Fuel Cost Report =====");

        for (Vehicle v : fleet) {

            System.out.println(
                    v.getClass().getSimpleName()
                            + " Fuel Cost = ₹"
                            + v.fuelCost(km)
            );

            if (v instanceof Car) {

                Car c = (Car) v;
                System.out.println("This vehicle is a Car");

            } else if (v instanceof Bus) {

                Bus b = (Bus) v;
                System.out.println("This vehicle is a Bus");

            } else if (v instanceof Bike) {

                Bike b = (Bike) v;
                System.out.println("This vehicle is a Bike");

            } else if (v instanceof ElectricCar) {

                ElectricCar e = (ElectricCar) v;
                System.out.println("This vehicle is an Electric Car");
            }

            System.out.println();
        }
    }
}