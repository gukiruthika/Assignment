package Group1;

public class ImmutableString {

	public static void main(String[] args) {
		ImmutableString task = new ImmutableString();
		task.process();
	}

	private void process() {
		String word1 = "Apple";
		String word2 = "Apple";
		System.out.println(checkReference(word1,word2));
		word1 = word1+"s";
		System.out.println(checkReference(word1,word2));
	}

	private String checkReference(String x, String y) {
		if (x == y)
			return "Both pointing to the same reference";
		
		return "Both are pointing to different reference";
	}

}
