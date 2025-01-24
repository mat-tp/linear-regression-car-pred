

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class will be responsible for reading the cars from a .csv file.
 */
public class CarDataReader {

	public static List<String> headersL = new ArrayList<>(); 

    // method for reading the files.
    public static List<Car> readfile() {
        // the list of the cars that are being read from the file.
        List<Car> carList = new ArrayList<>();

        String filepath = "data/CarPrice_Assignment.csv";
        File file = new File(filepath); // the file handler.

        try (Scanner sc = new Scanner(file)) {
            // reading and skipping headers
        	 List<String> headerList = new ArrayList<>();
            if (sc.hasNextLine()) {
            	String colnames = sc.nextLine();
            	System.out.println("The headers of the file: " + colnames);
            	
            	headerList = Arrays.asList(colnames.split(","));
            	try {
					headersL =headerList;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            // reading the rest of the file
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split(",");

                // Parse each value into appropriate types
                int carID = Integer.parseInt(values[0]);
                int symboling = Integer.parseInt(values[1]);
                String CarName = values[2];
                String fueltype = values[3];
                String aspiration = values[4];
                String doornumber = values[5];
                String carbody = values[6];
                String drivewheel = values[7];
                String engineLocation = values[8];
                double wheelBase = Double.parseDouble(values[9]);
                double carLength = Double.parseDouble(values[10]);
                double carWidth = Double.parseDouble(values[11]);
                double carHeight = Double.parseDouble(values[12]);
                int curbWeight = Integer.parseInt(values[13]);
                String enginetype = values[14];
                String cylindernumber = values[15];
                int enginesize = Integer.parseInt(values[16]);
                String fuelsystem = values[17];
                double boreratio = Double.parseDouble(values[18]);
                double stroke = Double.parseDouble(values[19]);
                double compressionRatio = Double.parseDouble(values[20]);
                int housePower = Integer.parseInt(values[21]);
                int peakrpm = Integer.parseInt(values[22]);
                int citympg = Integer.parseInt(values[23]);
                int highwaympg = Integer.parseInt(values[24]);
                double price = Double.parseDouble(values[25]);

                // Create a Car object and add it to the list
                Car car = new Car(carID, symboling, CarName, fueltype, aspiration, doornumber, carbody, drivewheel,
                        engineLocation, wheelBase, carLength, carWidth, carHeight, curbWeight, enginetype,
                        cylindernumber, enginesize, fuelsystem, boreratio, stroke, compressionRatio, housePower,
                        peakrpm, citympg, highwaympg, price);

                carList.add(car);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return carList;
    }
}
