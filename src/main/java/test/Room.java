package test;

import java.util.ArrayList;
import java.util.List;

public class Room {
	 private int windowNum;
	 private int square;
	 private String roomName;
	 
	    private List<Furniture> furnitures = new ArrayList<>();
	    private List<Lamp> lamps = new ArrayList<>();
	    public Room(String roomName, int square, int windowNum) {
	    	this.roomName = roomName;
	    	this.square = square;
	        this.windowNum = windowNum;
	    }

	    public void add(Furniture furniture) {
	    	try {
				furnitures.add(furniture);
			}catch (NullPointerException  n){
				System.out.println("index is out of range.");
			}

	    }
	    
	    public void add(Lamp lamp) {
	    	try{
	        lamps.add(lamp);
		}catch (NullPointerException  n){
		System.out.println("index is out of range.");
	}
	    }
	    
	    public String getRoomName() {
	        return roomName;
	    }

	    public void setRoomName(String roomName) {
	        this.roomName = roomName;
	    }

	    public int getSquare() {
	        return square;
	    }

	    public void setSquare(int square) {
	        this.square = square;
	    }
	    
	    public int getWindowNum() {
	        return windowNum;
	    }

	    public void setWindowNum(int windowNum) {
	        this.windowNum = windowNum;
	    }

	    public List<Furniture> getFurnitures() {
	        return furnitures;
	    }

	    public void setFurnitures(List<Furniture> furnitures) {
	        this.furnitures = furnitures;
	    }

	    public List<Lamp> getLamps() {
	        return lamps;
	    }

	    public void setLamps(List<Lamp> lamps) {
	        this.lamps = lamps;
	    }
}
