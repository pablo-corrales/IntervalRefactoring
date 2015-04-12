package intervals;

	
	public class LeftOpenedInterval extends Interval{
		
		
		public LeftOpenedInterval(FromPoint minimum, ExactPoint maximum) {
			super(minimum, maximum);
		
		}
		
		@Override
		public boolean includes(double value) {			
			return minimum.getValue() < value && value <= maximum.getValue();	
		}
		
		@Override
		public boolean includes(Interval interval) {
			return minimum.includes(interval.minimum) && minimum.includes(interval.maximum) && 
	 				maximum.includes(interval.minimum) && maximum.includes(interval.maximum);
		}
		
				
		private boolean includedMinimum(Interval interval){
			return (interval.includes(minimum.getValue()) || minimum.getValue() == interval.minimum.getValue());
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


