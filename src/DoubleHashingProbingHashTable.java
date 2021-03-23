public class DoubleHashingProbingHashTable<T> extends ProbingHashTable<T> {

	/*
	 * Denna metod ska skrivas klart. Den ska använda bokens förslag på andra
	 * hashalgoritm: f(i) = i * hash2(x), där hash2(x) = R - (x mod R) och R är ett
	 * primtal mindre än tabellstorleken.
	 */
	@Override
	protected int findPos(T x) {
		int hash1 = myhash(x);
		int hash2 = hash2(x);
		while (continueProbing(hash1, x)) {
			hash1 = (hash1 + hash2) % capacity();
 			if (hash1 >= capacity()) {
				hash1 -= capacity();
			}
		}
		return hash1;	
	}

	private int hash2(T x) {
		return smallerPrimeThanCapacity() - (x.hashCode() % smallerPrimeThanCapacity());
	}

	/*
	 * Denna metod ger ett primtal mindre än tabellens storlek. Detta primtal ska
	 * användas i metoden ovan.
	 */
	protected int smallerPrimeThanCapacity() {
		int n = capacity() - 2;
		while (!isPrime(n)) {
			n -= 2;
		}
		return n;
	}

}