import java.util.Scanner;
public class array_v46 {

	public static void main(String[] args) {
		int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};
		String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};
		
		System.out.println("Hur många 7:or finns det i numbers?");
		System.out.println(fr1(numbers));
		
		System.out.println("Hur många personer som heter Tom finns det i names?");
		System.out.println(fr2(names));
		
		System.out.println("På vilket index finns namnet Drusilla i names?");
		System.out.println(fr3(names));
		
		System.out.println("Vad är summan av alla jämna tal i numbers?");
		System.out.println(fr4(numbers));
		
		System.out.println("Hur många finns det av varje tal i numbers? \r\n" + 
				"(antal 1:or, antal 2:or ...)");
//		behövde en array
		Scanner scn = new Scanner (System.in);
		int l = scn.nextInt();
		int[] p = new int[l];
		for (int x = 0; x<l; x++) {
			p[x]=scn.nextInt();
		}
		scn.close();
		for (int x = 0; x<p.length; x++) {
			System.out.println("number of "+p[x]+"'s: "+fr5(numbers, p)[x]);
		}
		
		
		
		System.out.println("Hur många namn börjar på bokstaven L i names?");
		System.out.println(fr6(names));
		
		System.out.println("Hur många namn är fem bokstäver långa i names?");
		System.out.println(fr7(names));

		
		System.out.println("Hur många  unika namn finns i names?");
		System.out.println(fr8(names));
		
		
		System.out.println("Vilket är det namn som förekommer flest gånger i names?");
		System.out.println(fr9(names));
	}
	public static int fr1(int[] numbers) {	
		int s = 0;
		for (int x = 0; x<numbers.length; x++) {
			if (numbers[x]==7) {
				s++;
			}
		}
		return s;
	}
	
	
	public static int fr2(String[] names) {	
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			if (names[x].equals("Tom")) {
				s++;
			}
		}
		return s;
	}
	
	public static int fr3(String[] names) {
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			if (names[x].equals("Drusilla")) {
				s=x;
				break;
			}
		}
		return s;
	}
	public static int fr4(int[] numbers) {
		int s = 0;
		for (int x = 0; x<numbers.length; x++) {
			if (numbers[x]%2==0) {
				s++;
			}
		}
		return s;
	}
	public static int[] fr5(int[] numbers, int[] checkFor) {
		int s = 0;
		int [] r = new int[checkFor.length];
		for (int x = 0; x<r.length;x++) {
			r[x]=0;
		}
		for (int x = 0; x<numbers.length; x++) {
			for (int y = 0; y<checkFor.length; y++) {
				if (numbers[x]==checkFor[y]) {
					r[y]++;
				}
			}
		}
		return r;
	}
	public static int fr6(String[] names) {
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			if (names[x].charAt(0)=='L') {
				s++;
			}
		}
		return s;
	}
	public static int fr7(String[] names) {
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			if (names[x].length()==5) {
				s++;
			}
		}
		return s;
	}
	public static int fr8(String[] names) {
		int s = 0;
		
		for (int x = 0; x<names.length; x++) {
			boolean unique = true;
			for (int y = 0; y<names.length; y++) {
				if (x==y) {}
				else if (names[x].equals(names[y])) {
					unique = false;
				}
			}
			if (unique) {
				s++;
			}
		}
		return s;
	}
	public static String fr9(String[] names) {
		int s = 0;
		for (int x = 0; x<names.length; x++) {
			boolean unique = true;
			for (int y = 0; y<names[x].length(); y++) {
				if (x==y) {}
				else if (names[x].equals(names[y])) {
					unique = false;
				}
			}
			if (unique) {
				s++;
			}
		}
		int[] special = new int[s];
		for (int x = 0; x<special.length;x++) {
			special[x]=0;
		}
		int c = 0;
		int pos = 0;
		String answer = "";
		for (int x = 0; x<names.length; x++) {
			s = 0;
			for (int y = 0; y<names.length; y++) {
				if (names[x].equals(names[y])) {
					s++;
				}
			}
			if (s>c) {
				c=s;
				answer = names[x];
				
			}
			else if (s==c && !answer.contains(names[x])) {
				answer = answer.concat(", "+names[x]);
			}
		}
		return answer;	
//		ger inte flera namn om förstaplatsen är delad, för att jag orkar inte
	}
	
}