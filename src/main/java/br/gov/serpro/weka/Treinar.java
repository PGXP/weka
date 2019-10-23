/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.serpro.weka;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author 70744416353
 */
public class Treinar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            DataSource source = new DataSource("feira.arff");
            Instances traindata = source.getDataSet();
            traindata.setClassIndex(traindata.numAttributes() - 1);

            SimpleKMeans kmeans = new SimpleKMeans();
            kmeans.setNumClusters(8);
            kmeans.buildClusterer(traindata);

            ClusterEvaluation eval = new ClusterEvaluation();
            eval.setClusterer(kmeans);
            eval.evaluateClusterer(traindata);
            System.out.println(eval.clusterResultsToString());

        } catch (Exception ex) {
            Logger.getLogger(Treinar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
