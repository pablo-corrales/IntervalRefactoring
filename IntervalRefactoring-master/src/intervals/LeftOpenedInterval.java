package intervals;

	
	public class LeftOpenedInterval extends Interval{
		
		
		public LeftOpenedInterval(FromPoint minimum, ExactPoint maximum) {
			super(minimum, maximum);
		
		}
		
			
		public boolean intersectsWith(Interval interval) {
			return (minimum.intersectsWith(interval.minimum)&&maximum.intersectsWith(interval.minimum))
					|| (minimum.intersectsWith(interval.maximum)&&maximum.intersectsWith(interval.maximum));
		}

				
}


