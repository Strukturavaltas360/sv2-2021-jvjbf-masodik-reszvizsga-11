package railwaystation;

public class PassengerTrain extends Train {

    private boolean diningCar;
    public static final int NUMBER_OF_PASSENGERS_PER_WAGON = 70;

    public PassengerTrain(int numberOfWagons) {
        super(numberOfWagons);
    }

    public PassengerTrain(String name, int numberOfWagons) {
        this(numberOfWagons);
        this.name = name;
        this.diningCar = true;
    }

    @Override
    public int calculateTravellingPeople() {
        if (hasDiningCar()) {
            return (getNumberOfWagons()-1) * NUMBER_OF_PASSENGERS_PER_WAGON;
        }
        return getNumberOfWagons() * NUMBER_OF_PASSENGERS_PER_WAGON;
    }

    public boolean hasDiningCar() {
        return diningCar;
    }
}
