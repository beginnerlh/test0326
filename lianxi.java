/*
 * ����һ���Ǹ��������� A�� A ��һ��������������һ��������ż����
��������������Ա㵱 A[i] Ϊ����ʱ��i Ҳ���������� A[i] Ϊż��ʱ�� i Ҳ��ż����
����Է����κ���������������������Ϊ�𰸡�

ʾ����
���룺[4,2,5,7]
�����[4,5,2,7]
���ͣ�[4,7,2,5]��[2,5,4,7]��[2,7,4,5] Ҳ�ᱻ���ܡ�
 
��ʾ��
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
            if(A[i] % 2 == i % 2 ){//�ж��Ƿ�ͬʱΪż��
                i += 2;            //ÿ�μ�2����֤iÿ�ζ���ż��λ��
            }else{
            	//���򣬽����±�Ϊ i �� len������λ�ã���Ϊiһֱ��ż����
            	//Ҫ������ģ2����ȣ�˵��A[i]Ϊ���������Խ�����������λ
                int temp = A[i];
                A[i] = A[len];
                A[len] = temp;
                len -= 2;
            }
            if(len < 1) {//�ж�len�Ƿ�Խ��
            	break;
            }
            if(A[len] % 2 ==  len % 2 ){//�ж��Ƿ�ͬʱΪ����
                len -= 2;              //ÿ�μ�2����֤iÿ�ζ�������λ��
            }else{
            	//���򣬽����±�Ϊ i �� len������λ�ã���Ϊlen һֱ��������
            	//Ҫ������ģ2����ȣ�˵��A[len]Ϊż�������Խ�������ż��λ
            	int temp = A[len];
                A[len] = A[i];
                A[i] = temp;
                i += 2;
            }
            if(i > A.length - 1) {
            	break;//�ж�i�Ƿ�Խ��
            }
            
        }
        return A;
    }
}

