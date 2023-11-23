
import java.util.*;

class Room {
	private String name;
	private int capacity;
	private List<String> occupants;

	public Room(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		occupants = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<String> getOccupants() {
		return occupants;
	}

	public boolean isFull() {
		return occupants.size() == capacity;
	}

	public void addOccupant(String occupant) {
		occupants.add(occupant);
	}

	public void removeOccupant(String occupant) {
		occupants.remove(occupant);
	}
}

class Building {
	private List<Room> rooms;

	public Building() {
		rooms = new ArrayList<>();
		rooms.add(new Room("RoomA", 10));
		rooms.add(new Room("RoomB", 10));
		rooms.add(new Room("RoomC", 10));
		rooms.add(new Room("RoomD", 10));
		rooms.add(new Room("RoomE", 10));
		rooms.add(new Room("RoomF", 10));
		rooms.add(new Room("RoomG", 10));
		rooms.add(new Room("RoomH", 10));
		rooms.add(new Room("RoomI", 10));
		rooms.add(new Room("RoomJ", 10));
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void distributePeople(List<String> people) {
		int roomIndex = 0;
		for (String person : people) {
			while (rooms.get(roomIndex).isFull()) {
				roomIndex++;
				if (roomIndex == rooms.size()) {
					roomIndex = 0;
				}
			}
			rooms.get(roomIndex).addOccupant(person);
		}
	}

	public void addPeople(List<String> people) {
		distributePeople(people);
	}

	public void doMaintenance(List<String> roomsToMaintain) {
		for (String roomName : roomsToMaintain) {
			for (Room room : rooms) {
				if (room.getName().equals(roomName)) {
					List<String> occupants = room.getOccupants();
					for (String occupant : occupants) {
						redistributeOccupant(occupant);
					}
					occupants.clear();
					break;
				}
			}
		}
	}

	public void addRoom(String roomName, int capacity) {
		rooms.add(new Room(roomName, capacity));
	}

	public void removePeople(int numPeople) {
		List<String> allOccupants = new ArrayList<>();
		for (Room room : rooms) {
			allOccupants.addAll(room.getOccupants());
			room.getOccupants().clear();
		}
		distributePeople(allOccupants.subList(0, allOccupants.size() - numPeople));
	}

	private void redistributeOccupant(String occupant) {
		Room leastFullRoom = null;
		for (Room room : rooms) {
			if (leastFullRoom == null || room.getOccupants().size() < leastFullRoom.getOccupants().size()) {
				leastFullRoom = room;
			}
		}
		leastFullRoom.addOccupant(occupant);
	}

	public void printOccupancy() {
		for (Room room : rooms) {
			System.out.println(room.getName() + " Occupants: " + room.getOccupants());
		}
	}
}

public class RoomBooking {
	public static void main(String[] args) {
		Building building = new Building();
		// Task 1: Distribute 30 people across 10 rooms
		List<String> initialOccupants = new ArrayList<>(
				Arrays.asList("Person1", "Person2", "Person3", "Person4", "Person5", "Person6", "Person7", "Person8",
						"Person9", "Person10", "Person11", "Person12", "Person13", "Person14", "Person15", "Person16",
						"Person17", "Person18", "Person19", "Person20", "Person21", "Person22", "Person23", "Person24",
						"Person25", "Person26", "Person27", "Person28", "Person29", "Person30"));
		building.distributePeople(initialOccupants);
		System.out.println("Initial occupancy:");
		building.printOccupancy();
		System.out.println();

		// Task 2: Add 5 more people and allocate rooms for them
		List<String> newOccupants = new ArrayList<>(
				Arrays.asList("Person31", "Person32", "Person33", "Person34", "Person35"));
		building.addPeople(newOccupants);
		System.out.println("Occupancy after adding 5 people:");
		building.printOccupancy();
		System.out.println();

		// Task 3: Do maintenance in RoomC and RoomF and reallocate occupants
		List<String> roomsToMaintain = new ArrayList<>(Arrays.asList("RoomC", "RoomF"));
		building.doMaintenance(roomsToMaintain);
		System.out.println("Occupancy after maintenance in RoomC and RoomF:");
		building.printOccupancy();
		System.out.println();

		// Task 4: Add RoomK with capacity of 1 and reallocate occupants
		building.addRoom("RoomK", 1);
		System.out.println("Occupancy after adding RoomK:");
		building.printOccupancy();
		System.out.println();

		// Task 5: Remove 25 people and reallocate occupants
		building.removePeople(25);
		System.out.println("Occupancy after removing 25 people:");
		building.printOccupancy();
		System.out.println();

	}

	class Room {
		private String name;
		private int capacity;
		private List<String> occupants;

		public Room(String name, int capacity) {
			this.name = name;
			this.capacity = capacity;
			occupants = new ArrayList<>();
		}

		public String getName() {
			return name;
		}

		public int getCapacity() {
			return capacity;
		}

		public List<String> getOccupants() {
			return occupants;
		}

		public boolean isFull() {
			return occupants.size() == capacity;
		}

		public void addOccupant(String occupant) {
			occupants.add(occupant);
		}

		public void removeOccupant(String occupant) {
			occupants.remove(occupant);
		}

		class Building {
			private List<Room> rooms;

			public Building() {
				rooms = new ArrayList<>();
				rooms.add(new Room("RoomA", 10));
				rooms.add(new Room("RoomB", 10));
				rooms.add(new Room("RoomC", 10));
				rooms.add(new Room("RoomD", 10));
				rooms.add(new Room("RoomE", 10));
				rooms.add(new Room("RoomF", 10));
				rooms.add(new Room("RoomG", 10));
				rooms.add(new Room("RoomH", 10));
				rooms.add(new Room("RoomI", 10));
				rooms.add(new Room("RoomJ", 10));
			}

			public void distributePeople(List<String> people) {
				// Shuffle the list of people randomly
				Collections.shuffle(people); // Distribute people across rooms
				int numRooms = rooms.size();
				int numPeople = people.size();
				int peoplePerRoom = numPeople / numRooms;
				int extraPeople = numPeople % numRooms;
				int roomIndex = 0;
				for (int i = 0; i < numPeople; i++) {
					String person = people.get(i);
					Room room = rooms.get(roomIndex);
					room.addOccupant(person);
					if (room.isFull()) {
						roomIndex++;
					}
				}

				// Distribute extra people to rooms with lower occupancy
				for (int i = 0; i < extraPeople; i++) {
					Room room = rooms.get(i);
					room.addOccupant(people.get(numPeople - extraPeople + i));
				}
			}

			public void addPeople(List<String> people) {
				// Shuffle the list of people randomly
				Collections.shuffle(people);

				// Allocate rooms for new people
				int numRooms = rooms.size();
				int numPeople = people.size();
				int peoplePerRoom = numPeople / numRooms;
				int extraPeople = numPeople % numRooms;
				int roomIndex = 0;
				for (int i = 0; i < numPeople; i++) {
					String person = people.get(i);
					Room room = rooms.get(roomIndex);
					room.addOccupant(person);
					if (room.isFull()) {
						roomIndex++;
					}
				}

				// Distribute extra people to rooms with lower occupancy
				for (int i = 0; i < extraPeople; i++) {
					Room room = rooms.get(i);
					room.addOccupant(people.get(numPeople - extraPeople + i));
				}
			}

			public void doMaintenance(List<String> roomsToMaintain) {
				// Remove occupants from rooms that need maintenance
				for (String roomName : roomsToMaintain) {
					Room room = getRoomByName(roomName);
					room.getOccupants().clear();
				} // Reallocate occupants to rooms with lower occupancy
				List<String> allOccupants = new ArrayList<>();
				for (Room room : rooms) {
					allOccupants.addAll(room.getOccupants());
					room.getOccupants().clear();
				}
				distributePeople(allOccupants);
			}

			public void addRoom(String name, int capacity) {
				Room room = new Room(name, capacity);
				rooms.add(room);

				// Reallocate occupants to rooms with lower occupancy
				List<String> allOccupants = new ArrayList<>();
				for (Room r : rooms) {
					allOccupants.addAll(r.getOccupants());
					r.getOccupants().clear();
				}
				distributePeople(allOccupants);
			}

			public void removePeople(int numPeopleToRemove) {
				// Remove occupants from rooms with higher occupancy
				List<String> allOccupants = new ArrayList<>();
				for (Room room : rooms) {
					allOccupants.addAll(room.getOccupants());
					room.getOccupants().clear();
				}
				int numOccupantsToRemove = Math.min(numPeopleToRemove, allOccupants.size());
				List<String> occupantsToRemove = new ArrayList<>(allOccupants.subList(0, numOccupantsToRemove));
				allOccupants.removeAll(occupantsToRemove);

				// Reallocate remaining occupants to rooms with lower occupancy
				distributePeople(allOccupants);
			}

			private Room getRoomByName(String name) {
				for (Room room : rooms) {
					if (room.getName().equals(name)) {
						return room;
					}
				}
				return null; // room not found
			}
		}
	}
}
