package genAssign;

import java.util.Arrays;

/*Following all problem statements solve using generics 

(do not use collection framework- upload it on GitHub and share specific file link on chat)
 

3)Find Minimum and Maximum from array

Explanation -> from array return Min and Max value
 */
public class MinMax {

	public static <T> void find(T arr[]) {
		Arrays.sort(arr);
		System.out.println("Minimum value :" +arr[0]);
		System.out.println("Maximum value :" +arr[arr.length-1]);
	
	}
	public static void main(String[] args) {
		Integer arr[]= {10,20,30,40,50,60,25};
		MinMax.find(arr);
		}
}
