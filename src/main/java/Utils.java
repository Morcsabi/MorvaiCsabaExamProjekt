import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public String fileName = null;

    public String read(String fileName) {

        String text = "";

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                text += line + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        return text.trim();
    }

    public void write(String text) {
        Path path = Paths.get(fileName);
        String message = text + "\n";

        try {
            Files.write(path, message.getBytes(), StandardOpenOption.CREATE);

        } catch (Exception e) {
            System.out.println("An error has occurred");
        }
    }
}
