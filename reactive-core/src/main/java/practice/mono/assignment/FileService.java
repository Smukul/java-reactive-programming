package practice.mono.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static final Path PATH = Paths.get("src/main/resources/assignment/");

    public static Mono<String> read(String fileName){
        return Mono.fromSupplier(()->readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content){
        return Mono.fromRunnable(() -> writeFile(fileName,content));
    }

    public static Mono<Void> delete(String fileName){
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }
    private static String readFile(String fileName){
        try{
            return Files.readString(PATH.resolve(fileName));
        } catch (IOException ioException){
            System.err.println(ioException.getMessage());
        }
        return null;
    }

    private static void writeFile(String fileName,String content){
        try{
            Files.writeString(PATH.resolve(fileName),content);
        } catch (IOException ioException){
            System.err.println(ioException.getMessage());
        }
    }

    private static void deleteFile(String fileName){
        try{
            Files.delete(PATH.resolve(fileName));
        } catch (IOException ioException){
            System.err.println(ioException.getMessage());
        }
    }
}
