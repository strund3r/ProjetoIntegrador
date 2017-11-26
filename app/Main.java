package app;

import java.util.*;
import app.*;

public class Main{
  public static void main(String args[]){

    int opcao = 0;
    String mensagem, imprimir = "", cripto = "";
    double encriptado[] = new double[2];

    Main inv = new Main();
    Scanner leitor = new Scanner(System.in);

    while(opcao != 3){
      System.out.printf("\n************** Menu **************");
      System.out.printf("\n*\t\t\t\t *");
      System.out.printf("\n*  1 - Encriptografar Mensagem   *");
      System.out.printf("\n*\t\t\t\t *");
      System.out.printf("\n*  2 - Descriptografar Mensagem  *");
      System.out.printf("\n*\t\t\t\t *");
      System.out.printf("\n*  3 - Sair                      *");
      System.out.printf("\n*\t\t\t\t *");
      System.out.printf("\n**********************************");
      System.out.printf("\n\nEscolha a opção: ");
      opcao = leitor.nextInt();

      switch(opcao){
        case 1:
          System.out.printf("\nEntre com a dimensão da matriz: ");
          int tamanho = leitor.nextInt();

          double matriz[][] = new double[tamanho][tamanho];

          //
          //
          do{
            System.out.println("\nEntre com os elementos da matriz: ");
            for(int i = 0; i < tamanho; i++) {
                    for(int j = 0; j < tamanho; j++) {
                            matriz[i][j] = leitor.nextInt();
                    }
            }

            if(inv.determinante(matriz, tamanho) == 0){
                    System.out.println("A matriz não é inversível, o valor da "
                                       + "determinante é: "
                                       + inv.determinante(matriz, tamanho));
            }

          }while(inv.determinante(matriz, tamanho) == 0);

          System.out.printf("\nA matriz é inversível, o valor da determinante é: "
                            + inv.determinante(matriz, tamanho) + "\n");
          //
          //

          //
          //
          System.out.println("\nDigite a mensagem para ser encriptografada:\n");
          mensagem = leitor.next();

          if(mensagem.length() % 2 != 0){
            mensagem += ".";
          }
          //
          //

          //
          //
          double p[] = new double[2];

      		double b[] = new double[mensagem.length()];
      		for (int i = 0; i < mensagem.length(); i++) {
      			if (i % 2 == 0) {
      				p[0] = (double) mensagem.charAt(i);
      				p[1] = (double) mensagem.charAt(i + 1);
      				b[i] = (p[0] * matriz[0][0] + p[1] * matriz[1][0]) % 256;
      				b[i + 1] = (p[0] * matriz[0][1] + p[1] * matriz[1][1]) % 256;

      			}
      		}
      		for (int i = 0; i < b.length; i++){
      			cripto += (char) b[i];
      		}
          System.out.println("\nA mensagem encriptografada é: " + cripto + "\n");
          //
          //

          //
          //
          double matrizInversa[][] = Inverte.inverte(matriz);
          //
          //

          //
          //
          System.out.println("\nA matriz inversa é: ");
          for (int i=0; i<tamanho; ++i) {
                  for (int j=0; j<tamanho; ++j) {
                          System.out.print(matrizInversa[i][j]+"  ");
                  }
                  System.out.println();
          }
          //
          //
          break;

        case 2:
          System.out.println("\nDigite a mensagem para ser descriptografada:\n\n");
          mensagem = leitor.next();

          System.out.printf("\nEntre com a dimensão da matriz: ");
          int tamanhoInversa = leitor.nextInt();

          double[][] chaveInversa = new double[tamanhoInversa][tamanhoInversa];

          System.out.println("\nEntre com a matriz inversa: ");
          for(int i = 0; i < tamanhoInversa; i++) {
                  for(int j = 0; j < tamanhoInversa; j++) {
                          chaveInversa[i][j] = leitor.nextInt();
                  }
          }

          double desencriptar[] = new double[mensagem.length()];

          for (int i = 0; i < mensagem.length(); i++) {
            if (i % 2 == 0) {
              encriptado[0] = (double) mensagem.charAt(i);
              encriptado[1] = (double) mensagem.charAt(i + 1);
              desencriptar[i] = (encriptado[0] * chaveInversa[0][0] + encriptado[1] * chaveInversa[1][0]) % 256;
              desencriptar[i + 1] = (encriptado[0] * chaveInversa[0][1] + encriptado[1] * chaveInversa[1][1]) % 256;

            }
          }
          for (int i = 0; i < desencriptar.length; i++) {
            imprimir += (char) desencriptar[i];

          }
          System.out.println("\nMensagem Descriptografada:\n\n" + imprimir);
          System.out.println("\n\n");

          break;

        case 3:
          System.out.printf("\nProgama Finalizado!\n");
          break;

        default:
        System.out.printf("\n\n*** Opção Inválida! ***\n\n");
      }
    }

    leitor.close();
  }

  //Determinante
  public double determinante(double M[][], int N){

    double det = 0;

    if(N == 1){

      det = M[0][0];

    }else if(N == 2){

      det = M[0][0]*M[1][1] - M[1][0]*M[0][1];

    }else{

      det = 0;

      for(int i = 0; i < N; i++){

        double[][] matriz = new double[N-1][];

        for(int j = 0; j < (N-1); j++){

          matriz[j] = new double[N-1];

        }

        for(int k = 0; k < N; k++){

          int l = 0;

          for(int m = 0; m < N; m++){

            if(m == i){
              continue;
            }
            matriz[k-1][l] = M[k][m];
            l++;
          }
        }

        det += Math.pow(-1.0, (1.0 + i + 1.0)) * M[0][i] * determinante(matriz, N-1);
      }
    }

    return det;
  }
}
