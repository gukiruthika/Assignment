package Group1;

import java.util.Scanner;

public class SingleAppearance2 {

	public static void main(String[] args) {
		SingleAppearance2 task = new SingleAppearance2();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int[] arr = new int[scan.nextInt()];
		System.out.println("Enter elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		System.out.println(getSingleAppearance(arr,0,arr.length));
		
	}
	
	int getSingleAppearance(int[] arr,int start,int end) {
		if(end-start==1) {
			return arr[start];
		}
		int mid = start+(end-start)/2;
		
		if(mid%2==0) {
			if(arr[mid]==arr[mid-1]) {
				return getSingleAppearance(arr,start,mid); 
			}
			else if(arr[mid]==arr[mid+1]) {
				
				return getSingleAppearance(arr,mid+1,end); 
			}
			else {
				return arr[mid];
			}
		}
		else{
			if(arr[mid]==arr[mid-1]) {
				return getSingleAppearance(arr,mid+1,end); 
			}
			else if(arr[mid]==arr[mid+1]) {
				return getSingleAppearance(arr,start,mid); 
			}
			else {
				return arr[mid];
			}
		}
	}
}
