package intervals;

public class UnOpenedInterval extends Interval{
	
	
	public UnOpenedInterval(Point minimum, Point maximum, Opening opening) {
		super(minimum, maximum, opening);
	
	}
		
	@Override
	public boolean includes(double value) {
		
		return minimum.getValue() <= value && value <= maximum.getValue();

	}
	
	@Override	
	public boolean includes(Point value) {
		
			return minimum.getValue() <= value.getValue() && value.getValue() <= maximum.getValue();
	
	}
	
	
	@Override
	public boolean includes(Interval interval) {
	
		boolean minimumIncluded = this.includes(interval.minimum.getValue());
		boolean maximumIncluded = this.includes(interval.maximum.getValue());
		
		
		switch (interval.opening) {
		case BOTH_OPENED:
			return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
		case LEFT_OPENED:
			return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
		case RIGHT_OPENED:
			return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
		case UNOPENED:
			return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
		default:
			assert false;
			return false;
		}
	}
	
	public boolean intersectsWith(Interval interval) {
		if (minimum.getValue() == interval.maximum.getValue()) {
			return interval.opening == Opening.LEFT_OPENED ||
					interval.opening == Opening.UNOPENED;
		}
		
		if (maximum.getValue() == interval.minimum.getValue()) {
			return interval.opening == Opening.RIGHT_OPENED ||
					interval.opening == Opening.UNOPENED;	
		}
		return this.includes(interval.minimum.getValue())
				|| this.includes(interval.maximum.getValue());
	}
	

}