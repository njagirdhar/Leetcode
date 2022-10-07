// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class ArrayDuplicates {
    
    /*
    * Time complexity : O(n^2)
    * Space complexity : O(1)
    * Approach :- Go through the array by comparing each & every element
    */
    public static int findDuplicates(int[] A) {
        int result =0;
        for(int i=0;i<A.length;i++) {
            for(int j = i+1; j<A.length; j++) {
                if(A[i]==A[j]){
                    result = A[i];
                    return result;
                }
            }
        }
        return result;
    }
    
    /*
    * Time complexity : O(n log n)
    * Space complexity : O(n)
    * Approach : Sort the given Array & then compare with next element in the Array if found  
    *            return the Array element.
    ***/
    public static int findDuplicate(int[] A) {
        int result =0;
        Arrays.sort(A);
        for(int i=0;i<A.length-2;i++) {
            if(A[i] == A[i+1]) {
                return A[i];
            }
        }
        return 0;
    }
    
    /*
    * Time Complexity : O(n)
    * Space Complexity : O(n)
    * Approach : insert all the elements in Array into HashMap along with the no. of values 
    *            repeated , then iterate over the hashmap & find the key which has value
    *            greater than 1;
    */
    public static int findDuplicatess(int[] A) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            if(map.containsKey(A[i])){
                int count = 1 + map.get(A[i]);
                map.put(A[i], count);
            }else{
                map.put(A[i],1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                return entry.getKey();
            }
        }   
        return 0;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,1,2};
        System.out.println(findDuplicates(A));
        System.out.println(findDuplicate(A));
        System.out.println(findDuplicatess(A));
    }
}
