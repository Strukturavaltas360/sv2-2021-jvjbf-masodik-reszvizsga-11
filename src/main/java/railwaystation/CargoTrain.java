package railwaystation;

public class CargoTrain extends Train {

    public CargoTrain(int numberOfWagons) {
        super(numberOfWagons);
    }

    @Override
    public int calculateTravellingPeople() {
        return getNumberOfWagons() / 10 > 0 ? getNumberOfWagons() / 10 : 1;
    }
}
