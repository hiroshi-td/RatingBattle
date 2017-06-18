package ratingBattle;

public class TRecord {

	/** 対戦数 */
	private int fNoOfBattles;
	/** 勝ち数 */
	private int fNoOfWins;
	/** 負け数 */
	private int fNoOfLoses;
	/** 引き分け数 */
	private int fNoOfDraws;
	/** レート値 */
	private int fRate;

	/** コンストラクタ */
	public TRecord() {
		fNoOfBattles = 0;
		fNoOfWins = 0;
		fNoOfLoses = 0;
		fNoOfDraws = 0;
		fRate = 1500;
	}

	/** 対戦数を1増やす */
	public void incBattles() {
		fNoOfBattles += 1;
	}

	/** 勝ち数を1増やす */
	public void incWins() {
		fNoOfWins += 1;
	}

	/** 負け数を1増やす */
	public void incLoses() {
		fNoOfLoses += 1;
	}

	/** 引き分け数を1増やす */
	public void incDrows() {
		fNoOfDraws += 1;
	}

	/** レート値を得る */
	public int getRate() {
		return fRate;
	}

	/**
	 * レート値をセットする
	 * @param rate
	 */
	public void setRate(int rate) {
		this.fRate = rate;
	}

	@Override
	public String toString() {
		String str = "===============\n";
		str += "レート: " + fRate + "\n";
		str += "対戦回数: " + fNoOfBattles + "\n";
		str += "勝利回数: " + fNoOfWins + "\n";
		str += "敗北回数: " + fNoOfLoses + "\n";
		str += "引分回数: " + fNoOfDraws + "\n";

		return str;
	}
}
