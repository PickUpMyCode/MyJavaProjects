

public class Gera {
	private static int Numero;
	private static void setNumero(int num) {
		Numero = num;
	}
	public static int getNumero() {
		return Numero;
	}
	public static int Random(int NumAlgaris) {
		if(NumAlgaris == 1) {
			int num = (int)(Math.random() * 10);
			setNumero(num);
			return getNumero();
		}
		else if(NumAlgaris == 2) {
			int num = (int) (Math.random() * 100);
			setNumero(num);
			return getNumero();
		}
		else if(NumAlgaris == 3) {
			int num = (int) (Math.random() * 1000);
			setNumero(num);
			return getNumero();
		} else {
			NumAlgaris = 0;
			System.out.println("No Maximo 3 algorismos!");
			return 0;
		}
	}
}
