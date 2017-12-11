package test;

public class Chair implements Furnitures {
	
	 private String furnitureName;
	 private int furnitureSquare;


	    public Chair(String furnitureName, int furnitureSquare) {
	        this.furnitureName = furnitureName;
	        this.furnitureSquare = furnitureSquare;
	    }
	    
	    public int furnitureSquare() {
	        return furnitureSquare;
	    }

	    public void setFurnitureSquare(int furnitureSquare) {
	        this.furnitureSquare = furnitureSquare;
	    }
	    
	    
	    public String furnitureName() {
	        return furnitureName;
	    }

	    public void setFurnitureName(String furnitureName) {
	        this.furnitureName = furnitureName;
	    }




	   
}
