package app;

import app.*;

public class Determinante{
  public double determinante(double M[][]){

    double det = 0;

    det = M[0][0]*M[1][1] - M[1][0]*M[0][1];

    return det;
  }
}
