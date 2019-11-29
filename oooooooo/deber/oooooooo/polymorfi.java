package oooooooo;

public class polymorfi {

	public static void main(String[] args) {
		basura[] tachoDeBasura = new basura[3];
		tachoDeBasura[0] = new polymorfi.lataDeAluminio(20);
		tachoDeBasura[1] = new polymorfi.desperdiciosNucleares(20);
		tachoDeBasura[2] = new polymorfi.reliquiaAntigua(20);
		
		for (basura basura : tachoDeBasura) {
			System.out.println();
			System.out.println(basura.getClass().getSimpleName() + " es reciclable: " + basura.esReciclable());
			System.out.println("peso = " + basura.peso);
			System.out.println("El olor : ");
			basura.oler();
			System.out.println("Sí toco la basura : ");
			basura.tocar();
			System.out.println();
			System.out.println("##############");	
		}
	}

	static abstract class basura {
		private double peso;
		public basura(double peso) {
			this.peso = peso;
		}
			
		void cambiarPeso(double pesoNuevo) {
			this.peso = pesoNuevo;
		}
		
		double conseguirPeso() {
			return this.peso;
		}
		
		abstract boolean esReciclable();
		
		abstract void oler();
		
		abstract void tocar();
	}
	
	static class lataDeAluminio extends basura{
		public lataDeAluminio(double peso) {
			super(peso);
		}
		
		boolean esReciclable() {
			return true;
		}
		
		void oler() {
			System.out.println("No huelo nada.");
		}
		
		void tocar() {
			System.out.println("Se hace un ruido metálico.");
		}
	}
	static class desperdiciosNucleares extends basura{
		public desperdiciosNucleares(double peso) {
			super(peso);
		}
		
		boolean esReciclable() {
			return false;
		}
		
		void oler() {
			System.out.println("Siento una sensación metálica en la nariz.");
		}
		
		void tocar() {
			System.out.println("Ahora tengo cancer.");
		}
	}
	static class reliquiaAntigua extends basura{
		public reliquiaAntigua(double peso) {
			super(peso);
		}
		
		boolean esReciclable() {
			return false;
		}
		
		void oler() {
			System.out.println("Huele como la casa de mi abuela.");
		}
		
		void tocar() {
			System.out.println("Ahora está roto y sin valor.");
		}
	}
	
}
