package btvn.session03;

import java.util.List;
import java.util.stream.Collectors;

public class Baitap06 {
    public static void main(String[] args) {
        List<List<String>> tags = List.of(
                List.of("java", "backend"),
                List.of("python", "data")
        );


        System.out.println(tags.stream().flatMap(List::stream).collect(Collectors.toList()));

    }
}
