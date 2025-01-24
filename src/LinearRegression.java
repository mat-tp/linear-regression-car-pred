

import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class LinearRegression {
	
	private RealMatrix w, estimate;
	
	// The constructor
	public LinearRegression(double[][] xArray, double[][] yArray) throws  Exception {
		
		// calling the method to apply the normal :
		applyNormalEquation(MatrixUtils.createRealMatrix(xArray),MatrixUtils.createRealMatrix(yArray));
	}
	
	private void applyNormalEquation(RealMatrix x, RealMatrix y) throws Exception {
		// multiplying the x-transpose by x : 
		LUDecomposition lUDecomposition = new LUDecomposition(x.transpose().multiply(x));
		
		//handling an exception :
		if(lUDecomposition.getDeterminant() == 0.0) 
			throw new Exception("singular matrx w/ no inverse.");
		else {
			// calculating the weights :
			this.w = lUDecomposition.getSolver().getInverse().multiply((x.transpose().multiply(y)));
			
			// calculating the estimates : 
			this.estimate = x.multiply(w);
		}
		
	}
	
	public RealMatrix getw() {
		return this.w;
	}
	
	public RealMatrix getestimate() {
		return this.estimate;
	}

}

