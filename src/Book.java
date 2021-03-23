/*
 * Denna klass ska förberedas för att kunna användas som nyckel i en hashtabell. 
 * Du får göra nödvändiga ändringar även i klasserna MyString och ISBN10.
 * 
 * Hashkoden ska räknas ut på ett effektivt sätt och följa de regler och 
 * rekommendationer som finns för hur en hashkod ska konstrueras. Notera i en 
 * kommentar i koden hur du har tänkt när du konstruerat din hashkod.
 */
public class Book {
	private MyString title;
	private MyString author;
	private ISBN10 isbn;
	private MyString content;
	private int price;

	public Book(String title, String author, String isbn, String content, int price) {
		this.title = new MyString(title);
		this.author = new MyString(author);
		this.isbn = new ISBN10(isbn);
		this.content = new MyString(content);
		this.price = price;
	}

	public MyString getTitle() {
		return title;
	}

	public MyString getAuthor() {
		return author;
	}

	public ISBN10 getIsbn() {
		return isbn;
	}

	public MyString getContent() {
		return content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		Book other = (Book)obj;
		return title.equals(other.title) && author.equals(other.author) && isbn.equals(other.isbn);
	}
	
	/*
	 * Tankegången vid konstruktionen av hashkoden har utgått ifrån att anropet av metoden på ett objekt ska generera samma
	 * hashkod varje gång om det sker flera gånger under exekveringen och att två objekt som anses lika enligt equals()-metoden 
	 * alltid ska generera samma haskod. Slutligen har jag försökt undvika så många kollisioner som möjligt, 
	 * 
	 * Undvikandet av kollisioner har skett genom användning av primtal. Primtal är bra vid konstruktion av hashkoder eftersom
	 * de är bättre på att undvika kollisioner än icke-primtal. Varför jag använde just 31 och 17 och inte några andra primtal kan jag inte
	 * svara på, utan beslutet baserades på att de två verkar vara vanliga och passar tydligen bra ihop.
	 * 
	 * För att uppfylla de två första kraven jag nämnde har jag anropat hashCode()-metoden på title, author och ISBN vilka i sin tur använder
	 * den inbyggda Arrays.hashcode()-metoden. Källkoden för den metoden visar att tankesättet är densamma som jag har haft och följer
	 * Joshua Blochs rekommendationer i boken Effective Java där varje element behandlas som ett separat fält och beräknar hashkoden för varje 
	 * element med hjälp av primtalet 31. Jag försökte använda så många attribut som möjligt för att öka spridningen, men priset definierar 
	 * inte böckerna och strängen content, som jag antar är hela bokens innehåll, blir extremt lång och jag anser att det förmodligen inte
	 * är värt det.
	 *  
	*/
	
	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + ((title == null) ? 0 : title.hashCode());
		result = result * 31 + ((author == null) ? 0 : author.hashCode());
		result = result * 31 + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String.format("\"%s\" by %s Price: %d ISBN: %s lenght: %s", title, author, price, isbn,
				content.length());
	}

}
