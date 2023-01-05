package rxjava.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RXUtil {

    static String[] colors = {"Red", "Blue", "Yellow", "Green", "Pink", "Black"};
    static String[] shapes = {"Square", "Triangle", "Rectangle", "Pentagon", "Circle", "Hexagon"};

    public static List<Integer> positiveIntegers(int n){
        return IntStream.range(1,n)
                .boxed()
                .toList();
    }

    public static List<Shape> getShapes(int n){
        List<Shape> shapeList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int random = ThreadLocalRandom.current().nextInt(0,6);
            shapeList.add(new Shape(colors[random], shapes[random]));
        }
        return shapeList;
    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds* 1000L);
        } catch (Exception e){
            System.out.println("exception in sleep: "+e.getMessage());
        }
    }
}
