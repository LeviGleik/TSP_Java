/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;
import java.util.ArrayList;

/**
 *
 * @author LeviGLeik
 */
public class Populacao {
    
    private int[][] xy = {{0, 0},{42, 10},{43, 1},{33, 50},{77, 38},{71, 32},{34, 71},{8, 56},{79, 67},{31, 0},{96, 90},{87, 95},{7, 25},{96, 22},{11, 5},{94, 16},{16, 36},{5, 29},{27, 22},{14, 76},{57, 20},{76, 13},{44, 24},{66, 40},{27, 36},{33, 40},{0, 14},{76, 6},{67, 35},{65, 26},{60, 30},{51, 36},{75, 68},{44, 45},{14, 59},{62, 34},{4, 37},{62, 54},{33, 33},{99, 68},{43, 8},{57, 29},{22, 9},{28, 11},{73, 39},{86, 13},{88, 67},{11, 48},{32, 14},{29, 67},{96, 81},{49, 31},{65, 81},{79, 18},{28, 5},{46, 57},{15, 89},{53, 72},{48, 19},{10, 39},{2, 55},{48, 100},{7, 96},{28, 80},{27, 76},{20, 98},{83, 13},{65, 68},{65, 95},{61, 55},{19, 10},{16, 7},{11, 83},{44, 37},{5, 13},{87, 61},{68, 35},{24, 93},{48, 95},{62, 3},{62, 27},{38, 84},{61, 23},{6, 24},{6, 88},{79, 19},{74, 57},{91, 96},{87, 32},{19, 37},{76, 63},{88, 3},{97, 87},{68, 86},{53, 73},{94, 88},{48, 10},{57, 11},{55, 75},{72, 7}};
    
    public int[] getCidade(int pos){
        return this.xy[pos];
    }
    public int getTheCity(int [] cidade){
        int cidadeN = 0;
        for(int i = 0; i < 100; i++){
            if(cidade == this.xy[i]){
                cidadeN = i;
            }
        }
        return cidadeN;
    }
    public double distanciaCidade(int cidade, int cidade2){
        return Math.sqrt(Math.pow((this.xy[cidade][0] - this.xy[cidade2][0]), 2) + Math.pow((this.xy[cidade][1] - this.xy[cidade2][1]), 2));
    }
    
    public int[] geraRota(){        
        int pos = (int)(Math.random()*100);
        ArrayList<Integer> prevPos = new ArrayList();
        int[] rota = new int[100];
        rota[0] = pos;
        prevPos.add(pos);
        pos = (int)(Math.random()*100);
        
        for(int i = 1; i < 100; i++){      
            while(prevPos.contains(pos)) {
                pos = (int)(Math.random()*100);
            }
            prevPos.add(pos);
            rota[i] = pos;
        }
        return rota;
    }
    public int[][] geraPopulacao(){
        int[][] populacao = new int[50][100];
        for(int i = 0; i < 50; i++){
            populacao[i] = geraRota();
        }
        return populacao;
    }
    public double[] somaDistancias(int[][] populacao){
        double[] aptd = new double[50];
        int k = 1;
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 100; j++){
                aptd[i] += distanciaCidade(populacao[i][j], populacao[i][k]);
            }
        }
        return aptd;
    }
    public double somaDistanciasTotal(int[][] populacao){
        double aptd = 0;
        double[] ap = somaDistancias(populacao);
        for(int i = 0; i < 50; i++){
            aptd += ap[i];
        }
        return aptd;
    }
    public double[] inverte(int[][] populacao){
        double[] invertida = new double[50];
        double[] dist = somaDistancias(populacao);
        for(int i = 0; i < 50; i++){
            invertida[i] = 1/dist[i];
        }
        return invertida;
    }
    public double inverteTotal(int[][] populacao){
        double invertidaTotal = 0;
        double[] invertida = inverte(populacao);
        for(int i = 0; i < 50; i++){
            invertidaTotal += invertida[i];
        }
        return invertidaTotal;
    }
    public double[] aptidao(int[][] populacao){
        double[] aptd = new double[50];
        double[] invertida = inverte(populacao);
        double invertidaTotal = inverteTotal(populacao);
        for (int i = 0; i < 50; i++) {
            aptd[i] = invertida[i]/invertidaTotal;
        }
        return aptd;
    }
    public int[][] roleta(int[][] populacao){
        double[] aptidao = aptidao(populacao);
        double[][] ranges = new double[50][2];
        double aptd = 0;
        
        int[][] novaPopulacao = new int[50][100];
        novaPopulacao[0] = populacao[0];

        double rol;
        int k = 0;

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 2; j++) {
                    aptd += aptidao[k++];
                    ranges[i][j] = aptd;
            }
        }
        for(k=0; k < 50;){
            rol = Math.random();
            for (int n = 1; n < 50; n++) {
                
                if(rol >= ranges[n][0] && rol < ranges[n][1]){
                    novaPopulacao[k++] = populacao[n];
                }
            }
        }
        return novaPopulacao;        
    }
    public int[][] combinacao(int[][] populacao){
        int[][] populacaoAux1 = new int[50][100];
        int[][] populacaoAux2 = new int[50][100];
        int[][] novaPopulacao = new int[50][100];
        int j1Pos;
        int j2Pos;
        int i1Pos;
        int i2Pos;
        int k = 0;
        for(int i = 0; i < 50; i++, k++){
            j1Pos = (int) (Math.random() * 99);
            i1Pos = (int) (Math.random() * 49);
            i2Pos = (int) (Math.random() * 49);
            j2Pos = (int) (Math.random() * 99);
            System.out.println("j1: " + j1Pos);
            System.out.println("j2: " + j2Pos);
            System.out.println("i1: " + i1Pos);
            System.out.println("i2: " + i2Pos);

            if(i1Pos != i2Pos){
                for(int j = 0; j < 100; j++){
                    if(j1Pos > j2Pos){
                        if(j <= j1Pos && j > j2Pos+1){
                            populacaoAux1[k][j] = populacao[i2Pos][j];
                            populacaoAux2[i2Pos][j] = populacao[i1Pos][j];
                        }
                    } else if(j2Pos > j1Pos){
                        if(j >= j1Pos && j < j2Pos+1){
                            populacaoAux1[k][j] = populacao[i2Pos][j];
                            populacaoAux2[i1Pos][j] = populacao[i1Pos][j];
                        }
                    } else{
                        j1Pos = (int) (Math.random() * 99);
                        j2Pos = (int) (Math.random() * 99);
                    }
                }
                
            } else{
                i1Pos = (int) (Math.random() * 49);
                i2Pos = (int) (Math.random() * 49);
            }
        }
        return populacaoAux1;
    }
}
