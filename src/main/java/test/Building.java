package test;

import java.util.ArrayList;
import java.util.List;

public class Building{
	 protected static String name;
	  public Building(String name) {
	    	Building.name = name;
	    }
	    private List<Room> rooms = new ArrayList<>();

	    public void addRoom(Room room) {

                rooms.add(room);

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
	        try {

                for (Room room : rooms) {
                    if (room.getRoomName() == roomName) {
                        myRoom = room;
                        return myRoom;

                    }
                }
            }catch(NullPointerException e){
                System.out.println("Такой комнаты не существует");
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
