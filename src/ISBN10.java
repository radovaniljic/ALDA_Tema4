import java.util.Arrays;

public class ISBN10 {

	private char[] isbn;

	public ISBN10(String isbn) {
		if (isbn.length() != 10)
			throw new IllegalArgumentException("Wrong length, must be 10");
		if (!checkDigit(isbn))
			throw new IllegalArgumentException("Not a valid isbn 10");
		this.isbn = isbn.toCharArray();
	}

	private boolean checkDigit(String isbn) {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
		}
		int checkDigit = (11 - (sum % 11)) % 11;

		return isbn.endsWith(checkDigit == 10 ? "X" : "" + checkDigit);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ISBN10 other = (ISBN10) obj;
		return Arrays.equals(isbn, other.isbn);
	}
	
	//Se Book-klassen för motivation
	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + Arrays.hashCode(isbn);
		return result;
	}
	
	@Override
	public String toString() {
		return new String(isbn);
	}
}
