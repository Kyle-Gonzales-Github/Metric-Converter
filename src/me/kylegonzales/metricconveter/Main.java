package me.kylegonzales.metricconveter;

import java.util.Scanner;

public class Main {
	
	private static boolean exit = false;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (exit == false) {
			System.out.println("Welcome to the metric converter! For Example: 1 kg = g");
			String input = scanner.nextLine();
			String[] strLength = input.split(" ");
			float sourceNum = 0;
			String fromMetric = " ";
			String toMetric = " ";
			if (input.equals("exit")) {
				System.out.println("You have now exited the program.");
				exit = true;
				scanner.close();
				break;
			}
			try {
				if (strLength.length < 3 || strLength.length > 4) {
					 System.out.printf("Your input is , which is not handled%n Please try again", input);
				} else if (strLength.length == 3) {
					sourceNum = Float.parseFloat(strLength[0]);
			        fromMetric = strLength[1];
			        toMetric = strLength[2];
				}  else {
			        sourceNum = Float.parseFloat(strLength[0]);
			        fromMetric = strLength[1];
			        toMetric = strLength[3];
			      }
			      convert(sourceNum, fromMetric, toMetric);
			} catch (Exception e) {
				System.out.println("Something was inputted wrong, please try again.");
			}
		}
	}
	
	public static float convert(float sourceNum, String fromMetric, String toMetric) {
		float targetNum = 0;
		switch (fromMetric) {
		case "kg":
			switch (toMetric) {
			case "g": //kg to g
				targetNum = sourceNum * 1000;
			case "pnd":
				targetNum = (float) (sourceNum * 2.2046);
			}
			break;
		case "o": //ounces to Grams
			switch (toMetric) {
			case "g":
				targetNum = (float) (sourceNum /0.035274);
			}
			break;
		case "c": // celcius to farenheight
			switch (toMetric) {
			case "f":
				targetNum = (float) ((sourceNum * 1.8) + 32);
			}
			break;
		case "mi":
			switch (toMetric) {
			case "ft": // miles to feet
				targetNum = sourceNum * 5280;
			case "in": // miles to inches
				targetNum = sourceNum * 63360;
			}
			break;
		}
		System.out.println(" ");
		System.out.printf("%.2f %s = %.2f %s%n", sourceNum, fromMetric, targetNum, toMetric);
		System.out.println(" ");
		return targetNum;
	}
}
