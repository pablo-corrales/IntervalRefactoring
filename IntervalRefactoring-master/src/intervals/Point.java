package intervals;

public abstract class Point {
	
	protected double value;
	
	public Point(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	

}
