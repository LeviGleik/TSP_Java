/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import org.jfree.ui.RefineryUtilities;

public class TSP {

    /**
     * @param args the command line arguments
     */
    public static void main( String[ ] args ) {
      LineChart_AWT chart = new LineChart_AWT("Browser Usage Statistics",
         "Which Browser are you using?");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }
    
    
}
