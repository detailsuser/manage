package java8test;


/**
 * @author slc
 */
public interface InterDefualt {
    default int sum(int a, int b){
        return  a+b;
    }

}
