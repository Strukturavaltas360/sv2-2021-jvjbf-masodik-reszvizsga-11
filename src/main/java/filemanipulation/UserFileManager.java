package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class UserFileManager {
    List<User> users = new ArrayList<>();
    List<String> lines;

    public void readUsersFromFile(Path path) {
        try {
            lines = Files.readAllLines(path);
            createUsersFromList();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, getSameUserNameAndEmail());
        } catch (IOException ioe) {
            throw new IllegalStateException("Error while writing file!", ioe);
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    private void createUsersFromList() {
        for (String s : lines) {
            String[] temp = s.split(" ");
            users.add(new User(temp[0], Integer.parseInt(temp[1]), temp[2]));
        }
    }

    private List<String> getSameUserNameAndEmail() {
        List<String> result = new ArrayList<>();
            for (User user: users) {
                if (user.getEmail().toLowerCase().startsWith(user.getUserName().toLowerCase())) {
                    result.add(user.getUserName());
                }
        }
        return result;
    }
}
