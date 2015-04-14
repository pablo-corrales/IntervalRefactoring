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
	
	public abstract boolean includes(Point p);
	
	public boolean included(From_ExactPoint point) {
			return point.getValue() <= this.getValue();
	}
		
	public boolean included(Until_ExactPoint point) {
			return point.getValue() >= this.getValue();
	}
	
	public abstract boolean included(FromPoint fromPoint);	
	public abstract boolean included(UntilPoint untilPoint);
	
	public abstract boolean intersectsWith(Point point);
	
	public abstract boolean contained(From_ExactPoint p);
	public abstract boolean contained(Until_ExactPoint p);
	
			
	@Override
	public boolean equals(Object object) {
		 		Point point = (Point) object;
		 		return point.getValue() == point.getValue();
	}
	

}
