
public class methods{
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32)/1.8;
	}
	public static double kelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}
	public static double fluidPressure(enums.FluidTable fluid, double deep) {
		return deep*fluid.density+constants.ATM; 
	}
	public static double pressureUnderWater(double deep) {
		return deep*enums.FluidTable.WATER.density+constants.ATM;
	}
	public static double kineticEnergy(double mass, double velocity) {
		return mass*velocity;
	}
	public static double potentialEnergy(double mass, double height) {
		return mass*height*constants.g;
	}
	public static double fallSpeed(double height) {
		return Math.pow((height*2/constants.g), 0.5)*constants.g;
		/*meter=sekunder^2*acceleration/2  & hastighet = acceleration*sekunder
		så hastighet=meter*2/acceleration^0.5*acceleration*/ 
	}
	public static double delta(double first, double last) {
		return first-last;
	}
	public static double volumeToMassFluid(enums.FluidTable fluid, double volume) {
		return fluid.density*volume;
	}
	public static double volumeToMassGas(enums.GasTable gas, double volume) {
		return gas.density*volume;
	}
	public static double volumeToMassSolid(enums.SolidTable solid, double volume) {
		return solid.density*volume;
	}
	public static double svtVelocity(double distance, double time) {
		return distance/time;
	}
	public static double svtDistance(double velocity, double time) {
		return velocity*time;
	}
	public static double svtTime(double distance, double velocity) {
		return distance/velocity;
	}
	public static double work(double force, double distance) {
		return force*distance;
	}
	public static double power(double work, double time) {
		return work/time;
	}
	public static double heatEnergy(enums.SolidTable solid, double mass, double deltaT) {
		return solid.heatCapacity*deltaT*mass;
	}
	public static double heatEnergy2(enums.FluidTable fluid, double volume, double deltaT) {
		return fluid.heatCapacity*volume*deltaT;
	}
	public static double heatEnergy3(enums.GasTable gas, double volume, double deltaT) {
		return gas.heatCapacity*volume*deltaT;
	}
	public static double velocityToHeight(double velocity) {
		return Math.pow(velocity, 2)/constants.g/2;/*meter=sekunder^2*acceleration/2*/ 
	}

	
}