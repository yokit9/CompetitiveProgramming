package a;

import static java.lang.System.*;
import java.util.*;

class Cost {
	int x, y, c;
	
	Cost(int _x, int _y, int _c) {
		x = _x;
		y = _y;
		c = _c;
	}
}

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] map = new char[h][w];
		LinkedList<Cost> open = new LinkedList<Cost>();
		
		for(int i=0; i<h; i++) {
			map[i] = sc.next().toCharArray();
			
			for(int j=0; j<w; j++) {
				if(map[i][j] == '#') open.add(new Cost(j, i, 0));
			}
        }
		
		int ans = 0;
		while(!open.isEmpty()) {
			Cost now = open.poll();
			ans = Math.max(ans, now.c);
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nc = now.c + 1;
				
				if(nx < 0 || w <= nx || ny < 0 || h <= ny) continue;
				if(map[ny][nx] == '#') continue;
				
				map[ny][nx] = '#';
				open.add(new Cost(nx, ny, nc));
			}
		}
		
        out.println(ans);
    }
}

