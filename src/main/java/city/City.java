package city;

import java.util.ArrayList;
import java.util.List;


public class City {

    private int sizeOfBuildings = 0;
    private String name;
    private long citySize;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long citySize, List<Building> buildings) {
        this.name = name;
        this.citySize = citySize;
        this.buildings = buildings;
    }

    public City(String name, long citySize) {
        this.name = name;
        this.citySize = citySize;

    }
    
    public void addBuilding(Building b) {
        if (sizeOfBuildings + b.getArea() <= citySize) {
            sizeOfBuildings += b.getArea();
            buildings.add(b);
        } else {
            throw new IllegalArgumentException("City can't be larger than "+citySize);
        }
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building b : buildings) {
            if (b.getAddress().getStreet().equals(street)) {
                result.add(b);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building b : buildings) {
            if (b.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public Building findHighestBuilding() {
        Building highest = buildings.get(0);
        for (Building b : buildings)
            if (b.getLevels() > highest.getLevels()) {
                highest = b;
            }
        return highest;
    }



    public int getSizeOfBuildings() {
        return sizeOfBuildings;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return citySize;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
