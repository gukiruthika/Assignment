package session;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InterviewPanelApplication {

	static Queue<String> waitingRoom = new LinkedList<>();
	static Queue<String> mainRoom = new LinkedList<>();
	static List<String> selected = new ArrayList<>();
	static String currentCandidate;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		InterviewPanelApplication task = new InterviewPanelApplication();
		task.process();
	}

	private void process() {
		setup();
		viewMenu();
		System.out.println("Thank you!!");
	}

	private void viewMenu() {
		String option;
		System.out.println();
		System.out.println("""
				1) Add new Candidate
				2) View Candidates in waiting room
				3) View Candidates in main room
				4) View Candidate in interview room
				5) Switch to next Candidate
				6) View Selected Candidates
				7) To Exit
				""");
		option = scan.nextLine();
		switch (option) {
		case "1":
			addCandidate();
			break;
		case "2":
			viewWaitingRoom();
			break;
		case "3":
			viewMainRoom();
			break;
		case "4":
			viewInterviewRoom();
			break;
		case "5":
			nextCandidate();
			break;
		case "6":
			viewSelected();
			break;
		case "7":
			break;
		default:
			System.out.println("Invalid option");
		}
		if (!option.equals("7"))
			viewMenu();
	}

	private void viewSelected() {
		if(selected.size()==0)
			System.out.println("No candidates have been selected yet");
		for(String candidate:selected)
			System.out.println(candidate);
	}

	private void setup() {
		mainRoom.add("Abi");
		mainRoom.add("Banu");
		mainRoom.add("Cathrine");
		mainRoom.add("Dhivya");
		mainRoom.add("Ezhil");
		mainRoom.add("Fathima");
		mainRoom.add("Gomathi");
		mainRoom.add("Hema");
		mainRoom.add("Ilakiya");
		insertIntoWaitingRoom();
		nextCandidate();
	}

	private void nextCandidate() {
		if(currentCandidate!=null) {
		System.out.println("Is " + currentCandidate + " selected?(Y/N)");
		char option = scan.next().charAt(0);
		if(option=='Y')
			selected.add(currentCandidate);
		}
		currentCandidate = waitingRoom.poll();
		insertIntoWaitingRoom();
	}

	private void viewInterviewRoom() {
		if (currentCandidate == null)
			System.out.println("No candidate is currently being interviewed");
		else
			System.out.println(currentCandidate + " is currently being interviewed");
	}

	private void viewMainRoom() {
		System.out.println("Main Room");
		int i = 1;
		for (String candidate : mainRoom) {
			System.out.println(i++ + ") " + candidate);
		}
	}

	private void viewWaitingRoom() {
		System.out.println("Waiting Room");
		int i = 1;
		for (String candidate : waitingRoom) {
			System.out.println(i++ + ") " + candidate);
		}
	}

	private void addCandidate() {
		System.out.println("Enter Candidates name");
		mainRoom.add(scan.nextLine());
	}

	private void insertIntoWaitingRoom() {
		while (waitingRoom.size() < 5) {
			waitingRoom.add(mainRoom.poll());
		}
	}

}
