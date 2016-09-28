package dependencies;

import org.apache.commons.lang3.StringUtils;

/**
 * Klasa testowa dla zarz¹dzania zale¿noœciami i 
 * wpinania pluginów do cyklu budowania aplikacji
 * @author Slawek
 *
 */
public class NameVerifier {
	public static void main(String[] args) {
		String name = "Maciek";
		System.out.println(StringUtils.isAlpha(name));
	}
	
	/**
	 * Metoda dodaj¹ca dwie liczby ca³kowite
	 * @param a
	 * @param b
	 * @return suma parametrów a i b
	 */
	public int add(int a, int b) {
		return a+b;
	}
}
