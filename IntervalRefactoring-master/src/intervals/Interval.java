package intervals;

public abstract class Interval {

	protected Point minimum;
	protected Point maximum;
	
	
	public Interval(Point minimum, Point maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
				
	}

	public double midPoint() {
		return (maximum.getValue() + minimum.getValue()) / 2;
	}

	
		
	public boolean contained(LeftOpenedInterval leftOpenedInterval){
		return false;
	}
	public boolean contained(RightOpenedInterval rightOpenedInterval){
		return false;
	}
	
	public boolean contained(UnOpenedInterval interval) {
		return false;
	}

	public boolean containsMinimum(UnOpenedInterval unOpenedInterval) {
		return false;
	}
	
	public boolean containsMaximum(UnOpenedInterval unOpenedInterval) {
		return false;
	}
		
	public abstract boolean intersectsWith(Interval interval);
	
	public abstract boolean includes(Interval interval);
	
	 public boolean intersectsCommon(Interval interval) {	
		return ((minimum.includes(interval.minimum) && maximum.includes(interval.minimum))
			|| (minimum.includes(interval.maximum) && maximum.includes(interval.maximum)));
	  }
	
	public boolean includes(double value) {
		return (minimum.getValue() < value && value <= maximum.getValue());
	}
	
	@Override
	public String toString() {
		// TODO
		return null;
	}

	@Override
	public boolean equals(Object object) {
		// TODO
		return false;
	}

	

	
}
