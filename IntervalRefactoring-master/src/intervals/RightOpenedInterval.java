package intervals;

public class RightOpenedInterval extends Interval{
	
	
	public RightOpenedInterval(ExactPoint minimum, UntilPoint maximum) {
		super(minimum, maximum);
	
	}
		
	
	@Override
	public boolean includes(double value) {
		
		return minimum.getValue() <= value && value < maximum.getValue();

	}
	
	@Override
	public boolean includes(Interval interval) {
		return minimum.includes(interval.minimum) && minimum.includes(interval.maximum) &&
				maximum.includes(interval.minimum) && maximum.includes(interval.maximum);
	}
	
	public boolean intersectsWith(Interval interval) {
		if (minimum.getValue() == interval.maximum.getValue()) {
			return interval.contained(this);
		}
		
		if (maximum.getValue() == interval.minimum.getValue()) {
			return false;	
		}
		return this.includes(interval.minimum.getValue())
				|| this.includes(interval.maximum.getValue());
		}

	
		private boolean includedMaximum(Interval interval){
			return (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
		}


		@Override
		public boolean included(UnOpenedInterval interval) {
			return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue())
					&& (this.includedMaximum(interval));
		}
	
		@Override
		public boolean contained(LeftOpenedInterval leftOpenedInterval) {			
			return true;
		}
		
		@Override
		public boolean containsMaximum(UnOpenedInterval unOpenedinterval){
				return true;
		}

}