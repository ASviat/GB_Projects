import java.io.File;

public class Tree {
//    Домашнее задание:
//
//            1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup
//2. Доработайте класс Tree и метод print который мы разработали на семинаре.
// Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.


    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param args
     */
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
//        for(File i : files){
//            if(i.isDirectory())
//            System.out.print(i+" ");
//        }

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirTotal == ++subDirCounter);

                printFiles(files[i], indent);
            }
        }
    }

    public static void printFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (i == files.length - 1 && files[i].isFile()) {
                System.out.print(indent + "│ ");
                System.out.print("└─");
            } else if (files[i].isFile()) {
                System.out.print(indent + "│ ");
                System.out.print("├─");
            }
            System.out.println(files[i].getName());
        }
    }

}






