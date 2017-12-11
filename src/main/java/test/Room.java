package test;

import java.util.ArrayList;
import java.util.List;

public class Room {
	 private int windowNum;
	 private int square;
	 private String roomName;
	static final int MAXLIGHT = 4000;
	static final int MAXSQUAREPERCENT = 70;
	static final int WINDOWLIGHT = 700;
	    private List<Furniture> furnitures = new ArrayList<>();
	    private List<Lamp> lamps = new ArrayList<>();
	    public Room(String roomName, int square, int windowNum) {
	    	this.roomName = roomName;
	    	this.square = square;
	        this.windowNum = windowNum;
	    }

	    public void add(Furniture furniture) {

	    		if(isSpaceUsageTooMuch(furniture.furnitureSquare())==true){
					//System.out.println("------" + isSpaceUsageTooMuch(furnitures));
					furnitures.add(furniture);
				} else {
					try {
						throw new SpaceUsageTooMuchException("Слишком мало свободного пространства!");
					} catch (SpaceUsageTooMuchException e) {
						e.printStackTrace();
					}
				}

	    }



	    public void add(Lamp lamp) {
	    	if(isIlluminanceTooMuch(lamp.getLampLight())==true) {
				lamps.add(lamp);
			} else{
				try {
					throw new IlluminanceTooMuchException("Освещение превышает максимум!");
				} catch (IlluminanceTooMuchException e) {
					e.printStackTrace();
				}
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

	    public int getTotalLightOfLamps(){
			List<Lamp> lamps = getLamps();
			int totalLight = 0;
			for (Lamp l:lamps) {
				totalLight+=l.getLampLight();
			}

			return totalLight;
		}

		public int getOccupiedSpace(){
			List<Furniture> furnitures = getFurnitures();
			int totalSquare=0;
			for (Furniture f:furnitures) {
				totalSquare+=f.furnitureSquare();
				//System.out.println("---" + totalSquare);
			}
			//System.out.println("---" + totalSquare);
			return totalSquare;

		}

		public int getFreeSpace(){
	    	int notFree = getOccupiedSpace();
	    	int freeSpace = 0;
			int roomSquare = getSquare();
			freeSpace = roomSquare - notFree;
			return freeSpace;
		}

		public int freeSpacePercent() {
			int notFree = getOccupiedSpace();
			int freeSpace = getFreeSpace();
			int roomSquare = getSquare();
			int freeSpacePercent = 0;
			freeSpacePercent = (100 - ((100*notFree)/roomSquare));
			return freeSpacePercent;
		}

		public String  getFurnituresDesc(){
			List<Furniture>  furnitures = getFurnitures();
			if(!furnitures.isEmpty()) {
				List<String> l = new ArrayList<>();
				String name = "";
				int sq = 0;
				String stroka = "";
				for (Furniture f : furnitures) {
					name = f.furnitureName();
					sq = f.furnitureSquare();
					stroka = name + " (площадь " + sq + "м^2)";
					//System.out.println("-----" + name);
					l.add(stroka);

				}
				StringBuilder out = new StringBuilder();
				for (Object o : l) {
					out.append(o.toString());
					out.append("\n");
				}


				//System.out.println("-----" + name);
				return "Мебель:"  + "\n" + out.toString();
			} else{
				return "Мебели нет";
			}
		}

	public boolean isSpaceUsageTooMuch(int square){
		int totalSquare=getOccupiedSpace() + square;
		int roomSquare = getSquare();
		//System.out.println("room sqaure " + roomSquare);
		//System.out.println("total square " + totalSquare);
		int x = (100*totalSquare)/roomSquare;
		//System.out.println("x = " + x);
		if(x< MAXSQUAREPERCENT){
			//System.out.println("***" + (x< MAXSQUAREPERCENT));
			return true;
		}
		return false;
	}

	public boolean isIlluminanceTooMuch(int light){
		//lamps = getLamps();
		int totalLight = getTotalLightOfLamps() + light;
		//System.out.println("---" + totalLight);
		int x = totalLight + (getWindowNum()*WINDOWLIGHT);
		if(x < MAXLIGHT){
			return true;
		}
		return false;
	}

	@Override
	public String toString(){
	    	return getRoomName() + " " +
					"\n" + "Освещённость = " + (getTotalLightOfLamps()+ (getWindowNum()*WINDOWLIGHT)) + "(" + getWindowNum() + " окна по 700 лк, лампочки "
					+ getTotalLightOfLamps() + "лк)" +
					"\n" + "Площадь = " + getSquare() + " м^2 (занято " + getOccupiedSpace() + " м^2, гарантированно свободно " +
					+ getFreeSpace() + " м^2 или " + freeSpacePercent() + " % площади)" +
					"\n" +  getFurnituresDesc()  ;
	}

}
