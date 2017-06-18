package ratingBattle;

import java.util.Random;

public class TPlayer {

	/** 戦績 */
	private TRecord fRecord;
	/** 戦闘力の平均 */
	private double fMean;
	/** 戦闘力の分散 */
	private double fSigma;
	/** 乱数 */
	private Random fRandom;

	/** デフォルトコンストラクタ */
	public TPlayer() {
		fRecord = new TRecord();
		fMean = 0.0;
		fSigma = 50.0;
		fRandom = new Random();
	}

	/**
	 * コンストラクタ
	 * @param mean
	 * @param sigma
	 */
	public TPlayer(double mean, double sigma) {
		fRecord = new TRecord();
		fMean = mean;
		fSigma = sigma;
	}

	/**
	 * 戦闘力を返す
	 * @return 戦闘力
	 */
	public double getForce() {
		return fSigma*fRandom.nextGaussian() + fMean;
	}

	/**
	 * 戦績を返す
	 * @return 戦績
	 */
	public TRecord getRecord() {
		return fRecord;
	}

}
