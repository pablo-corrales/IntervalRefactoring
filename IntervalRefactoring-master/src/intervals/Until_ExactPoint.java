package intervals;

public class Until_ExactPoint extends ExactPoint{

	public Until_ExactPoint(double number, TypePoint typePoint) {
		super(number, typePoint);
		
	}
	
	@Override
	public boolean intersectsWith(Point point) {
			return point.contained(this);
	}

}
