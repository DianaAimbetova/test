package test;

import java.util.ArrayList;
import java.util.List;

public class Building{
	 protected static String name;
	 static int  totalLight = 0;
	 static int totalSquare = 0;
	 static final int MAXLIGHT = 4000;
	 static final int MAXSQUARE = 70;
	  public Building(String name) {
	    	Building.name = name;
	    }
	    private List<Room> rooms = new ArrayList<>();

	    public void addRoom(Room room) {
	        try {
                rooms.add(room);
            } catch (NullPointerException  n) {
                System.out.println("Проверка на null1");
            }
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        Building.name = name;
	    }

	    public List<Room> getRooms() {
	        return rooms;
	    }

	    public void setRooms(List<Room> rooms) {
	        this.rooms = rooms;
	    }

    public Room getRoom(String roomName){
        List<Room> rooms = getRooms();
        //	System.out.println("------" + rooms.size());
        Room myRoom = null;
        for (Room room : rooms) {
            if(room.getRoomName()== roomName){
                myRoom = room;
                return myRoom;

            }
        }

        return myRoom;
    }



	    public void describe() {

				System.out.println(getName());

                for(Room room : rooms){

                    System.out.println(room.toString());
                }



	    }

}
