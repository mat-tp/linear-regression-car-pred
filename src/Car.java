

/**
 * This is a class for each car, that has the characteristics of the a Car from a file.
 */
public class Car {
	
    public int carID; // the id
    public int symboling; // symboling
    public String CarName; // the brand
    public String fueltype;
    public String aspiration;
    public String doornumber;
    public String carbody;
    public String drivewheel;
    public String engineLocation;
    public double wheelBase; // parameter 1
    public double carLength; // parameter 2
    public double carWidth; // parameter 3
    public double carHeight; // parameter 4
    public int curbWeight; // parameter 5
    public String enginetype; 
    public String cylindernumber;
    public int enginesize; // parameter 7
    public String fuelsystem;
    public double boreratio; // parameter 8
    public double stroke; // parameter 9
    public double compressionRatio; // parameter 10
    public int housePower; // parameter 11
    public int peakrpm; // parameter 12
    public int citympg; // parameter 13
    public int highwaympg; // parameter 14
    public double price;
    
    

    // The constructor of the car.
    public Car(int carID,int symboling, String CarName, String fueltype, String aspiration, String doornumber, String carbody, String drivewheel, String engineLocation, double wheelBase,double carLength,double carWidth,double carHeight,int curbWeight,String enginetype,String cylindernumber,int enginesize,String fuelsystem,double boreratio,double stroke,double compressionRatio,int housePower,int peakrpm,int citympg,int highwaympg, double price) {
    	   this.carID = carID; // the id
    	   this.symboling = symboling;
    	   this.CarName = CarName;	
    	   this.fueltype = fueltype;
    	   this.aspiration = aspiration;
    	   this.doornumber = doornumber;
    	   this.carbody = carbody;
    	   this.drivewheel = drivewheel;
    	   this.engineLocation = engineLocation;
    	   this.wheelBase = wheelBase;
    	   this.carLength = carLength;
    	   this.carWidth = carWidth;
    	   this.carHeight = carHeight;
    	   this.curbWeight = curbWeight;
    	   this.enginetype = enginetype;
    	   this.cylindernumber = cylindernumber;
    	   this.enginesize = enginesize;
    	   this.fuelsystem = fuelsystem;
    	   this.boreratio = boreratio;
    	   this.stroke = stroke;
    	   this.compressionRatio = compressionRatio;
    	   this.housePower = housePower;
    	   this.peakrpm = peakrpm;
    	   this.citympg = citympg;
    	   this.highwaympg = highwaympg;
    	   this.price = price;
    }
}

