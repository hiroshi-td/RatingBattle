package ratingBattle;

import java.util.ArrayList;

public class TMain {

	public static void main(String[] args) {
		// 対戦数(最大反復数)
		int T = 45;
		// プレイヤー数
		int noOfPlayer = 35210;
		TBattleSpot bs = new TBattleSpot(T, noOfPlayer);
		bs.start();
		bs.sort();
		ArrayList<TPlayer> result =  bs.getPlayers();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getRecord().toString());
		}
	}

}
