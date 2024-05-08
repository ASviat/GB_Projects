import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class BackUp {

    private static final String FOLDER = ".";

    public static void main(String[] args) throws IOException {
        File[] files = createListOfFiles(".");

        Path backupDirectory = Paths.get("./backup");
        if (!Files.exists(backupDirectory)) {
            Path file = Files.createDirectory(backupDirectory);
            System.out.println(file);
        }

        for (File i : files) {
            if (!i.getName().equals("backup")) {
                Files.copy((i.toPath()), Paths.get("./backup/" + i.getName()), REPLACE_EXISTING);
            }
        }
        printBackup();
    }

    public static File[] createListOfFiles(String folder) {
        File file = new File(folder);
        return file.listFiles();
    }

    public static void printBackup() {
        File[] files = createListOfFiles("./backup/");
        for (File i : files) {
            System.out.println(i);
        }
    }
}
