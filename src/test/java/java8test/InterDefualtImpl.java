package java8test;


import org.springframework.core.convert.converter.Converter;

public class InterDefualtImpl implements InterDefualt{

    public static void main(String[] args) {
        //InterDefualt interDefualt = InterDefualtImpl::new;

        //System.out.println(interDefualt.sum(4,6));

        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }
}
