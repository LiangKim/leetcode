package leetcode;

/**
 * 数字翻转
 * @author jinliang
 *
 */
public class P007 {
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
