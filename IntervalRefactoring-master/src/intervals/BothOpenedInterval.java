package intervals;

public class BothOpenedInterval extends Interval{
	
	
	public BothOpenedInterval(FromPoint minimum, UntilPoint maximum) {
		super(minimum, maximum);
	
	}
	public boolean includes(double value) {
		return (minimum.getValue() < value && value <= maximum.getValue());
	}
		
	public boolean intersectsWith(Interval interval) {
		return (minimum.intersectsWith(interval.minimum)&&maximum.intersectsWith(interval.minimum))
				|| (minimum.intersectsWith(interval.maximum)&&maximum.intersectsWith(interval.maximum));
		
		
	}
	
	
}
