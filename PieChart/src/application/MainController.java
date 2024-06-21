/********************************************************************************************
 *   COPYRIGHT (C) 2022 TONAL INC
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without  written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  This below code set's the attribute value  for pie-chart partitions. 
 *   Project:  Pie-Chart
 *   Platform: JavaSE-22.0.1
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	 Version: 2024-03 (4.31.0)
 *   Build id: 20240307-1437 
 *********************************************************************************************/



package application;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler; 

public class MainController {
    @FXML
    private PieChart piechart;
    
    @FXML
    private Label status;
    
    @FXML
    public void btn(ActionEvent event) {
        ObservableList<Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Java", 80),
                new PieChart.Data("Python", 20),
                new PieChart.Data("C++", 30),
                new PieChart.Data("JavaScript", 40),
                new PieChart.Data("SQL", 50)
        );
        piechart.setData(list);
        
        for (final PieChart.Data data : piechart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                
            	@Override
                public void handle(MouseEvent event) {
                    status.setText(String.valueOf(data.getPieValue()) + " %");
                }
            });
        }
    }
}
