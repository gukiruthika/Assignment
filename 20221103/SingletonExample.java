package Group1;


class SingletonExample {
	private static SingletonExample singletonExample;
	private SingletonExample() {
		
	}
	public static SingletonExample getInstance() {
		if (singletonExample == null) {
			singletonExample = new SingletonExample();
			System.out.println("New Object is created");
		}
		else {
			System.out.println("Object can be created only once");
		}
		return singletonExample;
	}
}
