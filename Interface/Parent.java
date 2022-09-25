package git;

public interface Parent {
	
	default void print() {
		println();
	}

	void println();
}
