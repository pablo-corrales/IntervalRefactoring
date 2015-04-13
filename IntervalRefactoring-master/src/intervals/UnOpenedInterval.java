package intervals;

public class UnOpenedInterval extends Interval{
	
	
	public UnOpenedInterval(ExactPoint minimum, ExactPoint maximum) {
		super(minimum, maximum);
	
	}
		
			
	public boolean intersectsWith(Interval interval) {
		return (minimum.intersectsWith(interval.minimum)&&maximum.intersectsWith(interval.minimum))
				|| (minimum.intersectsWith(interval.maximum)&&maximum.intersectsWith(interval.maximum));
	}
	
	public boolean includes(double value) {
		return (minimum.getValue() < value && value <= maximum.getValue());
	}
	
	
	@Override
	public boolean contained(RightOpenedInterval rightOpenedInterval) {			
		return true;
	}
	
		
	@Override
	public boolean containsMinimum(UnOpenedInterval unOpenedInterval) {
		return true;
	}
	
	@Override
	public boolean containsMaximum(UnOpenedInterval unOpenedInterval) {
		return true;
	}
	

}