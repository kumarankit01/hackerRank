package week.of.code;

import java.util.Scanner;

public class Twins {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();		
		int m = s.nextInt();
		s.close();
		int count = 0;
		for(int i = n; i <= m-2;i++){
			int root = (int) Math.sqrt(i+2);
			boolean isPrime = true;
			if(i%2 == 0){
				isPrime = false;
			}else{
				for(int j = 3;j <= root; j=j+2){
					if( i%j == 0 || (i+2) % j == 0){
						isPrime = false;
						break;
					}
				}
			}
			if(isPrime){
				count++;
				i++;
			}
		}
		System.out.println(count);

	}

}
