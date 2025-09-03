import java.io.*;
import java.util.*;

public class Main {

	private static int[][] map;
	private static int count;

	private static final int[][] DIRECTIONS = {
		{0, 1},
		{0, -1},
		{-1, 0},
		{1, 0},
		{-1, -1},
		{-1, 1},
		{1, -1},
		{1, 1},
	};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String[] s = br.readLine().split(" ");
			int w = Integer.parseInt(s[0]);
			int h = Integer.parseInt(s[1]);

			if(w==0 && h==0){
				return;
			}

			map = new int[h][w];
			count = 0;

			for(int i=0; i<h; i++){
				s = br.readLine().split(" ");
				for(int j=0; j<w; j++){
					map[i][j] = Integer.parseInt(s[j]);
				}
			}

			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					if(map[i][j]==1){
						count++;
						map[i][j] = 0;
						dfs(i,j, h, w);
					}
				}
			}

			System.out.println(count);
		}
	}

	private static boolean inRange(int newX, int newY, int maxX, int maxY){
		return newX >=0 && newX < maxX && newY >= 0 && newY <maxY;
	}

	private static void dfs(int x, int y, int maxX, int maxY){
		map[x][y] = 0;

		for(int i=0; i<DIRECTIONS.length; i++){
			int newX = x + DIRECTIONS[i][0];
			int newY = y + DIRECTIONS[i][1];

			if(inRange(newX, newY, maxX, maxY) && map[newX][newY]==1){
				map[newX][newY] = 0;
				dfs(newX, newY, maxX, maxY);
			}
		}
	}
}