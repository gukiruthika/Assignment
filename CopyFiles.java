package session;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CopyFiles {

	class FileComparator implements Comparator<File> {

		@Override
		public int compare(File f1, File f2) {
			if (f1.length() > f2.length())
				return 1;
			else if (f1.length() < f2.length())
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) {
		CopyFiles task = new CopyFiles();
		task.process();
	}

	private void process() {
		File folder = new File("/C:/Users/home/Downloads/Documents/AssignmentFiles");
		File[] listOfFiles = folder.listFiles();
		PriorityQueue<File> fileList = new PriorityQueue<>(new FileComparator());
		for (File file : listOfFiles) {
			if (file.isFile()) {
				fileList.add(file);
			}
		}
		System.out.println();
		int size = fileList.size();
		for (int i = 0; i < size; i++) {
			File file = fileList.poll();
			if (file.isFile()) {
				System.out.println((i+1) + " ) " + file.getName() + " - " + (file.length() / 1024) + "kb");
				try {
					String filepath = "/C:/Users/home/Downloads/Documents/CopyFiles/" + file.getName();
					copyFile(file.getAbsolutePath(), filepath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void copyFile(String from, String to) throws IOException {
		File of = new File(from);
		File df = new File(to);
		Files.copy(of.toPath(), df.toPath());
	}

}