package intervals;

public class RightOpenedInterval extends Interval{
	
	
	public RightOpenedInterval(ExactPoint minimum, UntilPoint maximum) {
		super(minimum, maximum);
	
	}
		
	
		
	public boolean intersectsWith(Interval interval) {
		if (minimum.getValue() == interval.maximum.getValue()) {
			return interval.contained(this);
		}
		
		if (maximum.getValue() == interval.minimum.getValue()) {
			return false;	
		}
		
		return intersectsCommon(interval);
	}

	public boolean includes(double value) {
		return (minimum.getValue() < value && value <= maximum.getValue());
	}
	
		
	@Override
	public boolean containsMaximum(UnOpenedInterval unOpenedinterval){
				return true;
	}

}