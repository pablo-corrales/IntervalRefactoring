package intervals;

public class BothOpenedInterval extends Interval{
	
	
	public BothOpenedInterval(FromPoint minimum, UntilPoint maximum) {
		super(minimum, maximum);
	
	}
	public boolean includes(double value) {
		return (minimum.getValue() < value && value <= maximum.getValue());
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
