package leetcode;

/*
 * ACCEPTED
 */
public class P003_2 {
	/*
	 * 主方法
	 */
	public static void main(String[] args){
		P003_2 p = new P003_2();
		String s = "abcb";
		int max = 
				p.lengthOfLongestSubstring(s);
		System.out.println(max);
	}
	
	// 寻找最长不重复子串的长度
	public int lengthOfLongestSubstring(String s){
		
		int[] nextIndexs = createNexts(s);
		int max_length = 0;
		int len = s.length();
		
		for(int i=0;i<len;i++){
			int length = longestStartWithThis(nextIndexs, i);
			if(length>max_length){
				max_length = length;
			}
		}
		
		return max_length;
	}
	
	
	
	/*
	 * 改良版：
	 * 1. 生成每个元素的下一个重复出现位置的索引，对于没有
	 * 重复出现的元素，令其索引为数组长度。
	 * 2. 遍历数组，寻找每个元素的最大长度
	 */
	
	//生成索引
	private int[] createNexts(String s){
		int len = s.length();
		int[] nextIndexs = new int[len];

		for(int i=0;i<len;i++){
			char ch = s.charAt(i);
			
			int k = i+1;
			for(;k<len;k++){
				if(s.charAt(k)==ch){
					break;
				}
			}
			
			nextIndexs[i] = k;
		}
		return nextIndexs;
	}
	
	//固定第一个元素，确定由该元素开头的最长不重复子串长度
	private int longestStartWithThis(int[] nextIndexs, int index){
		int begin = index;
		int end = nextIndexs[begin];
		int length = 0;
		for(int i=begin;i<end;i++){
			length++;
			if(nextIndexs[i]<end){
				end = nextIndexs[i];
			}
		}
		return length;
	}
	
}
