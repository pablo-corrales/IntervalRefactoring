package intervals;

public class BothOpenedInterval extends Interval{
	
	
	public BothOpenedInterval(FromPoint minimum, UntilPoint maximum) {
		super(minimum, maximum);
	
	}
	
	@Override
	public boolean includes(double value) {		
		 return minimum.getValue() < value && value < maximum.getValue();			
	}
	
	public boolean includes(Interval interval) {
		return minimum.includes(interval.minimum) && minimum.includes(interval.maximum) &&
 				maximum.includes(interval.minimum) && maximum.includes(interval.maximum);
	}
	
		
	@Override
	public boolean included(UnOpenedInterval interval) {
		return includedCommon(interval);
	}
	
	public boolean intersectsWith(Interval interval) {
		if (minimum.getValue() == interval.maximum.getValue()) {
				return false;
		}
		
		if (maximum.getValue() == interval.minimum.getValue()) {
			return false;	
		}
		
		return intersectsCommon(interval);
	}
	
	
}
