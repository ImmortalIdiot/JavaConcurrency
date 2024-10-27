package sum_in_files;

import java.io.File;
import java.io.IOException;

public class FileGenerator {

    private static final int COUNT_FILES = 13;
    private static final File DIRECTORY = new File("D:\\Data\\Projects\\JavaConcurrency\\src\\sum_in_files\\files");


    public void createFiles() {

        for(int i = 1; i <= COUNT_FILES; i++) {
            File file = new File(DIRECTORY + "/" + i + ".txt");
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл " + file.getName() + " создан");
                } else {
                    System.out.println("Файл " + file.getName() + " уже существует");
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}