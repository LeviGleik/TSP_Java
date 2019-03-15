/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author LeviGLeik
 */
public class Cidade {
    
    private int[] x  = {0,42,43,33,77,71,34,8,79,31,96,87,7,96,11,94,16,5,27,14,57,76,44,66,27,33,0,76,67,65,60,51,75,44,14,62,4,62,33,99,43,57,22,28,73,86,88,11,32,29,96,49,65,79,28,46,15,53,48,10,2,48,7,28,27,20,83,65,65,61,19,16,11,44,5,87,68,24,48,62,62,38,61,6,6,79,74,91,87,19,76,88,97,68,53,94,48,57,55,72};
    private int[] y  = {0,10,1,50,38,32,71,56,67,0,90,95,25,22,5,16,36,29,22,76,20,13,24,40,36,40,14,6,35,26,30,36,68,45,59,34,37,54,33,68,8,29,9,11,39,13,67,48,14,67,81,31,81,18,5,57,89,72,19,39,55,100,96,80,76,98,13,68,95,55,10,7,83,37,13,61,35,93,95,3,27,84,23,24,88,19,57,96,32,37,63,3,87,86,73,88,10,11,75,7};
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
    public double distanciaCidade(int[] cidade, int[] cidade2){
        return Math.sqrt(Math.pow((cidade[0] - cidade2[0]), 2) + Math.pow((cidade[1] - cidade2[1]), 2));
    }
    
    public int[][] geraPopulacao(){
        
        int pos = (int)(Math.random()*100);
        int[] prevPos = new int[100];
        int[][] populacao = new int[100][2];
        int k = 0;
        for(int i = 0; i < 100;i++){
            populacao[0] = getCidade(pos);
            prevPos[k] = pos;
            pos = (int)(Math.random()*100);

            if(!contains(prevPos, pos)){
                populacao[i] = getCidade(pos);
            } else{
                pos = (int)(Math.random()*100);
            }
            
        }
        return populacao;
    }
    public boolean contains(final int[] array, final int key) {     
        return ArrayUtils.contains(array, key);
    }
//    public double aptidao(int[] populacao){
//        double aptd;
//        for(int i = 0; i < 100; i++){
//            aptd = distanciaCidade(populacao, populacao);
//        }
//    }
}
