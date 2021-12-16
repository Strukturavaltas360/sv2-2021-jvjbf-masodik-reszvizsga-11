package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {

    List<Product> products = new ArrayList<>();
    List<String> lines;

    public void readProductsFromFile(Path path) {
        try {
            lines = Files.readAllLines(path);
            getProductsFromString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writePriceOverToFile(Path path, int limitPrice) {
        try {
            Files.write(path, getLinesFromProducts(limitPrice));
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Error while writing file!", ioe);
        }
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    private void getProductsFromString() {
        for (String s: lines) {
            String[] temp = s.split(";");
            products.add(new Product(temp[0], temp[1], Integer.parseInt(temp[2])));
        }
    }

    private List<String> getLinesFromProducts(int limitPrice) {
        List<String> result = new ArrayList<>();
            for (Product p: products) {
                if (p.getPrice() > limitPrice)
                result.add(p.toString());
            }
        return result;
    }
}
