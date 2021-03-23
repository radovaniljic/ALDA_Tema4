import java.util.Arrays;

public class MyString {

	private char[] data;
	
	public MyString(String title) {
		data = title.toCharArray();
	}

	public Object length() {
		return data.length;
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
		MyString other = (MyString) obj;
		return Arrays.equals(data, other.data);
	}
	
	//Se Book-klassen för motivation
	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + Arrays.hashCode(data);
		return result;
	}
	
	@Override
	public String toString() {
		return new String(data);
	}
	
}
