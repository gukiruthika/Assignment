package session;

import java.util.Arrays;
import java.util.Scanner;

public class PushSeven {

	public static void main(String[] args) {
		new PushSeven().process();

	}
	
	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the elements");
		for (int i = 0; i < length; i++)
			arr[i] = scan.nextInt();
		scan.close();
		System.out.println(Arrays.toString(toPushSeven(arr)));
	}

	private int[] toPushSeven(int[] arr) {
		int index=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==7) {
				index=i+1;
				while(index<arr.length&&arr[index]==7)
					index++;
				if(index==arr.length)
					break;
				arr[i]=arr[index]+arr[i];
				arr[index]=arr[index]-arr[i];
				arr[i]=arr[index]-arr[i];
			}
		}
		return arr;
	}
	
	

}
