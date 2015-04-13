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
	public boolean intersectsWith(Point point) {
		return point.contained(this);
	}
	
	@Override
	public boolean contained(ExactPoint point) {
			if( point.getTypePoint().equals(TypePoint.MAXIMUM))
				return point.getValue() >= this.getValue();
			else
				return point.getValue() <= this.getValue();
	 }
	
	@Override
	public boolean included(FromPoint fromPoint) {
		return fromPoint.getValue() < this.getValue();
	}
	
	@Override
	public boolean included(UntilPoint untilPoint) {
			return this.getValue() < untilPoint.getValue();
	}
	
	
	@Override
	public String toString(){
			if( this.getTypePoint().equals(TypePoint.MAXIMUM))
				return this.getValue() + "]";
			else
				return this.getValue() + "[";
	}
	
}
