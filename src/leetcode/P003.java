package leetcode;

/**
 * Given a string, find the length of the longest 
 * substring without repeating characters.
 * @author jinliang
 *
 */
public class P003 {
	
	public static void main(String[] args){
		P003 p = new P003();
		int len = p.lengthOfLongestSubstring("abcabcbb");
		System.out.println(len);
	}
	
	public int lengthOfLongestSubstring(String s) {
		int longest = 0;
		
		for(int i=0;i<(s.length()-longest);i++){
			Stack stack = new Stack();
			for(int k=i;k<s.length();k++){
				char ch = s.charAt(k);
				if(stack.canPush(ch)){
					stack.push(ch);
				}else{
					break;
				}
			}
			
			if(stack.length>longest){
				longest = stack.length;
			}
		}
		
		return longest;
	}
	
	/*
	 * 定制的栈
	 */
	class Stack{
		int length = 0;
		int size = 20;
		char[] arr = new char[size];
		
		//测试字母是否能够被压入栈中
		boolean canPush(char ch){
			boolean flag = true;
			
			for(int i=0;i<length;i++){
				if(ch==arr[i]){
					flag = false;
					break;
				}
			}
			
			return flag;
		}
		
		//压入字母
		void push(char ch){
			if(length>=size){	//容量已满
				resize();
			}
			
			arr[length++] = ch;
		}
		
		//扩展存储区
		void resize(){
			//创建新的存储区域
			char[] new_arr = new char[size*2];
			//复制数组
			copyArray(arr, new_arr);
			//重定向指针
			arr = new_arr;
			size*=2;
		}
		
		
		//复制数组
		void copyArray(char[] sor, char[] tar){
			int sor_length = sor.length;
			int tar_length = tar.length;
			
			for(int i=0;i<sor_length&&i<tar_length;i++){
				tar[i] = sor[i];
			}
		}
	}
	
	
}
