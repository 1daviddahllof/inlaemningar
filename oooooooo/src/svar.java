import java.util.Scanner;
public class svar {
	//h�r ligger svaren p� uppgifterna
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		System.out.println("fr�ga 1: "+methods.volumeToMassSolid(IRON, 0.08));//80 * 1/10^3
		
		System.out.println("fr�ga 2: "+methods.svtDistance(2.8, 60));
		
		
		System.out.println("fr�ga 3:"+ 
		enums.FluidTable.WATER.density*0.005*enums.FluidTable.WATER.heatCapacity+"/deltaT");
		
		System.out.println("fr�ga 4"+ methods.velocityToHeight(50)+1.8);
		
		
	}
}