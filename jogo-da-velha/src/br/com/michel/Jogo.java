package br.com.michel;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[][] tabuleiro = new char[3][3];
		boolean ganhou = true, continuar = true;
		int jogada = 1, linha = 0, coluna = 0;
		char sinal;
		String play;

		System.out.println("Bem vindo ao Jogo da Velha!");
		System.out.println("Jogador 1 usa a letra [X]");
		System.out.println("Jogador 2 usa a letra [O]");
		System.out
				.println("O jogador marca a posição de acordo com a linha e coluna selecionados.\n");

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = '-';
			}
		}
		// imprime o tabuleiro
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print(tabuleiro[i][j] + " | ");
			}
			System.out.println();
		}

		while (continuar) {
			System.out.println();
			System.out.println("Que tal uma partida?");
			System.out.println("Responda, Sim ou Não?");
			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[i].length; j++) {
					tabuleiro[i][j] = '-';
				}
			}
			play = scan.next();
			if (play.equalsIgnoreCase("S") || play.equalsIgnoreCase("SIM")) {
				while (true) {
					// determina qual a vez de cada jogador
					if (jogada % 2 == 1) {
						System.out
								.println("Vez do JOGADOR 1. Escolha linha e coluna (1-3)\n");
						sinal = 'X';
					} else {
						System.out
								.println("Vez do JOGADOR 2. Escolha linha e coluna (1-3)\n");
						sinal = 'O';
					}

					// verifica se a linha digitada é válida
					boolean linhaValida = false;
					while (!linhaValida) {
						System.out.println("Entre com a linha (1,2 ou 3)");
						linha = scan.nextInt();
						if (linha >= 1 && linha <= 3) {
							linhaValida = true;
						} else {
							System.out
									.println("Entrada inválida! Tente novamente.");
						}
					}
					// verifica se a coluna digitada é válida
					boolean colunaValida = false;
					while (!colunaValida) {
						System.out.println("Entre com a coluna (1,2 ou 3");
						coluna = scan.nextInt();
						if (coluna >= 1 && coluna <= 3) {
							colunaValida = true;
						} else {
							System.out
									.println("Entrada inválida! Tente novamente.");
						}
					}
					// decrementando o valor do usuario, para que fique amigável
					// de
					// compreender o array
					linha--;
					coluna--;

					// verifica se a posição já foi preenchida
					if (tabuleiro[linha][coluna] == 'X'
							|| tabuleiro[linha][coluna] == 'O') {
						System.out
								.println("Posição já utilizada, tente novamente!");
					} else {
						tabuleiro[linha][coluna] = sinal;
						jogada++;
					}
					// imprime o tabuleiro
					for (int i = 0; i < tabuleiro.length; i++) {
						for (int j = 0; j < tabuleiro[i].length; j++) {
							System.out.print(tabuleiro[i][j] + " | ");
						}
						System.out.println();
					}
					System.out.println();

					// verificar se tem ganhador
					if ((tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X')
							|| // linha 1
							(tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X')
							|| // linha 2
							(tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X')
							|| // linha 3
							(tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X')
							|| // coluna 1
							(tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X')
							|| // coluna 2
							(tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X')
							|| // coluna 3
							(tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') // diagonal
							|| (tabuleiro[0][2] == 'X'
									&& tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X')) { // diagonal
						ganhou = false;
						System.out.println("Parabéns, jogador 1 ganhou!");
						break;
					} else if ((tabuleiro[0][0] == 'O'
							&& tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O')
							|| // linha 1
							(tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O')
							|| // linha 2
							(tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O')
							|| // linha 3
							(tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O')
							|| // coluna 1
							(tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O')
							|| // coluna 2
							(tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O')
							|| // coluna 3
							(tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') // diagonal
							|| (tabuleiro[0][2] == 'O'
									&& tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O')) { // diagonal
						ganhou = false;
						System.out.println("Parabéns, jogador 2 ganhou!");
						break;
					} else if (jogada > 9) {
						ganhou = false;
						System.out.println("Ninguém ganhou essa partida.");
						break;
					}
				}
			} else if (play.equalsIgnoreCase("N")
					|| play.equalsIgnoreCase("NÃO")
					|| play.equalsIgnoreCase("NAO")) {
				System.out.println("Espero que tenha se divertido. Obrigado!");
				continuar = false;
			} else {
				System.out.println("Opção inválida!");
				continue;
			}
		}
	}
}