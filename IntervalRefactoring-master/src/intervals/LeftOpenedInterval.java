package intervals;

	
	public class LeftOpenedInterval extends Interval{
		
		
		public LeftOpenedInterval(Point minimum, Point maximum) {
			super(minimum, maximum);
		
		}
		
		@Override
		public boolean includes(double value) {			
			return minimum.getValue() < value && value <= maximum.getValue();	
		}
		
		@Override		
		public boolean includes(Point value) {	
				return minimum.getValue() < value.getValue() && value.getValue()<= maximum.getValue();		
		}
		
		@Override
		public boolean includes(Interval interval) {
			return interval.included(this);
		}
		
				
		private boolean includedMinimum(Interval interval){
			return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue());
		}
		@Override
		public boolean included(BothOpenedInterval interval) {
			return (includedMinimum(interval) && (interval.includes(maximum.getValue())));
		}
				
		@Override
		public boolean included(LeftOpenedInterval interval) {
				return (includedMinimum(interval))
						&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
		}
		
		@Override
		public boolean included(RightOpenedInterval interval) {
				return (includedMinimum(interval)) && (interval.includes(maximum.getValue()));
		}
		
		@Override
		public boolean included(UnOpenedInterval interval) {
				return (includedMinimum(interval))
						&& (interval.includes(maximum.getValue()) || maximum.getValue() == interval.maximum.getValue());
		}
		
		public boolean intersectsWith(Interval interval) {
			if (minimum.getValue() == interval.maximum.getValue()) 
					return false;
			
			
			if (maximum.getValue() == interval.minimum.getValue())
				return interval.contained(this); 
			
			
			return intersectsCommon(interval);
		}

		@Override
		public boolean contained(RightOpenedInterval rightOpenedInterval) {			
			return true;
		}
		
		
		@Override
		public boolean containsMinimum(UnOpenedInterval unOpenedinterval){
				return true;
		}
		
		
		
}


