package railwaystation;

public abstract class Train {
    protected String name;
    private int numberOfWagons;
    protected static final int LENGTH_OF_WAGON = 15;

    public Train(int numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    public int getTotalLength() {
        return numberOfWagons * LENGTH_OF_WAGON;
    }

    public abstract int calculateTravellingPeople();

    public String getName() {
        return name;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

}
