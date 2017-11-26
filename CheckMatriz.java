import java.util.*;

public class CheckMatriz{
  public static void main(String args[]){

    int tamanho;

    Scanner leitor = new Scanner(System.in);

    System.out.printf("\nEntre com o tamanho da matriz: ");
    tamanho = leitor.nextInt();

    System.out.printf("\nEntre com os valores da matriz: ");
    int[][] matriz = new int[tamanho][tamanho];
    for(int i = 0; i < tamanho; i++){
      for(int j = 0; j < tamanho; j++){
        matriz[i][j] = leitor.nextInt();
      }
    }

    CheckMatriz check = new CheckMatriz();

    if(check.determinante(matriz, tamanho) != 0){

      System.out.printf("\nA matriz é inversível, o valor da determinante é: "
                        + check.determinante(matriz, tamanho) + "\n");

    }else{

      System.out.printf("\nA matriz não é inversível, o valor da determinante é: "
                        + check.determinante(matriz, tamanho) + "\n");

    }

    leitor.close();

  }

  public double determinante(int M[][], int N){

    int det = 0;

    if(N == 1){

      det = M[0][0];

    }else if(N == 2){

      det = M[0][0]*M[1][1] - M[1][0]*M[0][1];

    }else{

      det = 0;

      for(int i = 0; i < N; i++){

        int[][] matriz = new int[N-1][];

        for(int j = 0; j < (N-1); j++){

          matriz[j] = new int[N-1];

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

        det += (int) Math.pow(-1.0, (1.0 + i + 1.0)) * M[0][i] * determinante(matriz, N-1);

      }
    }

    return det;

  }
}
