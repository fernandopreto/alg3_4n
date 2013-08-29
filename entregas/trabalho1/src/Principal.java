import java.util.ArrayList;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {

		ArrayList<String> baralho = new ArrayList<String>();
		String[] naipe = { "E", "O", "P", "C" };
		String[] valor = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X",
				"J", "Q", "K" };

		for (int i = 0; i < valor.length; i++) {
			baralho.add(valor[i] + naipe[0]);
			baralho.add(valor[i] + naipe[1]);
			baralho.add(valor[i] + naipe[2]);
			baralho.add(valor[i] + naipe[3]);
		}

		Collections.shuffle(baralho);
		System.out.println("BARALHO EMBARALHADO");
		System.out.println("Cartas do baralho: " + baralho);
		System.out.println("Número de cartas: " + baralho.size());

	}

}
