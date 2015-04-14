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
	
	public boolean included(ExactPoint p) {
				if( p.getTypePoint().equals(TypePoint.MAXIMUM))
					return p.getValue() >= this.getValue();
				else
					return p.getValue() <= this.getValue();
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
