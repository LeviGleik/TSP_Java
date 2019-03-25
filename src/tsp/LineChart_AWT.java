/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.awt.BasicStroke;
import java.awt.Color; 

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author 1721057
 */
public class LineChart_AWT extends ApplicationFrame{
    public LineChart_AWT( String applicationTitle , String chartTitle, XYDataset dataset) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
           chartTitle,
           "Rota","Distância",
           dataset);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1280 , 670 ) );

        final XYPlot plot = (XYPlot) lineChart.getXYPlot( );
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        lineChart.getPlot().setBackgroundPaint(Color.WHITE);
        renderer.setSeriesPaint( 0 , Color.BLACK );
        renderer.setSeriesStroke( 0 , new BasicStroke( 0.8f ) );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesPaint( 2 , Color.RED );
        renderer.setSeriesStroke( 2 , new BasicStroke( 3.0f ) );

        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesLinesVisible(2, false);

        XYPlot xyPlot = lineChart.getXYPlot();
        org.jfree.chart.axis.ValueAxis domainAxis = xyPlot.getDomainAxis();
        org.jfree.chart.axis.ValueAxis rangeAxis = xyPlot.getRangeAxis();

//        domainAxis.setAutoRange(true);
        rangeAxis.setAutoRange(true);
       // domainAxis.setRange(0.0, 150.0);
        rangeAxis.setRange(4400.0, 6400.0);
//        rangeAxis.setTickUnit(new NumberTickUnit(0.05));
         plot.setRenderer(renderer);
        setContentPane( chartPanel ); 
   }   
}
