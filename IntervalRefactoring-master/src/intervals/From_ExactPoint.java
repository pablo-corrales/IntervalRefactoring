package intervals;

public class From_ExactPoint extends ExactPoint{

	public From_ExactPoint(double number) {
		super(number);
		
	}
	
	@Override
	public boolean intersectsWith(Point point) {
			return point.contained(this);
	}
	
	public boolean includes(Point point){
			return point.included(this);
	}

}
