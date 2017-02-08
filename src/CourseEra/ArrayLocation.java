package CourseEra;

public class ArrayLocation {
	
	private double coords[];
	
	public ArrayLocation( double[] coords){
		this.coords = coords;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] coords = {5.0,0.0};
		ArrayLocation accra = new ArrayLocation(coords);
		
		coords[0] = 12.0;
		coords[1] = 13.0;
		
		System.out.println(accra.coords[0]);
		
	}

}
