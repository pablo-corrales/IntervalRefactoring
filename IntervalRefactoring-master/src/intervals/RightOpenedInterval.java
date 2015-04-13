package intervals;

public class RightOpenedInterval extends Interval{
	
	
	public RightOpenedInterval(ExactPoint minimum, UntilPoint maximum) {
		super(minimum, maximum);
	
	}
			
	public boolean intersectsWith(Interval interval) {
		return (minimum.intersectsWith(interval.minimum)&&maximum.intersectsWith(interval.minimum))
				|| (minimum.intersectsWith(interval.maximum)&&maximum.intersectsWith(interval.maximum));
	}

			
}