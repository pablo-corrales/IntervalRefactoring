package intervals;

public class BothOpenedInterval extends Interval{
	
	
	public BothOpenedInterval(Point minimum, Point maximum, Opening opening) {
		super(minimum, maximum, opening);
	
	}
	
	@Override
	public boolean includes(double value) {		
		 return minimum.getValue() < value && value < maximum.getValue();			
	}
	
	@Override
	public boolean includes(Point value) {		
			return minimum.getValue() < value.getValue() && value.getValue()< maximum.getValue();			
	}
	
	@Override
	public boolean includes(Interval interval) {
	
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);
		
		switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded);
			case RIGHT_OPENED:
				return (minimumIncluded)
					&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded) && (maximumIncluded);
			default:
				assert false;
			return false;
		}
	}
	
	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
				return false;
		}
		
		if (maximum == interval.minimum) {
			return false;	
		}
		return this.includes(interval.minimum)
				|| this.includes(interval.maximum);
	}

		
	
}
