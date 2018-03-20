package java8test.PersionFunction;


/**
 *
 * person工厂函数式接口
 * @author slc
 * @param <P>
 */
public interface PersonFactory<P extends Person> {

    P create();
}
