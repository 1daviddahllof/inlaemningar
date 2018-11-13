import java.util.Scanner;
public class svar {
	//h�r ligger svaren p� uppgifterna
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		System.out.println("fr�ga 1: "+methods.volumeToMassSolid(enums.SolidTable.IRON, 0.08));//80 * 1/10^3
		
		System.out.println("fr�ga 2: "+methods.svtDistance(2.8, 60));
		
		
		System.out.println("fr�ga 3: "+ 
		enums.FluidTable.WATER.density*0.005*enums.FluidTable.WATER.heatCapacity+"/deltaT");
		
		System.out.println("fr�ga 4: "+methods.pressureUnderWater(100));
		
		System.out.println("fr�ga 5: "+ methods.velocityToHeight(50)+1.8);
		
		double energy = methods.kineticEnergy(740, 100/3.6);//jag antar att 100 �r i k/h
		System.out.println("fr�ga 6: "+methods.power(energy, 4.4));
		
		double y = 10; //ingen metod h�r
		int count = 0;
		while(y>0.5) {
			y=y*0.99;
			count+=1;
		}
		System.out.println("fr�ga 7: "+count);
		
		
	}
}