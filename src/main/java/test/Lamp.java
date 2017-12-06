package test;

public class Lamp {
	

	private int lampLight;
	private String lampName;
	
	 public Lamp(String lampName, int lampLight) {
			// TODO Auto-generated constructor stub
		 this.lampName = lampName;
		 this.lampLight = lampLight;
		}
	 
	 public String getlampName() {
	        return lampName;
	    }

	    public void setlampName(String lampName) {
	        this.lampName = lampName;
	    }

	    public int getLampLight() {
	        return lampLight;
	    }

	    public void setLampLight(int lampLight) {
	        this.lampLight = lampLight;
	    }
}
