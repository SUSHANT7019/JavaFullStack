package genAssign;
/*Following all problem statements solve using generics 

(do not use collection framework- upload it on GitHub and share specific file link on chat)
 

2)Liner Search

Explanation -> Given a generic array and target element ,return its index , if not found return -1
 
3)Find Minimum and Maximum from array

Explanation -> from array return Min and Max value
 */
public class Liner {

	public static <T> int liner(T [] arr, T target){
		int index =-1;
		for(T t : arr)
		{
			index++;
			if(t.equals(target)) {
				return index;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Integer arr[]= {10,20,30,40};
		if(liner(arr,10)!=-1)
		{
			System.out.println("Element present at index "+liner(arr,10));
		}
		else {
			System.out.println("Element not present");
		}
	}
}
