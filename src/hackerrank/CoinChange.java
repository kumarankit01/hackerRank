package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int amount = s.nextInt();
		int M = s.nextInt();
		int coins[] = new int[M];
		for(int i=0;i<M;i++){
			coins[i] =  s.nextInt();
		}
		s.close();
		Arrays.sort(coins);
		calculateCoins(coins,amount);
	}

	private static void calculateCoins(int[] coins, int amount) {
		int noOfCoins = coins.length;
		long [][]t = new long[noOfCoins][amount+1];
		for (int i = 0; i < noOfCoins; i++) {
			t[i][0] = 1;
		}
		for (int i = 0; i < amount+1; i++) {
			if(i%coins[0] == 0)
				t[0][i] = 1;
			else
				t[0][i] = 0;

		}
		for (int i = 1; i < noOfCoins; i++) {
			for (int j = 1; j < amount+1; j++) {
				long totalCoin = t[i-1][j];
				if(j-coins[i] >= 0){
					totalCoin += t[i][j-coins[i]];
				}
				t[i][j] = totalCoin;
			}
		}
		System.out.println(t[noOfCoins-1][amount]);
	}

}
