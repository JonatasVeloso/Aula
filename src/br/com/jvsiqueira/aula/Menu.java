package br.com.jvsiqueira.aula;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		// Populando lista
		ArrayList<String> listaExercicios = populandoVetorMenu();
		int operacao = 0;
		String continua = "S";
		
		while(continua.equalsIgnoreCase("S")) {
			
			// BLOCO RESPONSÁVEL POR PRINTAR O MENU
			operacao = menu(listaExercicios);
			
			// BLOCO RESPONSÁVEL POR CHAMAR O EXERCÍCIO
			exercicio(operacao, listaExercicios);
			
			// BLOCO RESPONSÁVEL POR FINALIZAR OU CONTINUAR COM O MENU
			continua = paraOuContinua();		
		}		
	}
	
	/**
	 * Método responsável por popular as variáveis
	 * @return
	 */
	public static ArrayList<String> populandoVetorMenu() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add(0, "000 - Hello World");
		lista.add(1, "001 - Soma");
		lista.add(2, "002 - Olá Fulano");
		lista.add(3, "003 - Reprovado!");
		lista.add(4, "004 - Mini Login");
		lista.add(5, "005 - A idade");
		lista.add(6, "006 - O bug do infinito");
		return lista;
	}
	
	/**
	 * Método responsável por listar o menu
	 * @param exercicios
	 * @return
	 */
	public static int menu(ArrayList<String> exercicios) {
		System.out.println("Qual exercício você deseja acessar?\n");
		for (String exercicio : exercicios) {
			System.out.println("\t" + exercicio);
		}
		System.out.print("\nDigite o código do exercício: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	/**
	 * Método responsável por chamar o exercício
	 * @param operacao
	 * @param exercicios
	 */
	public static void exercicio(int operacao, ArrayList<String> exercicios) {
		
		if(operacao > exercicios.size() || operacao < 0) {
			System.out.println("\nMano.. tu tem que colocar uma daquelas opções ali do menu");
		} else {
			String asterisco = "\n*********************************************************";
			System.out.println(asterisco+"\n Iniciando " + exercicios.get(operacao)+asterisco+"\n");
			if(operacao == 0) {
				Ex000 ex = new Ex000();
				ex.execute();
			}else if(operacao == 6) {
				Ex006 ex = new Ex006();
				ex.execute();
			}else {
				System.out.println("EM CONSTRUÇÃO...");
			}
			System.out.println(asterisco+"\n Finalizando " + exercicios.get(operacao)+asterisco+"\n");
		}
	}
	
	/**
	 * Método responsável por quetionar se o programa deve se repetir ou finalizar
	 * @return
	 */
	public static String paraOuContinua() {
		
		boolean pergunta = true;
		String continua = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nDeseja rodar outro programa? S (Sim) N (Não): ");
		int i = 0;
		pergunta = true;
		while(pergunta) {
			continua = sc.next();
			if(!continua.equalsIgnoreCase("S") && !continua.equalsIgnoreCase("N")){
				if(i == 0) {
					System.out.print("\nQual parte do S ou N você não entendeu? Tenta de novo: ");
					i++;
				}else if(i == 1){
					System.out.print("\nVou ter que escolher por você? Tenta de novo: ");
					i++;
				}else {
					System.out.print("\nDesisto... vou finalizar o programa.");
					return "N";
				}
			}else {
				pergunta = false;
			}
		}
		return continua;
	}
}
