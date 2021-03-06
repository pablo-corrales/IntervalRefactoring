package intervals;

public class UntilPoint extends Point{
	
	public UntilPoint(double value) {
		super(value);
	}
	
	
	public boolean includes(Point point){
			return point.included(this);
	}
	
	@Override
	public boolean intersectsWith(Point point) {
			return point.getValue() < this.getValue();
	}
		
	@Override
	public boolean contained(From_ExactPoint p) {
			return p.getValue() < this.getValue();
	}
	
	@Override
	public boolean contained(Until_ExactPoint p) {
			return p.getValue() > this.getValue();
	}
	
	@Override
	public boolean included(FromPoint fromPoint) {
			return fromPoint.getValue() < this.getValue();
	}
	
	@Override
	public boolean included(UntilPoint untilPoint) {
			return this.getValue() <= untilPoint.getValue();
	}
	
	@Override
	public String toString() {
			return this.getValue() + ")";
	}
}
