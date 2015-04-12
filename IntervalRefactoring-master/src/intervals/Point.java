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
	
	public boolean includes(Point p){
				return true;
	}
			
	public abstract boolean included(FromPoint fromPoint);	
	public abstract boolean included(UntilPoint untilPoint);
			
	@Override
	public boolean equals(Object object) {
		 		Point point = (Point) object;
		 		return this.getValue() == point.getValue();
	}
	

}
