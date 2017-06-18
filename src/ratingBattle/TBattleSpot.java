package ratingBattle;

import java.util.ArrayList;
import java.util.Collections;

public class TBattleSpot {

	/** 最大世代数 */
	private int fT;
	/** 世代数 */
	private int fG;
	/** プレイヤー数 */
	private int fNoOfPlayer;
	/** プレイヤーリスト */
	private ArrayList<TPlayer> fPlayers;

	/**
	 * コンストラクタ
	 * @param T
	 * @param noOfPlayer
	 */
	public TBattleSpot(int T, int noOfPlayer) {
		fT = T;
		fG = 0;
		fNoOfPlayer = noOfPlayer;
		fPlayers = new ArrayList<TPlayer>(noOfPlayer);
		for (int i = 0; i < noOfPlayer; i++) {
			fPlayers.add(new TPlayer());
		}
	}

	/**
	 * 対戦を行う
	 * @param player1
	 * @param player2
	 */
	public void battle(TPlayer player1, TPlayer player2) {
		player1.getRecord().incBattles();
		player2.getRecord().incBattles();
		double force1 = player1.getForce();
		double force2 = player2.getForce();
		if (force1 < force2) {
			// player2 win and player1 lose
			player2.getRecord().incWins();
			player1.getRecord().incLoses();
			int deltaWinRate = 16 + (int) ((player1.getRecord().getRate() - player2.getRecord().getRate())*0.04);
			int winRate = player2.getRecord().getRate() + deltaWinRate;
			int deltaLoseRate = 16 + (int) ((player1.getRecord().getRate() - player2.getRecord().getRate())*0.04);
			int loseRate = player1.getRecord().getRate() - deltaLoseRate;
			player2.getRecord().setRate(winRate);
			player1.getRecord().setRate(loseRate);
		} else if (force2 < force1) {
			// player1 win and player2 lose
			player1.getRecord().incWins();
			player2.getRecord().incLoses();
			int deltaWinRate = 16 + (int) ((player2.getRecord().getRate() - player1.getRecord().getRate()) * 0.04);
			int winRate = player1.getRecord().getRate() + deltaWinRate;
			int deltaLoseRate = 16 + (int) ((player2.getRecord().getRate() - player1.getRecord().getRate()) * 0.04);
			int loseRate = player2.getRecord().getRate() - deltaLoseRate;
			player1.getRecord().setRate(winRate);
			player2.getRecord().setRate(loseRate);
		} else {
			// draw
			player1.getRecord().incDrows();
			player2.getRecord().incDrows();
		}
	}

	/**
	 * 1世代進める
	 */
	public void doOneIteration() {
		Collections.shuffle(fPlayers);
		for (int i = 0; i < fPlayers.size(); i += 2) {
			battle(fPlayers.get(i), fPlayers.get(i+1));
			fG++ ;
		}
	}

	/**
	 * 1試行行う
	 */
	public void start() {
		for (int i = 0; i < fT; i++) {
			doOneIteration();
		}
	}

	/**
	 * Battle spot内のリストをレート順で降順ソートする．
	 */
	public void sort() {
		TCompataror c = new TCompataror();
		Collections.sort(fPlayers, c);
	}

	/**
	 * プレイヤーリストを返す
	 * @return プレイヤーリスト
	 */
	public ArrayList<TPlayer> getPlayers() {
		return fPlayers;
	}

	/**
	 * 現在の世代数を返す
	 * @return 世代数
	 */
	public int getG() {
		return fG;
	}

	/**
	 * プレイヤー数を返す
	 * @return プレイヤー数
	 */
	public int getNoOfPlayer() {
		return fNoOfPlayer;
	}
}
