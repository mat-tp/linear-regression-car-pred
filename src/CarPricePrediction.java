

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * This is the main class.
 */
public class CarPricePrediction {

    public static void main(String[] args) throws Exception {
    	
        // Read car data from the file using CarDataReader
        List<Car> cars = CarDataReader.readfile();
        int numCarsFromFile = cars.size();
		
        int numTrainingData = (int) (numCarsFromFile * 0.8);
        System.out.println("The training data size = " + numTrainingData);
        
        int numTestData = numCarsFromFile - numTrainingData;
        System.out.println("The test data size = " + numTestData);
        
        // Extract features (14 parameters) and prices for training
        double[][] x_array = new double[numTrainingData][15];  // 14 features
        double[][] y_array = new double[numTrainingData][1];   // Target variable: Price
        List<String> features_weights = new ArrayList<>();
        
        for (int i = 0; i < numTrainingData; i++) {
            
        	Car car = cars.get(i);
            
            // intercept: Set the first column to 1
            x_array[i][0] = 1.0; 

            // Features: Populate the rest of the columns
            x_array[i][1] = car.symboling;
            x_array[i][2] = car.wheelBase;
            x_array[i][3] = car.carLength;
            x_array[i][4] = car.carWidth;
            x_array[i][5] = car.carHeight;
            x_array[i][6] = car.curbWeight;
            x_array[i][7] = car.enginesize;
            x_array[i][8] = car.boreratio;
            x_array[i][9] = car.stroke;
            x_array[i][10] = car.compressionRatio;
            x_array[i][11] = car.housePower;
            x_array[i][12] = car.peakrpm;
            x_array[i][13] = car.citympg;
            x_array[i][14] = car.highwaympg;
           
   
            y_array[i][0] = car.price;  // Target: price
        }

        System.out.println("x_array (training data):");
        for (double[] row : x_array) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("y_array (training data):");
        for (double[] row : y_array) {
            System.out.println(Arrays.toString(row));
        }
        
        // Train the linear regression model
        LinearRegression lr = new LinearRegression(x_array, y_array);
        
        // Get the weights
        RealMatrix weights = lr.getw();
        for (int i = 0; i < weights.getRowDimension(); i++) {
            System.out.println("Weight " + i + " headers "   + ": " + weights.getEntry(i, 0));
        }

         //Generated test data.
//        // Testing with new car data :
//        double[][] newCarData = {
//            {102, 168, 65, 48, 2500, 1, 4, 120, 1, 3.2, 3.5, 10, 110, 6000}, // Example car data
//            {105, 175, 70, 52, 2700, 0, 6, 180, 0, 3.5, 3.2, 9.5, 150, 5500}  // Example car data
//        };
//        
//        RealMatrix newCarMatrix = MatrixUtils.createRealMatrix(newCarData);
//        RealMatrix predictedPrices = newCarMatrix.multiply(weights);
//  
//        // Print predicted prices for the new cars
//        System.out.println("Predicted Prices for New Cars:");
//        for (int i = 0; i < predictedPrices.getRowDimension(); i++) {
//            System.out.println("Predicted Price for Car " + (i + 1) + ": " + predictedPrices.getEntry(i, 0));
//        }

        // Extract test data from the file using 14 features:
        double[][] x_testData = new double[numTestData][15];
        double[] actualPrices = new double[numTestData];
        
        for (int i = numTrainingData; i < numCarsFromFile; i++) {
            int index = i - numTrainingData;
            Car car = cars.get(i);
            
            // intercept: Set the first column to 1
            x_testData[index][0] = 1.0; 

            // Features: Populate the rest of the columns
            x_testData[index][1] = car.symboling;
            x_testData[index][2] = car.wheelBase;
            x_testData[index][3] = car.carLength;
            x_testData[index][4] = car.carWidth;
            x_testData[index][5] = car.carHeight;
            x_testData[index][6] = car.curbWeight;
            x_testData[index][7] = car.enginesize;
            x_testData[index][8] = car.boreratio;
            x_testData[index][9] = car.stroke;
            x_testData[index][10] = car.compressionRatio;
            x_testData[index][11] = car.housePower;
            x_testData[index][12] = car.peakrpm;
            x_testData[index][13] = car.citympg;
            x_testData[index][14] = car.highwaympg;
            
            
            actualPrices[index] = car.price;
            
        }
        
        RealMatrix testCarMatrix = MatrixUtils.createRealMatrix(x_testData);
        RealMatrix predictedTestPrices = testCarMatrix.multiply(weights);

        // Print predicted prices for the test data:
        System.out.println("Predicted Prices for Test Cars:");
        for (int i = 0; i < predictedTestPrices.getRowDimension(); i++) {
            System.out.println("Predicted Price for Test Car " + (i + 1) + ": " + predictedTestPrices.getEntry(i, 0));
        }

    }
    
}