package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
				switch(opening){
				case BOTH_OPENED: return getBothOpenedInterval(new FromPoint(minimum), new UntilPoint(maximum));
				case LEFT_OPENED: return getLeftOpenedInterval(new FromPoint(minimum), new ExactPoint(maximum, TypePoint.MAXIMUM));
				case RIGHT_OPENED: return getRigthOpenedInterval(new ExactPoint(minimum, TypePoint.MINIMUM), new UntilPoint(maximum));
				case UNOPENED: return getUnOpenedInterval(new ExactPoint(minimum, TypePoint.MINIMUM), new ExactPoint(maximum, TypePoint.MAXIMUM));
				default: return null;
			}
	}
	
	public static Interval getBothOpenedInterval(FromPoint minimum, UntilPoint maximum) {
				return new Interval(minimum, maximum);
	}
	
	public static Interval getLeftOpenedInterval(FromPoint minimum, ExactPoint maximum) {
		return new Interval(minimum, maximum);
	}
	
	public static Interval getRigthOpenedInterval(ExactPoint minimum, UntilPoint maximum) {
		return new Interval(minimum, maximum);
	}
	
	public static Interval getUnOpenedInterval(ExactPoint minimum, ExactPoint maximum) {
		return new Interval(minimum, maximum);
	}
}
