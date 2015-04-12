package intervals;

public class ExactPoint extends Point{
	
	public ExactPoint(double value) {
		super(value);
	};
	
	@Override
	public boolean included(FromPoint fromPoint) {
		return fromPoint.getValue() <= this.getValue();
	}
	
	@Override
	public boolean included(UntilPoint untilPoint) {
			return this.getValue() <= untilPoint.getValue();
	}

}
