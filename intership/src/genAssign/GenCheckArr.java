package genAssign;

public class GenCheckArr {
	
	public static <T> boolean check(T []arr ,int f ,int s) {
		int F=0,S=0;
		for(T t:arr) {
			if((int)t==f) {
				F=1;
			}
			if((int)t==s) {
				S=1;
			}	
		}
		 
		return S==1&&F==1;
	}
	public static void main(String[] args) {
		Integer arr[]= {10,20,30,40,50};
		if(GenCheckArr.check(arr, 10, 1)) {
			System.out.println("Both are Present");
		}
		else {
			System.out.println("Both are Not Present");
		}
	}
}
