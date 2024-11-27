/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);
	
		String remainStr2 = str2;
	
		for (int i = 0; i < str1.length(); i++) {
			char checkedLetter = str1.charAt(i);
	
			if (checkedLetter == ' ') {
				continue;
			}
	
			int checkedIndex = remainStr2.indexOf(checkedLetter);
			if (checkedIndex == -1) {
				return false;
			}
	
			remainStr2 = remainStr2.substring(0, checkedIndex) + remainStr2.substring(checkedIndex + 1);
		}
	
		for (int j = 0; j < remainStr2.length(); j++) {
			if (remainStr2.charAt(j) != ' ') {
				return false;
			}
		}
	
		return true;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		String newStr = "";
		String replaceChar = "><!@?.,-_";
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (replaceChar.indexOf(letter) != -1) {
				continue;
			} else {
				newStr = newStr + letter;
			}
		}

		return newStr;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String newStr = "";
		while (str.length() > 0) {
            int randomIndex = (int) (str.length() * Math.random());
            newStr += str.charAt(randomIndex);
            str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
        }

        return newStr;
	}
}
