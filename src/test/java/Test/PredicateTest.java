package Test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 */
public class PredicateTest {

    public static void main(String[] args) {
        //过滤偶数
        List<Object> result = PredicateTest.conditionFilter(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> (int) i % 2 == 1);

        result.forEach(System.out::println);

        //过滤字符串长度小于等于2的
        List<Object> result2 = PredicateTest.conditionFilter(Lists.newArrayList("asd", "gsdga", "11154", "s"), s -> s.toString().length() > 2 ? true : false);

        result2.forEach(System.out::println);


    }


    public static List<Object> conditionFilter(List<Object> list, Predicate<Object> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
