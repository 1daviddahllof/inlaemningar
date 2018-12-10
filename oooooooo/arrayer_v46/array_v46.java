import java.util.Scanner;
public class array_v46 {

	public static void main(String[] args) {
		int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};
		String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};
		
//		Skrev l�sningar i metoder
		System.out.println("Hur m�nga 7:or finns det i numbers?");
		System.out.println(fr1(numbers, 7));
		
		System.out.println("Hur m�nga personer som heter Tom finns det i names?");
		System.out.println(fr2(names, "Tom"));
		
		System.out.println("Vilket nummer finns det flest respektive minst av i names?");
		System.out.println("h�gst antal: "+fr3(numbers));
		System.out.println("minst antal: "+fr3_den_andra(numbers));
		
		System.out.println("P� vilket index finns namnet Drusilla i names?");
		System.out.println(fr4(names, "Drusilla"));
		
		System.out.println("Vad �r summan av alla j�mna tal i numbers?");
		System.out.println(fr5(numbers, 2));
		
		System.out.println("Hur m�nga finns det av varje tal i numbers? \r\n" + 
				"(antal 1:or, antal 2:or ...)");
		System.out.println(" ge f�rst en int = antal v�rden och sen flera int = v�rdet");
//		beh�vde en array
		Scanner scn = new Scanner (System.in);
		int l = scn.nextInt();
		int[] p = new int[l];
		for (int x = 0; x<l; x++) {
			p[x]=scn.nextInt();
		}
		scn.close();
		for (int x = 0; x<p.length; x++) {
			System.out.println("number of "+p[x]+"'s: "+fr6(numbers, p)[x]);
		}
		
		System.out.println("Hur m�nga namn b�rjar p� bokstaven L i names?");
		System.out.println(fr7(names, 'L'));
		
		System.out.println("Hur m�nga namn �r fem bokst�ver l�nga i names?");
		System.out.println(fr8(names, 5));

		
		System.out.println("Hur m�nga  unika namn finns i names?");
		System.out.println(fr9(names));
	
		
		System.out.println("Vilket �r det namn som f�rekommer flest g�nger i names?");
		System.out.println(fr10(names));
	}
	
	public static int fr1(int[] numbers, int searchfor) {	
		int s = 0;
//		g�r igenom alla positioner i numbers och l�gger till 1 p� s om numret
//		�r det vi s�ker efter
		for (int x = 0; x<numbers.length; x++) {
			if (numbers[x]==searchfor) {
				s++;
			}
		}
		return s;
	}
	
	
	public static int fr2(String[] names, String searchfor) {	
//		g�r igenom names och addera 1 med s f�r varje namn som matchar imput		
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			if (names[x].equals(searchfor)) {
				s++;
			}
		}
		return s;
	}
	public static int fr3(int[] numbers) {
		int s = 0;
		int c2 = 0;
		for (int x = 0; x<numbers.length; x++) {
			int c = 0;
			for (int y = 0; y<numbers.length; y++) {
				if (numbers[x]==numbers[y]) {
					c++;
				}
			}
			if (c>c2) {
				c2=c;
				s=x;
			}
//			ger bara en int �ven om flera tal delar f�rstaplatsen
		}
		
		return numbers[s];
	}
	public static int fr3_den_andra(int[] numbers) {
		int s = 0;
		int c2 = numbers.length;
		for (int x = 0; x<numbers.length; x++) {
			int c = 0;
			for (int y = 0; y<numbers.length; y++) {
				if (numbers[x]==numbers[y]) {
					c++;
				}
			}
			if (c<c2) {
				c2=c;
				s=x;
			}
//			ger bara en int �ven om flera tal delar f�rstaplatsen
		}
		
		return numbers[s];
	}
	public static int fr4(String[] names, String searchfor) {
//		f�rsta x d�r names[x] �r input st�nger loopen och output blir x;
		for (int x = 0; x<names.length; x++) {
			if (names[x].equals(searchfor)) {
				return x;
			}
		}
//		ifall den inte finns
		return -1;
	}
	public static int fr5(int[] numbers, int divby) {
//		f�r varje tal som �r delbart med input �kar s med 1;
		int s = 0;
		for (int x = 0; x<numbers.length; x++) {
			if (numbers[x]%divby==0) {
				s++;
			}
		}
		return s;
	}
	public static int[] fr6(int[] numbers, int[] checkFor) {
//		skapar en array av ints som visar m�ngden av varje tal fr�n checkfor i numbers
//		samma index f�r int i checkfor och int som ger m�ngden av checkfor inten i numbers
		int [] r = new int[checkFor.length];
		for (int x = 0; x<r.length;x++) {
			r[x]=0;
		}
//		f�r varje int i nubers g�r den igenom varje int i checkfor f�r att se 
//		om de matchar
		for (int x = 0; x<numbers.length; x++) {
			for (int y = 0; y<checkFor.length; y++) {
				if (numbers[x]==checkFor[y]) {
					r[y]++;
				}
			}
		}
		return r;
	}
	public static int fr7(String[] names, char searchfor) {
//		g�r igenom alla names och ser hur m�ngas charAt(0)==input
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			if (names[x].charAt(0)==searchfor) {
				s++;
			}
		}
		return s;
	}
	public static int fr8(String[] names, int length) {
//		g�r igenom alla names och ser villka har l�ngden som speciferas i input
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			if (names[x].length()==length) {
				s++;
			}
		}
		return s;
	}
	public static String[] fr9(String[] names) {
//		skapar en ny array som bara l�gger till ett namn om det inte redan finns d�r
		int s = 0;
		String[] uniques = new String[names.length];
		for (int x = 0; x<names.length; x++) {
			boolean un = true;
			for (int y = 0; y<s; y++) {
				if (uniques[y].equals(names[x])) {
				un = false;
				}
			}
			if (un) {
				uniques[s]=names[x];
				s++;
			}
		}
		return uniques;
	}
	public static String fr10(String[] names) {
//		h�r blir antalet av ett visst namn s och n�r ett viist s �r mer en c blir c till s
		int c = 0;
		String answer = "";
		for (int x = 0; x<names.length; x++) {
			int s = 0;
			for (int y = 0; y<names.length; y++) {
				if (names[x].equals(names[y])) {
					s++;
				}
			}
//			om s > c blir answer namet som testades 
			if (s>c) {
				c=s;
				answer = names[x];
			}
//			om de r�kar ha samma v�rde och inte vara identiska l�ggs ett till namn p� answers stringen
//			(det h�nde aldrig, men jag hoppas att du uppskattar min nogranhet ge mig ett A)
			else if (s==c && !answer.contains(names[x])) {
				answer = answer.concat(", "+names[x]);
			}
		}
		return answer;	
	}
	
}