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

	public abstract boolean includes(double point);
	public abstract boolean includes(Point point);
	public abstract boolean includes(Interval interval);
	public abstract boolean intersectsWith(Interval interval);
	
	public abstract boolean included(BothOpenedInterval interval);
	public abstract boolean included(LeftOpenedInterval interval);
	public abstract boolean included(RightOpenedInterval interval);
	public abstract boolean included(UnOpenedInterval interval);
	
	
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
	
	public boolean includedCommon(Interval interval) {	
		return true;
	}
	
	
	public boolean intersectsCommon(Interval interval) {
		return this.includes(interval.minimum.getValue())
			|| this.includes(interval.maximum.getValue());
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
