package Group1;


public class Singleton {

	public static void main(String[] args) {
		SingletonExample singletonExample1 = SingletonExample.getInstance();
		SingletonExample singletonExample2 = SingletonExample.getInstance();
		System.out.println(singletonExample1);
		System.out.println(singletonExample2);
		//both refer same object
	}

}
