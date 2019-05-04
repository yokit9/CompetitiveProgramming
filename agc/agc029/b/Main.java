package b;

import static java.lang.System.*;
import java.util.*;

class Num {
	int num;
	int count;
	
	Num(int _num, int _count) {
		num = _num;
		count = _count;
	}
	
	public String toString() {
		return num + " " + count;
	}
}

public class Main {
	public static int getMSB(int n) {
		n = (n & 0xffff0000) > 0 ? n & 0xffff0000 : n;
		n = (n & 0xff00ff00) > 0 ? n & 0xff00ff00 : n;
		n = (n & 0xf0f0f0f0) > 0 ? n & 0xf0f0f0f0 : n;
		n = (n & 0xcccccccc) > 0 ? n & 0xcccccccc : n;
		n = (n & 0xaaaaaaaa) > 0 ? n & 0xaaaaaaaa : n;
		
		return n;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		
		ArrayList<Num> nums = new ArrayList<Num>();
		nums.add(new Num(a[n-1], 0));
		for(int i=n-1; i>=0; i--) {
			Num last = nums.get(nums.size()-1);
			if(last.num == a[i]) 
				last.count = last.count+1;
			else 
				nums.add(new Num(a[i], 1));
		}
		//out.println(nums);
		
		int ans = 0;
		for(int i = 0; i<nums.size(); i++) {
			Num num = nums.get(i);
			if(num.count <= 0) continue;
			num.count--;
			
			int pair = (getMSB(num.num) << 1) - num.num;
			
			int p = i, q = nums.size()-1;
			int mid = q;
			while(p < q) {
				Num mNum = nums.get(mid);
				if(mNum.num == pair) {
					if(mNum.count > 0) {
						ans++;
						mNum.count--;
					}
					break;
				}
				else if(mNum.num > pair) p = mid;
				else q = mid;
				mid = (p+q)/2;
			}
			//out.println("[" + num + "] " + mid + " " + nums + " " + ans);
		}
		
        out.println(ans);
    }
}


