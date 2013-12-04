package main;

import grafo.Dijkstra;
import grafo.Grafo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Principal {

	
	private Grafo grafo;
	private static int totalVertices;

	public static void main(String[] args) {
		
		int origem = 0;
		int destino = 0;
		
		try {
			totalVertices = countLines("graphos.txt");
			System.out.println("Vertice de indice mais alto: " + totalVertices);
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Informe os vertices de ORIGEM e de DESTINO e tecle ENTER");
			
			String[] values = scanner.nextLine().split(" ");
			origem  = Integer.parseInt(values[0]);
			destino = Integer.parseInt(values[1]);
			
			if (origem < 0) {
				System.err.println("Valor de 'ORIGEM' invalido! Algoritmo n�o suporta valores negativos!");
				System.exit(-1);
			}
			if (destino > totalVertices) {
				System.err.println("Valor de 'DESTINO' invalido! O valor do v�rtice não existe na �rvore!");
				System.exit(-1);
			}
			
		} catch (IOException e) {
			System.err.println("Erro na leitura do arquivo 'graphos.txt'");
			System.exit(-1);
		} catch (Exception e) {
			System.err.println("Erro na entrada/leitura de dados! Informe 2 n�meros separados por um espa�o!");
			System.exit(-1);
		}
		
		try {
			new Principal(origem, destino);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public Principal(int origem, int destino) throws Exception {
		grafo = new Grafo(totalVertices);
		carregaGrafo();
		int raiz = origem;
		Dijkstra dj = new Dijkstra(grafo);
		dj.obterArvoreCMC(raiz);

		StringBuilder melhorCaminho = dj.imprimeCaminho(origem, destino);
		
		
		if (melhorCaminho.substring(0, 1).equals(String.valueOf(origem))) {
			System.out.println("Melhor caminho: " + melhorCaminho);
		} else {
			System.out.println("Melhor caminho: " + melhorCaminho.reverse());
		}
		
	}
	
	public void carregaGrafo() throws Exception {

		BufferedReader br = null;
		
		try {
			
			String linha;
			br = new BufferedReader(new FileReader("graphos.txt"));

			String[] value = new String[3];
			int v1 = 0;
			int v2 = 0;
			int peso = 0;
			
			while ((linha = br.readLine()) != null) {
				value = linha.split(" ");
				v1 = Integer.valueOf(value[0]);
				v2 = Integer.valueOf(value[1]);
				peso = Integer.valueOf(value[2]);
				grafo.insereAresta(v1, v2, peso);				
			}

		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou o arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			throw new Exception("Não foi poss�vel abrir o arquivo 'graphos.txt'");
		} catch (Exception e) {
			throw new Exception("Erro na estrutura do arquivo: Formato esperado de dados inv�lido!");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Aviso: Houve um problema ao tentar fechar o arquivo! " + e.getMessage());
			}
		}
	}
	
	private static int countLines(String file) throws IOException {
		int lineCount = 0;
		LineNumberReader lineNumberReader = null;
		try {
			lineNumberReader = new LineNumberReader(new FileReader(file));
			lineNumberReader.skip(Long.MAX_VALUE);
			lineCount = lineNumberReader.getLineNumber();
		} finally {
			lineNumberReader.close();
		}
		return lineCount;
	}
}
