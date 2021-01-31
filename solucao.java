
import java.util.Scanner;
public class solucao {
	public static void main(String[] args) {
		 Scanner leia = new Scanner(System.in);
		 int qPares = 0, qImpares = 0, num = 0;
		 
		 while(num != -1) {
			 num = leia.nextInt();
			 if(num != -1) {
				 if(num % 2 == 0) {
					  qPares++;
				 }else {
					 qImpares++;
				 }
			 }
		 }
		 System.out.println("Pares: "+ qPares+" Impares: "+ qImpares);
		 leia.close();
	}
}
