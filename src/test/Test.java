package test;

import java.util.ArrayList;

import ratingBattle.TBattleSpot;
import ratingBattle.TPlayer;

public class Test {

	public static void main(String[] args) {
		test2();
	}

	private static void test1() {
		TPlayer player = new TPlayer();
		for (int i = 0; i < 20; i++){
			System.out.println(player.getForce());
		}

	}

	private static void test2() {
		int T = 60;
		int noOfPlayer = 5000;
		TBattleSpot b = new TBattleSpot(T, noOfPlayer);
		b.start();
		b.sort();
		ArrayList<TPlayer> result =  b.getPlayers();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getRecord().toString());
		}
	}

}
