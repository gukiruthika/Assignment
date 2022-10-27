package Group1;

import java.util.Scanner;

public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater task = new TrappingRainWater();
		task.process();
	}

	void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int length = scan.nextInt();
		System.out.println("Enter the elements");
		int[] height = new int[length];
		for (int i = 0; i < length; i++)
			height[i] = scan.nextInt();
		scan.close();
		System.out.println(trap(height) + " units of rain water are being trapped");
	}

	public int trap(int[] height) {
		int waterUnits = 0, leftMax = 0, rightMax = 0, length = height.length;
		int[] leftMaximum = new int[length];
		int[] rightMaximum = new int[length];

		for (int i = 1; i < height.length; i++) {
			if (i != 0) {
				leftMax = Math.max(leftMax, height[i - 1]);
				rightMax = Math.max(rightMax, height[length - i]);
			}
			leftMaximum[i] = leftMax;
			rightMaximum[length - i - 1] = rightMax;
		}
		for (int i = 0; i < length - 1; i++) {
			if (Math.min(leftMaximum[i], rightMaximum[i]) > height[i])
				waterUnits += Math.min(leftMaximum[i], rightMaximum[i]) - height[i];
		}
		return waterUnits;
	}

}
