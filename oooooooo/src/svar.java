import java.util.Scanner;
public class svar {
	//här ligger svaren på uppgifterna
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		System.out.println("fråga 1: "+methods.volumeToMassSolid(IRON, 0.08));//80 * 1/10^3
		
		System.out.println("fråga 2: "+methods.svtDistance(2.8, 60));
		
		
		System.out.println("fråga 3:"+ 
		enums.FluidTable.WATER.density*0.005*enums.FluidTable.WATER.heatCapacity+"/deltaT");
		
		System.out.println("fråga 4"+ methods.velocityToHeight(50)+1.8);
		
		
	}
}