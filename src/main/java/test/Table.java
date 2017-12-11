package test;

public class Table implements Furnitures {
    private String tableName;
    private int tableSquare;

    public Table( String tableName, int tableSquare) {
        this.tableName = tableName;
        this.tableSquare = tableSquare;
    }
    @Override
    public int furnitureSquare() {
        return tableSquare;
    }

    @Override
    public String furnitureName() {
        return tableName;
    }

    @Override
    public void setFurnitureName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void setFurnitureSquare(int tableSquare) {
        this.tableSquare = tableSquare;
    }
}
