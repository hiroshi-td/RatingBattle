package ratingBattle;
import java.util.Comparator;

public class TCompataror implements Comparator<TPlayer>{

	@Override
	public int compare(TPlayer p1, TPlayer p2) {
		int sgn = 0;
		if (p1.getRecord().getRate() < p2.getRecord().getRate()) {
			sgn = 1;
		} else if (p2.getRecord().getRate() < p1.getRecord().getRate()) {
			sgn = -1;
		}
		return sgn;
	}
}
