package java8test.PersionFunction;

import org.springframework.core.convert.converter.Converter;

public class Person {

    public Person(){}

    public void say(){
        System.out.println("xxixixixi");
    }

    public static void main(String[] args) {
        //此处双冒号含义为 指向 Person的构造方法 返回的为person符合personFactory.create
        PersonFactory personFactory = Person::new;

        Person person = personFactory.create();

        person.say();

        final int num = 1;

        Converter<Integer,String> stringConverter = from -> String.valueOf(num + from);

        stringConverter.convert(5);

    }
}
