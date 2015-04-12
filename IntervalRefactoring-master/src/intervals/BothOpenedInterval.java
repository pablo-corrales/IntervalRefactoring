package intervals;

public class BothOpenedInterval extends Interval{
	
	
	public BothOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum);
	
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
		return interval.included(this);
	}
	
	@Override
	public boolean included(BothOpenedInterval interval) {
			return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue())
					&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
		}
	
	@Override
	public boolean included(LeftOpenedInterval interval) {
		return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue())
					&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
		}
	
	@Override
	public boolean included(RightOpenedInterval interval) {
		return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue())
					&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
	}
	

	@Override
	public boolean included(UnOpenedInterval interval) {
			return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue())
					&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
	}
	
	public boolean intersectsWith(Interval interval) {
		if (minimum.getValue() == interval.maximum.getValue()) {
				return false;
		}
		
		if (maximum.getValue() == interval.minimum.getValue()) {
			return false;	
		}
		return this.includes(interval.minimum.getValue())
				|| this.includes(interval.maximum.getValue());
	}

		
	
}
