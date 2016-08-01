package leetcode;


/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * @author jinliang
 *
 */
public class P004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] merge = merge(nums1, nums2);
		int len = merge.length;
		
		if(len%2==0){
			return (merge[len/2-1]+merge[len/2])/2.0;
		}else{
			return merge[len/2];
		}
		
	}
	
	private int[] merge(int[] l1, int[] l2){
		//数组长度
		int len1 = l1.length;
		int len2 = l2.length;
		
		//指针
		int p1 = 0;
		int p2 = 0;
		int i = 0;
		
		//合并后的数组
		int[] ret = new int[len1+len2];
		
		for(;i<len1+len2;i++){
			
			if(p1>=len1||p2>=len2){
				break;
			}
			
			if(l1[p1]<l2[p2]){
				ret[i] = l1[p1++];
			}else{
				ret[i] = l2[p2++];
			}
		}
		
		while(p1<len1){
			ret[i++] = l1[p1++]; 
		}
		
		while(p2<len2){
			ret[i++] = l2[p2++]; 
		}
	
		return ret;
	}
}
