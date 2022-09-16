package practice.mono.assignment;

import practice.Util;

public class AssignmentSolved {
    public static void main(String[] args) {
        //Read assignment file
 /*       FileService.read("assignment.txt")
                .subscribe(System.out::println);*/

        FileService.write("file1.txt"," Another content added")
                .subscribe(System.out::println);

        FileService.read("file1.txt")
                .subscribe(Util.onNext()
                        ,Util.onError(),
                        Util.onComplete());

        FileService.delete("file2.txt")
                .subscribe(Util.onNext()
                        ,Util.onError(),
                        Util.onComplete());

    }
}
