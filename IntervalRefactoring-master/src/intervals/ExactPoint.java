package intervals;

public abstract class ExactPoint extends Point{
	private TypePoint typePoint;
	
	public ExactPoint(double number, TypePoint typePoint) {
 		super(number);
		this.typePoint = typePoint;
	}
	
	protected TypePoint getTypePoint() {
		return typePoint;
	}

	public abstract boolean includes(Point p);
	
	public abstract boolean intersectsWith(Point point);
	
	public boolean contained(From_ExactPoint point) {
			return point.getValue() <= this.getValue();
	}
	
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
	
	
	@Override
	public String toString(){
			if( this.getTypePoint().equals(TypePoint.MAXIMUM))
				return this.getValue() + "]";
			else
				return this.getValue() + "[";
	}
	
}
