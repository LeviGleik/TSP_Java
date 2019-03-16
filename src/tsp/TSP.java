/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import org.jfree.ui.RefineryUtilities;

public class TSP {

    public static void main( String[ ] args ) {
//      LineChart_AWT chart = new LineChart_AWT("Browser Usage Statistics",
//         "Which Browser are you using?");
//      chart.pack( );          
//      RefineryUtilities.centerFrameOnScreen( chart );          
//      chart.setVisible( true ); 
        Populacao city = new Populacao();
        int[][] populacaoInicial = city.geraPopulacao();
        double[] aptd = new double[50];            
        aptd = city.aptidao(populacaoInicial);
        double aptdAcumulada = 0;
        
//        for(int i = 0; i < 50; i++){
//            for(int j = 0; j < 100; j++){
//                System.out.print(populacaoInicial[i][j] + " ");
//            }
////            aptdAcumulada += aptd[i];
//            
////            System.out.println(aptd[i]);
////            System.out.println("Acumulada: " + aptdAcumulada);
//            System.out.println(populacaoInicial[i]);
////
//        }
        populacaoInicial = city.roleta(populacaoInicial);
//        for(int i = 0; i < 50; i++){
//            for(int j = 0; j < 100; j++){
//                System.out.print(populacaoInicial[i][j] + " ");
//            }            
//            System.out.println(populacaoInicial[i]);
//            
//        }
        

    
    }
    
}
