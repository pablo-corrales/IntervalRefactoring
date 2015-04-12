package intervals;

public abstract class Interval {

	protected Point minimum;
	protected Point maximum;
	protected Opening opening;
	
	public Interval(Point minimum, Point maximum, Opening opening) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.opening = opening;
		
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
