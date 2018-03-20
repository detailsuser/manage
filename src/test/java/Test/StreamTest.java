package Test;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        Stream<Person> stream = Stream.of(new Person("1", "aa", "12"), new Person("1", "bb", "13"), new Person("3", "cc", "14"));
        System.out.println(stream.collect(Collectors.groupingBy(x -> x.getId())));

        House house1 = new House();
        house1.setLocation("杭州");
        house1.setType("zz");
        House house2 = new House();
        house2.setLocation("wz");
        house2.setType("jz");
        ArrayList<Person> people = Lists.newArrayList(new Person("1", "aa", "18", house1),
                new Person("2", "bb", "28", house2),
                new Person("3", "cc", "38", house2),
                new Person("4", "dd", "48", house1));
        Stream<Person> stream2 = Stream.of(new Person("1", "aa", "18", house1),
                new Person("2", "bb", "28", house2),
                new Person("3", "cc", "38", house2),
                new Person("4", "dd", "48", house1));
        System.out.println(people.stream().collect(Collectors.groupingBy(x -> x.getHouse().getType())));

        IntConsumer aNew = String[]::new;
        aNew.accept(10);
    }


}
