package intervals;

public class UnOpenedInterval extends Interval{
	
	
	public UnOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum);
	
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
		return interval.included(this);
	}
	
	@Override
	public boolean included(BothOpenedInterval interval) {
			return (interval.includes(minimum.getValue())) && (interval.includes(maximum));
	}
	
	@Override
	public boolean included(LeftOpenedInterval interval) {
			return (interval.includes(minimum.getValue()))
					&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
	}
	
	@Override
		public boolean included(RightOpenedInterval interval) {
			return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue())
					&& (interval.includes(maximum.getValue()));
	}
	
	@Override
		public boolean included(UnOpenedInterval interval) {
			return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue())
					&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
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
	
	@Override
	public boolean contained(RightOpenedInterval rightOpenedInterval) {			
		return true;
	}
	
	@Override
	public boolean contained(LeftOpenedInterval leftOpenedInterval) {			
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