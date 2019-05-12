package packageTest;

public class Functions {
	public static void main() {
		double a = 7.0;
		double b = 5.0;
		System.out.println(CompareOrder(a, b));
		
	}
	public static boolean CompareOrder(double a, double b){
		if (b >= a ) return true;
		else
			return false;
	}

}
