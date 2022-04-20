import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * Greets SACM members who have contributed to this repository!
 *
 * @author cole@colejpearson.com
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        // Get text files in current directory
        File workingDir = new File(System.getProperty("user.dir"));
        File[] files = workingDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        // Greet the individual named in each file
        for (File f : files) {
            if (f.canRead()) {
                String name = "";
                // Read file
                try {
                    Scanner in = new Scanner(f);
                    while (in.hasNextLine()) {
                        name += " " + in.nextLine();
                    }
                    in.close();
                    name = name.replaceAll("\\s+", " ").trim();
                } catch (FileNotFoundException e) {}

                // Print greeting
                System.out.println("Hello, " + name + "!");
            }
        }
    }
}
