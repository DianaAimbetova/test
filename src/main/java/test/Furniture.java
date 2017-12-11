package test;

public class Furniture implements Furnitures {
    protected String fName;
    protected int fSquare;

    public Furniture(String fName, int fSquare) {
        this.fName = fName;
        this.fSquare = fSquare;
    }

    public Furniture() {
    }

    @Override
    public int furnitureSquare() {
        return fSquare;
    }

    @Override
    public String furnitureName() {
        return fName;
    }

    @Override
    public void setFurnitureName(String fName) {
        this.fName = fName;
    }

    @Override
    public void setFurnitureSquare(int fSquare) {
        this.fSquare = fSquare;
    }
}
