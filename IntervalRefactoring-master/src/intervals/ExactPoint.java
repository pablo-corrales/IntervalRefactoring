package intervals;

public abstract class ExactPoint extends Point{
	
	
	public ExactPoint(double number) {
 		super(number);
		
	}
	
	
	public abstract boolean includes(Point p);
	
	public abstract boolean intersectsWith(Point point);
	
	@Override
	public boolean contained(From_ExactPoint point) {
			return point.getValue() <= this.getValue();
	}
	
	@Override
	public boolean contained(Until_ExactPoint p) {
			return p.getValue() >= this.getValue();
	}
	
	@Override
	public boolean included(FromPoint fromPoint) {
		return fromPoint.getValue() < this.getValue();
	}
	
	@Override
	public boolean included(UntilPoint untilPoint) {
			return this.getValue() < untilPoint.getValue();
	}
	
	
}
