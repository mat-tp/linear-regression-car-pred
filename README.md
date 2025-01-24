LINEAR REGRESSION FOR CAR PRICE PREDICTION
Description

This project uses Linear Regression to predict car prices based on a dataset from Kaggle (CarPrice_Assignment.csv). The primary goal of the project is to leverage linear regression for predictions by analyzing features and calculating weights.

The project incorporates the Apache Commons Math library (commons-math3-3.6.1.jar) for matrix operations, including setting up arrays, performing calculations, and handling matrices efficiently.
How to Use

Follow these steps to set up and run the project:

    Prerequisites:
        Ensure you have Java installed and working correctly on your PC.
        Download the full project files.

    Project Setup:
        Create a new project in your preferred IDE (e.g., Eclipse or IntelliJ).
        Copy all the downloaded files into the project directory.
        Add the commons-math3-3.6.1.jar library to your project’s build path:
            Eclipse: Right-click on the project → Build Path → Add External Archives → Select the .jar file.
            IntelliJ: File → Project Structure → Libraries → Add .jar file.

    Running the Project:
        Compile and run the CarPricePrediction class.
        The program will split the dataset into training and testing data, train the linear regression model, and output the predicted car prices for the test set.

Key Features

    Data Handling:
    Reads and processes data from a Kaggle dataset containing car features and prices.

    Feature Engineering:
    Uses 14 car-related features (e.g., car length, width, engine size) plus an intercept term for the regression model.

    Matrix Operations:
    Efficiently calculates weights using matrix normalization and makes predictions.

    Train-Test Split:
    Splits the dataset into training (80%) and testing (20%) subsets.

Formula Used

The project uses the normalization formula to calculate the weights (w) for the model:
w=(XTX)^(−1)XTYw=(XTX)^(−1)XTY
Where:

    XX: Feature matrix with an intercept term.
    YY: Target variable (car prices).

Conclusions

The project is a work in progress and currently faces challenges with predicting continuous values. Exact matches with actual prices in the dataset are difficult unless the model is overfitting.
