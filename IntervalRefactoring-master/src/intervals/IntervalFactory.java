package intervals;


public class IntervalFactory {

	
	public static Interval getBothOpenedInterval(Point minimum, Point maximum, Opening opening) {
				return new BothOpenedInterval(minimum, maximum, opening);
	}
	
	public static Interval getLeftOpenedInterval(Point minimum, Point maximum, Opening opening) {
		return new BothOpenedInterval(minimum, maximum, opening);
	}
	
	public static Interval getRigthOpenedInterval(Point minimum, Point maximum, Opening opening) {
		return new BothOpenedInterval(minimum, maximum, opening);
	}
	
	public static Interval getUnOpenedInterval(Point minimum, Point maximum, Opening opening) {
		return new BothOpenedInterval(minimum, maximum, opening);
	}
}
