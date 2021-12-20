package boluo.generic;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Generic {

	private static final Logger logger = LoggerFactory.getLogger(Generic.class);

	// TODO https://juejin.cn/post/6960913691990556680
	public static void main(String[] args) {

	}

	@Test
	public void func1() {
		// 在Java中, 泛型只在编译阶段有效
		List<String> stringArrayList = new ArrayList<>();
		List<Integer> integerArrayList = new ArrayList<>();

		Class classStringArrayList = stringArrayList.getClass();
		Class classIntegerArrayList = integerArrayList.getClass();

		// 在编译之后程序会采取去泛型化的措施, 也就是说, Java中的泛型, 只在编译阶段有效
		// 泛型信息不会进入到运行时阶段
		if (classStringArrayList.equals(classIntegerArrayList)) {
			logger.info("泛型测试, 类型相同!");
		}
	}

	// 泛型有三种使用方式: 泛型类, 泛型接口, 泛型方法
	// 一个最普通的泛型类:
	public class Generic1<T> {    // 这里T可以随便写为任意标识, 常见的如T, E, K, V等
		// key这个成员变量的类型为T, T的类型由外部指定
		private T key;

		public Generic1(T key) {        // 泛型构造方法形参key的类型也为T, T的类型由外部指定
			this.key = key;
		}

		public T getKey() {        // 泛型方法getKey的返回值类型为T, T的类型由外部指定
			return key;
		}
	}

	@Test
	public void func2() {
		// 泛型的类型只能是类类型(包括自定义类), 不能是基本类型
		// 传入的实参类型与泛型的类型参数类型相同, 即为Integer, String
		Generic1<Integer> genericInteger = new Generic1<>(123456);
		Generic1<String> genericString = new Generic1<>("key_value");

		logger.info("泛型测试, key is {}", genericInteger.getKey());
		logger.info("泛型测试, key is {}", genericString.getKey());
	}

}

// 泛型接口
interface Generator<T> {
	public T next();
}

/**
 * 未传入泛型实参时, 与泛型类的定义相同, 在声明类的时候, 需要将泛型的声明一并加入到类中
 *
 * @param <T>
 */
class FruitGenerator<T> implements Generator<T> {

	private T[] fruits;

	@Override
	public T next() {
		return null;
	}
}

