package test;

public class Test {


    public static void main(String[] args) throws IlluminanceTooMuchException, SpaceUsageTooMuchException {
    	
        Furniture f1 = new Furniture("Стол письменный",3);
        Furniture f2 = new Furniture("Кресло мягкое и пушистое",1);
        Furniture f3 = new Furniture("Диван",10);
        Lamp l1 = new Lamp("Лампочка",150);
        Lamp l2 = new Lamp("Лампочка",250);
        Lamp l3 = new Lamp("Лампочка",500);
        Room room1 = new Room("Комната 1", 100, 3);
        Room room2 = new Room("Комната 2", 50, 2);
        Room room3 = new Room("Комната 3", 35, 1);
        room2.add(f1);
        room2.add(f2);
        room2.add(l1);
        room2.add(l2);
        room3.add(l3);
        room3.add(f3);
        Building building = new Building("Здание 1");
        building.addRoom(room1);
        building.addRoom(room2);
        building.addRoom(room3);
        building.describe();

    }

}
