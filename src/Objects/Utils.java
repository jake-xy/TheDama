package Objects;

public abstract class Utils {

	
	// appending an array to a 2D array
	public static double[][] append(double[] item, double[][] array) {
		double[][] out = new double[array.length + 1][2];
		
		for (int i = 0; i < array.length; i++) {
			out[i] = array[i].clone();
		}
		
		out[out.length-1] = item.clone();
		
		return out;
	}
	
}
