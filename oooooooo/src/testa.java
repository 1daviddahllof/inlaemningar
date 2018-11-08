import java.util.Scanner;
public class testa {


	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		
		System.out.println("fahrenheitToCelsius(double fahrenheit)");
		
		System.out.println(methods.fahrenheitToCelsius(scn.nextDouble()));
			
		System.out.println("kelvinToCelsius(double kelvin)");
			
		System.out.println(methods.kelvinToCelsius(scn.nextDouble()));
		
		scn.nextLine();
		System.out.println("fluidPressure(line fluid + double meters)");
		System.out.println(methods.fluidPressure(enums.FluidTable.contains(scn.nextLine()), scn.nextDouble()));
		
		System.out.println("pressureUnderWater(double meters)");
		System.out.println(methods.pressureUnderWater(scn.nextDouble()));
		
		System.out.println("kineticEnergy (double mass + double velocity)");
		System.out.println(methods.kineticEnergy(scn.nextDouble(),scn.nextDouble()));
		
		System.out.println("potentialEnergy(double mass + double height)");
		System.out.println(methods.potentialEnergy(scn.nextDouble(), scn.nextDouble()));
		
		System.out.println("fallSpeed(double height)");
		System.out.println(methods.fallSpeed(scn.nextDouble()));

		System.out.println("delta(double first + double last)");
		System.out.println(methods.delta(scn.nextDouble(), scn.nextDouble()));
		
		scn.nextLine();
		System.out.println("volumeToMassFluid(line fluid + double volume)");
		System.out.println(methods.volumeToMassFluid(enums.FluidTable.contains(scn.nextLine()), scn.nextDouble()));
		
		scn.nextLine();
		System.out.println("volumeToMassGas(line gas + double volume)");
		System.out.println(methods.volumeToMassGas(enums.GasTable.contains(scn.nextLine()), scn.nextDouble()));
		
		scn.nextLine();
		System.out.println("volumeToMassSolid(line solid + double volume)");
		System.out.println(methods.volumeToMassSolid(enums.SolidTable.contains(scn.nextLine()), scn.nextDouble()));
		
		System.out.println("svtVelocity(double distance + double time)");
		System.out.println(methods.svtVelocity(scn.nextDouble(), scn.nextDouble()));

		System.out.println("svtDistance(double velocity + double time)");
		System.out.println(methods.svtDistance(scn.nextDouble(), scn.nextDouble()));

		System.out.println("svtTime(double distance + double velocity)");
		System.out.println(methods.svtTime(scn.nextDouble(), scn.nextDouble()));
		
		System.out.println("work(double force + double distance)");
		System.out.println(methods.work(scn.nextDouble(), scn.nextDouble()));
		
		System.out.println("power(double work + double time)");
		System.out.println(methods.power(scn.nextDouble(), scn.nextDouble()));
		
		scn.nextLine();
		System.out.println("heatEnergy(line solid + double mass, double deltaT)");
		System.out.println(methods.heatEnergy(enums.SolidTable.contains(scn.nextLine()), scn.nextDouble(), scn.nextDouble()));
		
		scn.nextLine();
		System.out.println("heatEnergy(line fluid + double mass, double deltaT)");
		System.out.println(methods.heatEnergy2(enums.FluidTable.contains(scn.nextLine()), scn.nextDouble(), scn.nextDouble()));
		
		scn.nextLine();
		System.out.println("heatEnergy(line gas + double mass, double deltaT)");
		System.out.println(methods.heatEnergy3(enums.GasTable.contains(scn.nextLine()), scn.nextDouble(), scn.nextDouble()));
		
		System.out.println("velocityToHeight(double velocity)");
		System.out.println(methods.velocityToHeight(scn.nextDouble()));
		
		System.out.println("Jag orkar inte skriva mer");
		scn.close();
	}
}