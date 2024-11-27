// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 == 0) {
			return x1;
		}
		if (x1 == 0) {
			return x2;
		}

		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
			return x1;
		}
		if (x2 < 0) {
			for (int i = 0; i < -x2; i++) {
				x1--;
			}
			return x1;
		}

		return x1;

	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your cod
		if (x2 == 0) {
			return x1;
		}

		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
			return x1;
		}

		if (x2 < 0) {
			for (int i = 0; i < -x2; i++) {
				x1++;
			}
			return x1;
		}

		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int finalNumber = 0;
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		if (x1 == 1) {
			return x2;
		}
		if (x2 == 1) {
			return x1;
		}
		boolean toNegative = false;
		if (x1 < 0 && x2 > 0) {
			x1 = minus(0, x1);
			toNegative = true;
		} else if (x1 < 0 && x2 > 0) {
			x2 = minus(0, x2);
			toNegative = true;
		}
		if (x1 < 0 && x2 < 0) {
			x1 = minus(0, x1);
			x2 = minus(0, x2);
		}
		for (int i = 0; i < x1; i++) {
			finalNumber = plus(finalNumber, x2);
		}
		if (toNegative) {
			return minus(0, finalNumber);
		}
		return finalNumber;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		if (x == 1 || n == 1) {
			return x;
		}

		if (n < 0) {
			return 0;
		}
		int result = 1;
		for (int i = 0; i < n; i++) {
			result = times(result, x);
		}

		return result;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		// Doesnt support x2 == 0
		if (x1 == 0) {
			return 0;
		}
		if (x2 == 1) {
			return x1;
		}

		boolean toNegative = false;
		if (x1 < 0 && x2 > 0) {
			x1 = minus(0, x1);
			toNegative = true;
		} else if (x1 > 0 && x2 < 0) {
			x2 = minus(0, x2);
			toNegative = true;
		} else if (x1 < 0 && x2 < 0) {
			x1 = minus(0, x1);
			x2 = minus(0, x2);
		}
		int c = 0;
		int remainder = x1;
		while (remainder >= x2) {
			remainder = minus(remainder, x2);
			c++;
		}

		if (toNegative) {
			return minus(0, c);
		}
		return c;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		// Doesnt support numbers lower then 0

		if (x1 == 0) {
			return 0;
		}

		if (x1 < 0) {
			x1 = minus(0, x1);
		}

		if (x2 < 0) {
			x2 = minus(0, x2);
		}
		while (x1 >= x2) {
			x1 = minus(x1, x2);
		}
		return x1;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) { 
		// Replace the following statement with your code
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		} else {
			int result = 0;
			for (int i = 1; i <= div(x, 2); i++) {
				int square = times(i, i);
				if (square == x) {
					return i;
				}
				if (square > x) {
					return result;
				}
				result = i;
			}

			return result;
		}
	}
}