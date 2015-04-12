package intervals;

public abstract class Point {
	
	protected double value;
	
	public Point(double value) {
		this.value = value;
	}
	
	public abstract boolean esMenorQue(double value);
	
	public abstract boolean esMayorQue(double value);
	
	public abstract boolean esMenorIgualQue(double value);
	
	public abstract boolean esMayorIgualQue(double value);

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
