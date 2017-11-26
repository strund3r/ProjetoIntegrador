package app;

import app.*;

public class Determinante{
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
