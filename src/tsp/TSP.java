/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

public class TSP {

    public static void main( String[ ] args ) {
        
        
        Populacao city = new Populacao();
        Integer[][] populacaoInicial = city.geraPopulacao();
        Integer[][] melhorPopulacao = populacaoInicial;
        Integer[] melhorIndividuo = new Integer[100];
        ArrayList<Double> menor = new ArrayList<>();
        ArrayList<Double> mediaAptd = new ArrayList<>();
        menor.add(city.somaDistancias(populacaoInicial)[0]);
        double soma = menor.get(0);
        double somaTotal = city.somaDistanciasTotal(populacaoInicial);
        double m = menor.get(0);
        double n = menor.get(0);
        populacaoInicial = city.populacaoIniciar(populacaoInicial);

        for (int i = 0; i < 600; i++) {

            if(somaTotal <= city.somaDistanciasTotal(populacaoInicial)){
                populacaoInicial = city.populacaoIniciar(populacaoInicial);
            }
            
            for (int j = 0; j < 50; j++) {
                if((city.somaDistancias(populacaoInicial)[j] >= m)){
                    m = city.somaDistancias(populacaoInicial)[j];
                    melhorIndividuo = populacaoInicial[j];
                }
            }
            
            if(m <= n){
                n = m;
                melhorPopulacao = populacaoInicial;
            }
            
            soma += m;
            menor.add(m);
            m = city.somaDistancias(populacaoInicial)[0];
            mediaAptd.add(soma/menor.size());
            somaTotal = city.somaDistanciasTotal(populacaoInicial);

            
//            System.out.println(n);
//            System.out.println("Média\t" + mediaAptd.get(i));
        }
        
        XYSeries menorAptd = new XYSeries("menor");
        XYSeries media = new XYSeries("media");
//        XYSeries melhor = new XYSeries("melhor rota");
        XYSeriesCollection dataset = new XYSeriesCollection();
//        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset.addSeries(menorAptd);
        dataset.addSeries(media);
//        dataset2.addSeries(melhor);
        for (int i = 0; i < menor.size()-1; i++) {        
            menorAptd.add(i, menor.get(i));
        }
        for (int i = 0; i < mediaAptd.size(); i++) {        
            media.add(i, mediaAptd.get(i));
        }
        
//        for(int i = 0; i < 50; i++){
//            for(int j = 0; j < 100; j++){
//                melhor.add(j, melhorIndividuo[j]);
//            }
//            System.out.println();
//
//////            aptdAcumulada += aptd[i];
////            
//////            System.out.println(aptd[i]);
//////            System.out.println("Acumulada: " + aptdAcumulada);
////            System.out.println(populacaoInicial[i]);
////
//        }

//        populacaoInicial = city.populacaoIniciar(populacaoInicial);
//        aptd = city.somaDistanciasTotal(populacaoInicial);
//        System.out.println(aptd);

//        for(int i = 0; i < 50; i++){
//            for(int j = 0; j < 100; j++){
//                System.out.print(populacaoInicial[i][j] + " ");
//            }            
//            System.out.println();
////            
//        }
        
        LineChart_AWT chart = new LineChart_AWT("Distância de rotas", "", dataset, n, melhorIndividuo);
        chart.pack( );          
        RefineryUtilities.centerFrameOnScreen( chart );          
        chart.setVisible( true ); 
//        LineChart_AWT chart2 = new LineChart_AWT("Melhor rota", "", dataset2);
//        chart2.pack( );          
//        RefineryUtilities.centerFrameOnScreen( chart2 );          
//        chart2.setVisible( true ); 
        
    }
    
}
