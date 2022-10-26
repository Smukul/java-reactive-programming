package practice.emitprogramatically.assignment;

import practice.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderService();

        Path path = Paths.get("src\\main\\java\\practice\\emitprogramatically\\assignment\\file1.txt");
        readerService.read(path)
                .take(2)  //read only 2 lines
                .subscribe(Util.subscriber());

        //read all lines
        readerService.read(path)
                .subscribe(Util.subscriber());
    }
}
