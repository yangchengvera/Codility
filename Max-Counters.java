/*
Max-Counters

Task 1
Java 01:59:55
Task description
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.

The sequence should be returned as:

a structure Results (in C), or
a vector of integers (in C++), or
a record Results (in Pascal), or
an array of integers (in any other programming language).
For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Assume that:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
Complexity:

expected worst-case time complexity is O(N+M);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

Copyright 2009–2016 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
Custom test casesformat: (5, [3, 4, 4, 6, 1, 4, 4])	0/10	

This is quite hard for me to understand the best solution. What I can give is the O(M*N) performance which cannot meet the requirement.
But after line by line understanding, I imagine a scenario to help me understand the solution, which is about Raising Salary.

Assume the there is two operation: 
Raise personal salary
Raise the whole departments salary.

But raising whole department’s salary is too complicated, so only when you are the one who needs to be raised salary, they remember add the last time’s department salary bench to you.

There are two indicators need to be maintained: 
Current highest salary
Department salary bench


*/
class Solution {
    public int[] solution(int N, int A[]) {
      int[] counter = new int[N];
      int currenthighest = 0;
      int salarybench = 0;
      for(int i = 0; i < A.length; i++ ){
    	  // one person need to raise salary
    	  if(A[i]>1 && A[i]<N){
    		  // if this person's salary is lower than benth
    		  if(counter[A[i]-1] < salarybench)
    			  //raise his salary to bench
    			  {counter[A[i]-1] = salarybench;}
    		   	 // then add this time his salary
    		  counter[A[i]-1] += 1;
    		  //check his added salary is highest or not
    		  if(counter[A[i]-1] > currenthighest)
    			  //update the highest salary
    		  {currenthighest = counter[A[i]-1];}
    	  }
    	  // the department need to raise salary
    	  else{
    		  //only update the salary bench
    		  salarybench = currenthighest;
    	  }  	 
      } 
      // Someone wants to check the whole departments salary
      for(int j = 0; j < N; j++){
    	  // if there's person salary is lower than bench then raise it to bench
    	  if(counter[j] < salarybench)
    		  counter[j] = salarybench;
      }
      return counter;
    }