
public class enums {
	public enum FluidTable {


		H2O(0.998, 4.19, 0, 100, 2260), 
		WATER(0.998, 4.19, 0, 100, 2260),
		H2SO4(1.84, 1.38, 10, 336, 511),
		C2H5OH(0.789, 2.44, -114.1, 78.37, 0), /*har inte hittat ångentalpi för etanol*/
		OLIVOLJA(0.915, 1.7, -3, 190, 0),/*inte här eller*/
		nothing(0, 0, 0, 0, 0)
		;
		
		double density;
		double heatCapacity;
		double meltPoint;
		double boilPoint;
		double steamEntalpy;
		
		FluidTable(double d, double hc, double sp, double bp, double se) {
			density = d * 1E3;
			heatCapacity = hc * 1E3;
			meltPoint = sp;
			boilPoint = bp;
			steamEntalpy = se * 1E3;
	
		}
		static FluidTable contains(String test) {
			/*jag googlade till mig ett sätt att returna enumen med samma namn som imput. Nothing blir svar när input inte matchade något*/
		    for (FluidTable c : FluidTable.values()) {
		        if (c.name().equals(test)) {
		            return c;
		        }
		    }
		    return FluidTable.nothing;
		    
		}
	}
	public enum GasTable{

		AIR(1.29, 1.01), 
		O2(1.43, 0.92), 
		OXYGEN(1.43, 0.92),
		GASOL(2.01, 0),
	//hittade inte värmekapacitet
		nothing(0, 0)
		;

		double density;
		double heatCapacity;

		GasTable(double d, double hc) {
			density = d;
			heatCapacity = hc * 1E3;
		}
		static GasTable contains(String test) {

		    for (GasTable c : GasTable.values()) {
		        if (c.name().equals(test)) {
		            return c;
		        }
		    }
		   return GasTable.nothing;
		}
	}
	public enum SolidTable {

		ICE(0.92, 2.2, 0, 334),
		IRON(7.87, 0.45, 1538, 276),
		nothing(0, 0, 0, 0)
		;

		double density;
		double heatCapacity;
		double meltPoint;
		double meltEntalpy;
		
		SolidTable(double d, double hc, double sp, double se) {
			density = d * 1E3;
			heatCapacity = hc * 1E3;
			meltPoint = sp;
			meltEntalpy = se * 1E3;
		}
		static SolidTable contains(String test) {
			
		    for (SolidTable c : SolidTable.values()) {
		        if (c.name().equals(test)) {
		            return c;
		        }
		    }
		    return SolidTable.nothing;
		}
		
	}
}
