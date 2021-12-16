package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();
    private List<String> lines = new ArrayList<>();


    public List<Human> readHumansFromFile(Path path) {
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }

        for (String actual : lines) {
            humans.add(geHumanFromString(actual));
        }
        return humans;
    }

    private Human geHumanFromString(String line) {
        String[] s = line.split(";");
        return new Human(s[0], s[1]);
    }

    private boolean isHumanAMale(Human human) {

        if (human.getIdentityNumber().charAt(0) == '1' || human.getIdentityNumber().charAt(0) == '3') {
            return true;
        } else {
            return false;
        }
    }


    public void writeMaleHumansToFile(Path path) {
        List<String> males = new ArrayList<>();
        for (String actual : lines) {
            if (isHumanAMale(geHumanFromString(actual))) {
                males.add(actual);
            }
        }
        try {
            Files.write(path, males);
        } catch (IOException ioe) {
            throw new IllegalStateException("Error writing file!");
        }
    }

    public List<Human> getHumans() {
        return humans;
    }
}
