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
        Cidade city = new Cidade();
        int[][] populacaoInicial = city.geraPopulacao();
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(populacaoInicial[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    
}
