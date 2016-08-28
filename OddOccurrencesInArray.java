//OddOccurrencesInArray

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        for(int i=0;i<A.length;i++)
            result = result^A[i];
        return result;
    }
}