package leetcode;

/**
 * 判断某数是否为回文，先翻转，看两者是否相等
 * 
 * @author jinliang
 *
 */
public class P009 {

	public boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		int rx = reverse(x);
		return rx==x;
	}
	
	
	public int reverse(int x) {
		boolean flag = x<0;
		if(flag){
			x = -x;
		}
		
		int ret = 0;
		while(x>0){
			ret = ret*10 + x%10;
			
			if(ret>Integer.MAX_VALUE/10&&x>10){
				return 0;
			}
			
			x = x/10;
		}
		
		if(flag){
			ret = -ret;
		}
		
		return ret;
	}

}
