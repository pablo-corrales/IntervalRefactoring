package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
				switch(opening){
				case BOTH_OPENED: return getBothOpenedInterval(new Point(minimum), new Point(maximum), opening);
				case LEFT_OPENED: return getLeftOpenedInterval(new Point(minimum), new Point(maximum), opening);
				case RIGHT_OPENED: return getRigthOpenedInterval(new Point(minimum), new Point(maximum), opening);
				case UNOPENED: return getUnOpenedInterval(new Point(minimum), new Point(maximum), opening);
				default: return null;
			}
	}
	
	public static Interval getBothOpenedInterval(Point minimum, Point maximum, Opening opening) {
				return new BothOpenedInterval(minimum, maximum, opening);
	}
	
	public static Interval getLeftOpenedInterval(Point minimum, Point maximum, Opening opening) {
		return new LeftOpenedInterval(minimum, maximum, opening);
	}
	
	public static Interval getRigthOpenedInterval(Point minimum, Point maximum, Opening opening) {
		return new RigthOpenedInterval(minimum, maximum, opening);
	}
	
	public static Interval getUnOpenedInterval(Point minimum, Point maximum, Opening opening) {
		return new UnOpenedInterval(minimum, maximum, opening);
	}
}
