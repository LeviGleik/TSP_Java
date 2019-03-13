/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.awt.Color; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.data.xy.XYSeriesCollection; 

/**
 *
 * @author 1721057
 */
public class LineChart_AWT extends ApplicationFrame{
    public LineChart_AWT( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createScatterPlot(
         "Cidades", 
        "X", "Y", createDataset());
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 860 , 567 ) );
      XYPlot plot = (XYPlot)xylineChart.getPlot();
      plot.setBackgroundPaint(new Color(255,228,196));
      setContentPane( chartPanel ); 
   }
   
   private XYDataset createDataset( ) {     
      
      final XYSeries cities = new XYSeries( "Cidades" );        
      int[] x = {0,42,43,33,77,71,34,8,79,31,96,87,7,96,11,94,16,5,27,14,57,76,44,66,27,33,0,76,67,65,60,51,75,44,14,62,4,62,33,99,43,57,22,28,73,86,88,11,32,29,96,49,65,79,28,46,15,53,48,10,2,48,7,28,27,20,83,65,65,61,19,16,11,44,5,87,68,24,48,62,62,38,61,6,6,79,74,91,87,19,76,88,97,68,53,94,48,57,55,72};
      int[] y = {0,10,1,50,38,32,71,56,67,0,90,95,25,22,5,16,36,29,22,76,20,13,24,40,36,40,14,6,35,26,30,36,68,45,59,34,37,54,33,68,8,29,9,11,39,13,67,48,14,67,81,31,81,18,5,57,89,72,19,39,55,100,96,80,76,98,13,68,95,55,10,7,83,37,13,61,35,93,95,3,27,84,23,24,88,19,57,96,32,37,63,3,87,86,73,88,10,11,75,7};
      for(int i = 0; i < 99; i++){
          cities.add(x[i], y[i]);
      }        
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );   
      dataset.addSeries( cities );      

      return dataset;
   }
   
   
}
