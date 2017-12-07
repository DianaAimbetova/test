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


	    public void describe() throws IlluminanceTooMuchException, SpaceUsageTooMuchException {

				System.out.println(getName());

				List<Room> rooms = getRooms();
				for (Room room : rooms) {
				    try{
					System.out.println(room.getRoomName());
                    }catch (NullPointerException  n) {
                        System.out.println("Комната не может быть null");
                    }
                    try {
                        List<Lamp> lamps = room.getLamps();

                            for (Lamp lamp : lamps) {
                                if (lamp.getLampLight() > 0) {
                                    //System.out.println("----------  " + lamp.getLampLight());
                                    if (lamps.size() > 1) {
                                        totalLight += lamp.getLampLight();
                                    } else {
                                        totalLight = lamp.getLampLight();
                                    }

                                } else {
                                    throw new IllegalArgumentException("Освещение ламп не может быть отрицательным числом");
                                }
                            }

                    } catch (NullPointerException  n) {
                        System.out.println("Лампочки не могут быть null");
                    }
                    try{
				        if(room.getWindowNum() > 0) {

                            if ((room.getWindowNum() * 700 + totalLight) < MAXLIGHT) {
                                System.out.println("Освещённость = " + (room.getWindowNum() * 700 + totalLight) + " (" + room.getWindowNum() + " окна по 700 лк, лампочки " + totalLight + "лк)");
                            } else {
                                throw new IlluminanceTooMuchException("Освещение превышает максимум!");
                            }
                        }else{
                           throw new IllegalArgumentException("Количество окон не может быть отрицательным числом");
                        }
                }catch (NullPointerException  n) {
                    System.out.println("Комната is null, нельзя посчитать количество окон ");
                }
                    try{
					List<Furniture> furnitures = room.getFurnitures();
					if (furnitures.isEmpty()) {
						System.out.println("Мебели нет");
					} else {
						System.out.println("Мебель:");

						for (Furniture furniture : furnitures) {
                            if (furniture.furnitureSquare() > 0) {
                                System.out.println(furniture.furnitureName() + " (площадь= " + furniture.furnitureSquare() + "м^2)");
                                totalSquare += furniture.furnitureSquare();
                            }else{
                                throw new IllegalArgumentException("Площадь мебели не может быть отрицательным числом");
                            }
						}


					}
                    }catch (NullPointerException  n) {
                        System.out.println("Мебель не может быть null");
                    }
                    try{
				        if(room.getSquare() > 0) {
                            int percentFree = 100 - ((totalSquare * 100) / room.getSquare());
                            int percentFull = 100 - percentFree;
                            if (percentFull < MAXSQUARE) {
                                if (percentFree != 100) {
                                    System.out.println("Площадь = " + room.getSquare() + "м^2 (занято " + totalSquare + "м^2)" + ", гарантированно свободно " + (room.getSquare() - totalSquare) + "м^2 или " + percentFree + "% площади");
                                } else {
                                    System.out.println("Площадь = " + room.getSquare() + "м^2 (свободно 100%) ");

                                }
                            } else {
                                throw new SpaceUsageTooMuchException("Слишком мало свободного пространства!");
                            }
                        }else{
                        throw  new IllegalArgumentException("Площадь комнаты не может быть отрицательным числом");
                    }
                    }catch (ArithmeticException ae) {
                        System.out.println("Площадь комнаты не может быть равна 0");

				    }catch (NullPointerException  n) {
                System.out.println("Площадь комнаты равна 0, потому что комната is null");
            }

                }



	    }

}
