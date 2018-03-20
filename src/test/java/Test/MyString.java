package Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MyString {
    private char[] value;
    public MyString(){
        this.value = new char[0];
    }
    public MyString(MyString myString){
        this.value = myString.value;
    }
    public MyString(char[] value){
        // 第一个写法出大事 数组发生变化 String的值也会变化!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.value = value;
        this.value = Arrays.copyOf(value,value.length);
    }
    public int getLength(){
        return value.length;
    }
    public char charAt(int length){
        if(length < 0 || length > value.length - 1) throw new IndexOutOfBoundsException();
        return value[length];
    }
    public int indexOf(char c){
        for(int i = 0; i < value.length - 1;i++){
            if (value[i] == c){
                return i;
            }
        }
        return -1;
    }
    public MyString replace(char oldChar,char newChar){
        List list = Stream.of(value).map(c -> c.equals(oldChar)?newChar:oldChar).collect(Collectors.toList());
        char[] arr = new char[value.length];
        for (int i = 0;i < list.size();i++){
            arr[i] = (char) list.get(i);
        }
        return new MyString(arr);
    }
    public String toMyString(){
        return new String(value);
    }
    public static void main(String[] args) {
        String s = "xx";
        s = "xxx";
        String s1 = new String();
        char[] arr = new char[]{'a','b'};
        MyString m = new MyString(arr);
        arr[0] = 'c';
        System.out.println(m.toMyString());
        m.replace('a','r');
        System.out.println("跟换后   "+m.toMyString());
    }
}
