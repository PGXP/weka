/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.serpro.bilbliaia;

import java.util.logging.Level;
import java.util.logging.Logger;
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
            Instances data = source.getDataSet();
            // setting class attribute if the data format does not provide this information
            // For example, the XRFF format saves the class attribute information as well
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }
        } catch (Exception ex) {
            Logger.getLogger(Treinar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
