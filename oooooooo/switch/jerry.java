

import java.util.Scanner;

public class jerry {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to movie inspiration database! Please choose a genre!");
		System.out.println("(-1) - 2");
		System.out.println("(1) - Thriller");
		System.out.println("(2) - Comedy");
		System.out.println("(3) - Romance");
		System.out.println("(4) - Fantasy");
		System.out.println("(5) - Quit");
		System.out.println();

		

		String genre;
		eee:
		while (true) {
			int s2 = 1;
			int choice = input.nextInt();
			switch (choice) {
			case -1:
				System.out.println("(1) - go back");
				System.out.println("(2) - continue");
				System.out.println("(3) - add m");
				System.out.println("(4) - add k");
				System.out.println("(5) - gives number of 2's");
				System.out.println("(6) - squeeses");
				int s = 0;
				int multiply = 0;
				int squeee = 1;
				loopsy:
				while (true) {
					int choice2 = input.nextInt();
					switch (choice2) {
					case 1:
						break loopsy;
					case 2:
						s2 = s2 + multiply; 
						for (int x2 = 0; x2<s2; x2++) {
							System.out.print(2);
							s++;
						}
						System.out.println();
						break;
					case 3:
						System.out.println("type an integer");
						s2+= input.nextInt()/squeee;
						System.out.println("thank you");
						break;
					case 4:
						System.out.println("type an integer");
						multiply = input.nextInt();
						System.out.println("thank you");
						break;
					case 5:
						System.out.println(s);
						break;
					case 6:
						System.out.println("type an integer");
						squeee = input.nextInt();
						multiply/=squeee;
						s2/=squeee;
						System.out.println("thank you");
						break;
					default:
						System.out.println("you did it wrong");
						break;
					}
				}
				break;
			case 1:
				genre = "Thriller";
				System.out.println("You chose " + genre + "! Here are three good movies!");
				System.out.println();
				System.out.println("1. A quit place, av John Krasinski");
				System.out.println("2. The dark night, av Christopher Nolan");
				System.out.println("3. The silence of the lamb, av Jonathan Demme");
				System.out.println();
				break;
			case 2:
				genre = "Comedy";
				System.out.println("You chose " + genre + "! Here are three good movies!");
				System.out.println();
				System.out.println("1. Deadpool 2, av David Leitch");
				System.out.println("2. Dum och dummare, av Peter Farelly");
				System.out.println("3. Bridesmaid, av Paul Feig");
				System.out.println();
				break;
			case 3:
				genre = "Romance";
				System.out.println("You chose " + genre + "! Here are three good movies!");
				System.out.println();
				System.out.println("1. The notebook, av Nick Cassavetes");
				System.out.println("2. The holidays, av Nancy Meyrs");
				System.out.println("3. Love Simon, av Greg Berlanti");
				System.out.println();
				break;
			case 4:
				genre = "Fantasy";
				System.out.println("You chose " + genre + "! Here are three good movies!");
				System.out.println();
				System.out.println("1. Lord of the rings - Sagan om ringen, av Peter Jackson");
				System.out.println("2. Aquaman, av James Wan");
				System.out.println("3. Avengers - Infinity war, av Anthony & Joe Russo");
				System.out.println();
				break;
			case 5:
				System.out.println("Thank you for today!");
				break eee;
			default:
				genre = "invalid";
				System.out.println("You have made a " + genre + " choice! Too bad for you!");
				System.out.println();
				System.out.println("The options are:");
				System.out.println("(1) - Thriller");
				System.out.println("(2) - Comedy");
				System.out.println("(3) - Romance");
				System.out.println("(4) - Fantasy");
				System.out.println("(5) - Quit");
				System.out.println("you idiot");
				System.out.println();

			}
		}
		input.close();
	}

}