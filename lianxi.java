/*
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。

示例：
输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 
提示：
2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
*/

package demo3;

public class lianxi{
	public static void main(String[] args) {
		Solution S = new Solution();
		int[] A = new int[] { 4, 5, 2, 7};
		int[] a = S.sortArrayByParityII(A);
		for(int i : a) {
			System.out.print(i + " ");
		}

	}
}

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int len = A.length - 1;
        while( true){
            if(A[i] % 2 == i % 2 ){//判断是否同时为偶数
                i += 2;            //每次加2，保证i每次都在偶数位。
            }else{
            	//否则，交换下标为 i 和 len的数字位置，因为i一直是偶数，
            	//要是两者模2不相等，说明A[i]为奇数，所以将它换到奇数位
                int temp = A[i];
                A[i] = A[len];
                A[len] = temp;
                len -= 2;
            }
            if(len < 1) {//判断len是否越界
            	break;
            }
            if(A[len] % 2 ==  len % 2 ){//判断是否同时为奇数
                len -= 2;              //每次加2，保证i每次都在奇数位。
            }else{
            	//否则，交换下标为 i 和 len的数字位置，因为len 一直是奇数，
            	//要是两者模2不相等，说明A[len]为偶数，所以将它换到偶数位
            	int temp = A[len];
                A[len] = A[i];
                A[i] = temp;
                i += 2;
            }
            if(i > A.length - 1) {
            	break;//判断i是否越界
            }
            
        }
        return A;
    }
}

