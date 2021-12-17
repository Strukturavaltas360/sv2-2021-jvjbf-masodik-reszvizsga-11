package railwaystation;

import java.util.ArrayList;
import java.util.List;

public class RailwayStation {
    public static final int MAX_TRAINS_IN_STATION = 10;
    List<Train> trains = new ArrayList<>();


    public void addTrain(Train train) {
        if (trains.size() <= 9) {
            trains.add(train);
        } else {
            throw new IllegalArgumentException("Too much trains!");
        }
    }

    public Train getLongestTrain() {
        Train longestTrain = trains.get(0);
        for (Train train : trains) {
            if (train.getTotalLength() > longestTrain.getTotalLength()) {
                longestTrain = train;
            }
        }
        return longestTrain;
    }

    public int getHowManyTrainsHaveName() {
        int counter = 0;
        for (Train actual : trains) {
            if (actual.getName() != null) {
                counter++;
            }
        }
        return counter;
    }

    public List<Train> getTrainsWithPassengersMoreThan(int number) {
        List<Train> result = new ArrayList<>();
        for (Train actual : trains) {
            if (actual.calculateTravellingPeople() > number)
                result.add(actual);
        }
        return result;
    }

    public List<Train> getTrains() {
        return trains;
    }
}
