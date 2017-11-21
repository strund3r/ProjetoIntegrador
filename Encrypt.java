public class Encrypt{
  public static void main(String[] args){
    String frase;

    frase = "abcdef";
    int[] vet = new int[2];
    int[][] chave = {{1,3}, {1,4}};
    int[] crip = new int[frase.length()];

    String resp = "";

    for(int i = 0; i < (frase.length() - 1); i++){
      int k = 0;
      if(i % 2 == 0){
        vet[0] = (int) frase.charAt(i);
        vet[1] = (int) frase.charAt(i+1);
        crip[i] = (vet[0] * chave[0][0] + vet[1] * chave[1][0]) % 256;
        crip[i+1] = (vet[0] * chave[0][1] + vet[1] * chave[1][1]) % 256;

      }
    }
    for(int i = 0; i < crip.length; i++){
      System.out.println((char) crip[i]);
    }
  }
}
