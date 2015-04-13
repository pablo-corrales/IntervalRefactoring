package intervals;

public class ExactPoint extends Point{
	private TypePoint typePoint;
	
	public ExactPoint(double number, TypePoint typePoint) {
 		super(number);
		this.typePoint = typePoint;
	}
	
	protected TypePoint getTypePoint() {
		return typePoint;
	}

	public boolean includes(Point point){
		return point.included(this);
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
