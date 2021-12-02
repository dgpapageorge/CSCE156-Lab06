package unl.cse;

import java.util.Arrays;
import java.util.List;

public class MomentUtils {
	
	/**
	 * Computes the moment of the given set of values using the
	 * specified <code>alpha</code> and <code>k</code> parameters.
	 * @param values
	 * @param alpha
	 * @param k
	 * @return
	 */
	public static double moment(List<Double> values, double alpha, int k) {
		double num = 0;
		for (double x = 0;x<values.size();x++)
		{
			num+=Math.pow((values.get((int)x)-alpha),k);
		}
		return num/values.size();
	}
	
	public static double moment(List<Double> values, double alpha) {
		double num = 0;
		for (double x = 0;x<values.size();x++)
		{
			num+=(values.get((int)x)-alpha);
		}
		return num/values.size();
	}
	public static double moment(List<Double> values, int k) {
		double num = 0;
		for (double x = 0;x<values.size();x++)
		{
			num+=Math.pow(values.get((int)x),k);
		}
		return num/values.size();
	}
	public static double moment(List<Double> values) {
		double num = 0;
		for (double x = 0;x<values.size();x++)
		{
			num+=(values.get((int)x));
		}
		return num/values.size();
	}
	public static void main(String args[]) {
		
		List<Double> numbers = Arrays.asList(-6.190000e-1, -1.042570e+0, -2.633440e-1, 
				-7.471450e-1, 2.117680e+0, 2.933850e-1, -7.245130e-1, -9.494510e-1, -1.019190e+0, 
				-9.099270e-1, -2.632650e-1, -1.074240e-1, 1.315500e+0, 6.606400e-2, 8.750930e-1, 
				-9.419930e-1, -1.050610e+0, -1.090710e+0, 3.339850e-1, 7.784820e-1);
		
		//Example: double x = moment(numbers, 1, 2);
		//System.out.println(x);
		System.out.println(moment(numbers,1,2));
	}
	
}
