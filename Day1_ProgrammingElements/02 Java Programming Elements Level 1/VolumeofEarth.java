public class VolumeofEarth {

	public static void main(String[] args) {
		int radius = 6378;
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		 double radiusMiles = radius * 0.621371;
		 double volumeMiles = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);
		System.out.println("The volume of earth in cubic kilometers is "+ volume + " and cubic miles is " + volumeMiles );

	}

}
