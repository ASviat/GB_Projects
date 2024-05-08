import java.io.File;

public class Tree {

    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        System.out.println(file.getName());

        File[] files = file.listFiles();

        int subDirTotal = 0;
        int subFileTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            }
            if (files[i].isFile()) {
                subFileTotal++;
            }
        }
        if (subFileTotal > 0) {
            printFiles(file, indent, subFileTotal);
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirTotal == ++subDirCounter);
            }
        }
    }

    /**
     * Prints files from directory
     *
     * @param directory    directory, which files must be printed
     * @param indent       String to hold formatting
     * @param subFileTotal counter of files in directory
     */
    public static void printFiles(File directory, String indent, int subFileTotal) {
        File[] files = directory.listFiles();
        int counter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                counter++;
            }
            if (subFileTotal == 1 && files[i].isFile() && counter == 0) {
                System.out.print(indent);//+ "│ "
                System.out.print("└─");
                System.out.println(files[i].getName());
            } else if (subFileTotal == 1 && files[i].isFile() && counter > 0) {
                System.out.print(indent);
                System.out.print("├─");
                System.out.println(files[i].getName());
            } else if (files[i].isFile()) {
                System.out.print(indent);
                System.out.print("├─");
                System.out.println(files[i].getName());
                subFileTotal--;
            }
        }
    }
}






