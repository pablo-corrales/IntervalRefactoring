package intervals;

public class UnOpenedInterval extends Interval{
	
	
	public UnOpenedInterval(ExactPoint minimum, ExactPoint maximum) {
		super(minimum, maximum);
	
	}
		
			
	public boolean intersectsWith(Interval interval) {
		if (minimum.getValue() == interval.maximum.getValue()) {
			return interval.containsMinimum(this);
		}
		
		if (maximum.getValue() == interval.minimum.getValue()) {
			return interval.containsMaximum(this);
		}
		
		return intersectsCommon(interval);
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