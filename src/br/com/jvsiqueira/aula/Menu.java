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
			
			// BLOCO RESPONS�VEL POR PRINTAR O MENU
			operacao = menu(listaExercicios);
			
			// BLOCO RESPONS�VEL POR CHAMAR O EXERC�CIO
			exercicio(operacao, listaExercicios);
			
			// BLOCO RESPONS�VEL POR FINALIZAR OU CONTINUAR COM O MENU
			continua = paraOuContinua();		
		}		
	}
	
	/**
	 * M�todo respons�vel por popular as vari�veis
	 * @return
	 */
	public static ArrayList<String> populandoVetorMenu() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add(0, "000 - Hello World");
		lista.add(1, "001 - Soma");
		lista.add(2, "002 - Ol� Fulano");
		lista.add(3, "003 - Reprovado!");
		lista.add(4, "004 - Mini Login");
		lista.add(5, "005 - A idade");
		lista.add(6, "006 - O bug do infinito");
		return lista;
	}
	
	/**
	 * M�todo respons�vel por listar o menu
	 * @param exercicios
	 * @return
	 */
	public static int menu(ArrayList<String> exercicios) {
		System.out.println("Qual exerc�cio voc� deseja acessar?\n");
		for (String exercicio : exercicios) {
			System.out.println("\t" + exercicio);
		}
		System.out.print("\nDigite o c�digo do exerc�cio: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	/**
	 * M�todo respons�vel por chamar o exerc�cio
	 * @param operacao
	 * @param exercicios
	 */
	public static void exercicio(int operacao, ArrayList<String> exercicios) {
		
		if(operacao > exercicios.size() || operacao < 0) {
			System.out.println("\nMano.. tu tem que colocar uma daquelas op��es ali do menu");
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
				System.out.println("EM CONSTRU��O...");
			}
			System.out.println(asterisco+"\n Finalizando " + exercicios.get(operacao)+asterisco+"\n");
		}
	}
	
	/**
	 * M�todo respons�vel por quetionar se o programa deve se repetir ou finalizar
	 * @return
	 */
	public static String paraOuContinua() {
		
		boolean pergunta = true;
		String continua = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nDeseja rodar outro programa? S (Sim) N (N�o): ");
		int i = 0;
		pergunta = true;
		while(pergunta) {
			continua = sc.next();
			if(!continua.equalsIgnoreCase("S") && !continua.equalsIgnoreCase("N")){
				if(i == 0) {
					System.out.print("\nQual parte do S ou N voc� n�o entendeu? Tenta de novo: ");
					i++;
				}else if(i == 1){
					System.out.print("\nVou ter que escolher por voc�? Tenta de novo: ");
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
