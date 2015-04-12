package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
				switch(opening){
				case BOTH_OPENED: return getBothOpenedInterval(new Point(minimum), new Point(maximum));
				case LEFT_OPENED: return getLeftOpenedInterval(new Point(minimum), new Point(maximum));
				case RIGHT_OPENED: return getRigthOpenedInterval(new Point(minimum), new Point(maximum));
				case UNOPENED: return getUnOpenedInterval(new Point(minimum), new Point(maximum));
				default: return null;
			}
	}
	
	public static Interval getBothOpenedInterval(Point minimum, Point maximum) {
				return new BothOpenedInterval(minimum, maximum);
	}
	
	public static Interval getLeftOpenedInterval(Point minimum, Point maximum) {
		return new LeftOpenedInterval(minimum, maximum);
	}
	
	public static Interval getRigthOpenedInterval(Point minimum, Point maximum) {
		return new RightOpenedInterval(minimum, maximum);
	}
	
	public static Interval getUnOpenedInterval(Point minimum, Point maximum) {
		return new UnOpenedInterval(minimum, maximum);
	}
}
