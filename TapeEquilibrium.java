//TapeEquilibrium 100%

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int k;
        int N = A.length;
        int left = A[0];
        int right = 0;           //use left&right only O(n) as the time 						//complexity
        int min;
        for(k=1;k<N;k++){
            right = right +A[k];
        }
        min = left - right;
        if (min<0)
        min = - min;
        for(k=1;k<N-1;k++)       // 		k< N-1 !!!! NOT K<N					     //THINK ABOUT the boundary situation when k== N-1
        {	left = left+A[k];
        	right = right - A[k];
            int dif = left - right;
            if(dif<0) dif = -dif;
            if(dif<min) min = dif;
        }
        return min;
    }
}