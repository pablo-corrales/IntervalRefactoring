package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
				switch(opening){
				case BOTH_OPENED: return getBothOpenedInterval(new FromPoint(minimum), new UntilPoint(maximum));
				case LEFT_OPENED: return getLeftOpenedInterval(new FromPoint(minimum), new Until_ExactPoint(maximum, TypePoint.MAXIMUM));
				case RIGHT_OPENED: return getRigthOpenedInterval(new From_ExactPoint(minimum, TypePoint.MINIMUM), new UntilPoint(maximum));
				case UNOPENED: return getUnOpenedInterval(new From_ExactPoint(minimum, TypePoint.MINIMUM), new Until_ExactPoint(maximum, TypePoint.MAXIMUM));
				default: return null;
			}
	}
	
	public static Interval getBothOpenedInterval(FromPoint minimum, UntilPoint maximum) {
				return new Interval(minimum, maximum);
	}
	
	public static Interval getLeftOpenedInterval(FromPoint minimum, Until_ExactPoint maximum) {
		return new Interval(minimum, maximum);
	}
	
	public static Interval getRigthOpenedInterval(From_ExactPoint minimum, UntilPoint maximum) {
		return new Interval(minimum, maximum);
	}
	
	public static Interval getUnOpenedInterval(From_ExactPoint minimum, Until_ExactPoint maximum) {
		return new Interval(minimum, maximum);
	}
}
