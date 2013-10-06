import java.util.Scanner;

public class Sistema {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		

		String cmd = "";
		
		while(sc.hasNext()){
			cmd = sc.next().toLowerCase();
				switch (cmd){
					case "fim": System.exit(0);
					case "imagem": trataComandoImagem();break;
					case "circulo": trataComandoCirculo();break;
					case "salvar": trataComandoSalvar();break;
				}
		}
		/*while (!cmd.equals("fim")) {

			System.out.print("\nDigite: \n");
			cmd = sc.next();
			if (cmd.equalsIgnoreCase("reta")) {
				System.out.print("Você digitou: " + cmd);
			}
			if (cmd.equalsIgnoreCase("triângulo")) {
				System.out.print("Você digitou: " + cmd);
			}
			if (cmd.equalsIgnoreCase("círculo")) {
				System.out.print("Você digitou: " + cmd);
			}
			if (cmd.equalsIgnoreCase("retângulo")) {
				System.out.print("Você digitou: " + cmd);
			}
		}*/
	}

	private static void trataComandoSalvar() {
		// TODO Auto-generated method stub
		
	}

	private static void trataComandoCirculo() {
		
		int xc = sc.nextInt();
		int yc = sc.nextInt();
		int raio = sc.nextInt();
		
		Circulo c = new Circulo(xc, yc, raio);
		
	}

	private static void trataComandoImagem() {
		// TODO Auto-generated method stub
		
	}
	
	
	// criar triangulo
	// imprimir dados do triangulo

}
