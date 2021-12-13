package city;

public class Office extends Building{

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        if (getArea()/numberOfTablesPerLevel < 2 || getArea()/numberOfTablesPerLevel > 5) {
         throw new IllegalArgumentException("Invalid number of tables!");
        } else {
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }

    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels()-1);
    }
}
