import java.util.Scanner;

public class Princ_sys {
	
	private final static String SEPARADOR = (" ");

	public static void main(String[] args) {
		
		String cmd = "";		
		Scanner ler = new Scanner(System.in);
		
		while(!cmd.equalsIgnoreCase("fim")){
			
			System.out.println("Informe seu comando:");
			cmd = ler.nextLine();
			String[] splt = cmd.split(SEPARADOR);
			
			if(splt[0].equalsIgnoreCase("imagem")){
				if(splt.length==4){
				criarImagem(splt[1],splt[2],splt[3]);
				}
			}
			
			if(splt[0].equalsIgnoreCase("salvar")){
				if(splt.length==2){
				criarArquivo(splt[1]);
				}
			}
			
			if(splt[0].equalsIgnoreCase("cor")){
				if(splt.length==2){
				criarGrayscale(splt[1]);
				}
				if(splt.length==4){
					criarRGB(splt[1], splt[2], splt[3]);
				}
			}
			
			if(splt[0].equalsIgnoreCase("circulo")){
				if(splt.length==4){
				criarCirculo(splt[1],splt[2],splt[3]);
				}
			}
			
			if(splt[0].equalsIgnoreCase("reta")){
				if(splt.length==5){
				criarReta(splt[1],splt[2],splt[3],splt[4]);
				}
			}
			
			if(splt[0].equalsIgnoreCase("retangulo")){
				if(splt.length==5){
				criarRetangulo(splt[1],splt[2],splt[3],splt[4]);
				}
			}
			
			if(splt[0].equalsIgnoreCase("triangulo")){
				if(splt.length==7){
				criarTriangulo(splt[1],splt[2],splt[3],splt[4],splt[5],splt[6]);
				}
			}			
		}
		System.out.println("Dados armazenados");
	}
	
	private static void criarImagem(String largura, String altura, String gc) {
		
		Imagem imagem = new Imagem();
		int[][] matriz = new int[Integer.parseInt(largura)][Integer.parseInt(altura)];
	}

	private static void criarArquivo(String nome) {
		
		String nomeArq = nome+".pnm";
		System.out.println(nomeArq);
	}
	
	private static void criarGrayscale(String gray) {
		
		Cor cinza = new Cor();
	}
	
	private static void criarRGB(String red, String green, String blue) {
		
		Cor rgb = new Cor();
	}

	private static void criarCirculo(String x, String y, String raio) {
		
		Circulo circulo = new Circulo();
		Ponto centro = new Ponto();
		
		centro.x = Integer.parseInt(x);
		centro.y = Integer.parseInt(y);
		
		
		circulo.setCentro(centro);
		circulo.setRaio(Integer.parseInt(raio));
	}	
	
	private static void criarReta(String x0, String y0, String x1, String y1) {
		
		Reta reta = new Reta();
		Ponto p0 = new Ponto();
		Ponto p1 = new Ponto();
		
		p0.x = Integer.parseInt(x0);
		p0.y = Integer.parseInt(y0);
		p1.x = Integer.parseInt(x1);
		p1.y = Integer.parseInt(y1);
		
		reta.setVertices(p0, p1);
	}

	private static void criarRetangulo(String x0, String y0, String x1, String y1) {
		
		Retangulo retangulo = new Retangulo();
		Ponto p0 = new Ponto();
		Ponto p1 = new Ponto();
		
		p0.x = Integer.parseInt(x0);
		p0.y = Integer.parseInt(y0);
		p1.x = Integer.parseInt(x1);
		p1.y = Integer.parseInt(y1);
		
		retangulo.setVertices(p0, p1);
	}

	private static void criarTriangulo(String x0, String y0, String x1, String y1, String x2, String y2) {
		
		Triangulo triangulo = new Triangulo();
		Ponto p0 = new Ponto();
		Ponto p1 = new Ponto();
		Ponto p2 = new Ponto();
		
		p0.x = Integer.parseInt(x0);
		p0.y = Integer.parseInt(y0);
		p1.x = Integer.parseInt(x1);
		p1.y = Integer.parseInt(y1);
		p2.x = Integer.parseInt(x2);
		p2.y = Integer.parseInt(y2);
		
		triangulo.setVertices(p0, p1, p2);
	}
}
