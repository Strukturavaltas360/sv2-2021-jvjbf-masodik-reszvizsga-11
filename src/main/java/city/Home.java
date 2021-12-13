package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        this(area, address);
        if (levels >3) {
            throw new IllegalArgumentException("Too much levels!");
        } else {
            super.levels = levels;
        }
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return getArea() * getLevels() / SQUARE_METERS_NEED_PER_PERSON;
    }

}
