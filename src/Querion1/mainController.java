/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Querion1;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 *
 * @author Some fucking guy
 */
public class mainController implements Initializable {
    
    String select1 = "";
    public static String selectStatement = "";
    public static String orderBy = "ORDER BY ";
    public static String orderBy1 = "";
    public static String orderByClause = "";
    public static String groupBy = "";
    public static String joinClause1 = "";
    public static String joinClause2 = "";
    public static String whereStatement = "";
    public static String whereClause1 = "";
    public static String whereClause2 = "";
    public static String whereClauseConnection = "";
    public static String whereClause3 = "";
    public static String whereClause4 = "";
    public static String whereClauseComplete = "";
    public static String ascend = "";
    public static String descend = "";
    public static String completeQuery = "";
    public static String extractStatement = "";
    public static String extractStatement2 = "";
    public static String castStatement = "";
    public static String castStatement2 = "";

    
    //create a list of join types
    ObservableList<String> joinTypes = FXCollections.observableArrayList("", "LEFT ", "INNER ", "OUTER ");
    //create a list of where combo box stuff
    ObservableList<String> whereBox = FXCollections.observableArrayList("", " = ", " != ", " > ", " < ", " IS NULL ", " IS NOT NULL ");
    ObservableList<String> whereBoxConnector = FXCollections.observableArrayList("", " AND ", " OR ");
    ObservableList<String> exlist1 = FXCollections.observableArrayList("", "YEAR ", "MONTH ", "WEEK ", "DAY ", "HOUR ", "MINUTE ");
    
    
    
    @FXML
    private TextField col1;
    @FXML
    private TextField seldb;
    @FXML
    private TextField jcol1;
    @FXML
    private TextField jcol2;
    @FXML
    private TextField jcol3;
    @FXML
    private TextField jcol4;
    @FXML
    private TextField jcol5;
    @FXML
    private TextField jcol6;
    @FXML
    private TextField ex1;
    @FXML
    private TextField ex2;
    @FXML
    private TextField ex3;
    @FXML
    private TextField ex4;
    @FXML
    private TextField ex5;
    @FXML
    private TextField ex6;
    @FXML
    private TextField ex7;
    @FXML
    private TextField ex8;
    @FXML
    private TextField ex9;
    @FXML
    private TextField wcol1;
    @FXML
    private TextField wcol2;
    @FXML
    private TextField wcol3;
    @FXML
    private TextField wcol4;
    @FXML
    private TextField obcol1;
    @FXML
    private TextField cast1;
    @FXML
    private TextField cast2;
    @FXML
    private TextField cast3;
    @FXML
    private TextField cast4;
    @FXML
    private TextField sum1;
    @FXML
    private ComboBox cb1;
    @FXML
    private ComboBox excb1;
    @FXML
    private ComboBox excb2;
    @FXML
    private ComboBox excb3;
    @FXML
    private ComboBox excb4;
    @FXML
    private ComboBox excb5;
    @FXML
    private ComboBox excb6;
    @FXML
    private ComboBox cb2;
    @FXML
    private ComboBox wcb1;
    @FXML
    private ComboBox wcb2;
    @FXML
    private ComboBox wcb3;
    @FXML
    private RadioButton obRad1;
    @FXML
    private RadioButton obRad2;
    @FXML
    private Button executeBtn;
    
    @FXML
    private Button executeBtn2; //goodies tab
    @FXML
    private Button executeBtn3; //goodies tab
    @FXML
    private Button resetBtn;
    @FXML
    private TextArea outputBox;
    @FXML
    private TextField outputBox2;
    @FXML
    private TextField outputBox3;
    @FXML
    private TextField outputBox4; 
    @FXML
    private TextField outputBox5;
    @FXML
    private TextArea outputBox6;
    
    


    //event handler on click...?
    
    
    @FXML
    private void descendButton(ActionEvent event) {
        if (obRad2.isSelected()) {
            obRad1.setSelected(false);
        }
    }
    
    @FXML
    private void ascendButton(ActionEvent event) {

        if (obRad1.isSelected()) {
            obRad2.setSelected(false);

        }

    }
    
    @FXML
    private void handleResetButton(ActionEvent event) {
        col1.setText("");
        seldb.setText("");
        jcol1.setText("");
        jcol2.setText("");
        jcol3.setText("");
        jcol4.setText("");
        jcol5.setText("");
        jcol6.setText("");
        wcol1.setText("");
        wcol2.setText("");
        wcol3.setText("");
        wcol4.setText("");
        obcol1.setText("");
        cb1.setValue("");
        cb2.setValue("");
        wcb1.setValue("");
        wcb2.setValue("");
        wcb3.setValue("");
        obRad1.setSelected(false);
        obRad2.setSelected(false);
        outputBox.setText("");
        completeQuery = "";
        select1 = "";
        joinClause1 = "";
        joinClause2 = "";
        orderByClause="";
        whereClause1 = "";
        whereClauseConnection = "";
        whereClause2 = "";
        groupBy = "";
        seldb.setText("");
        
    }
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       completeQuery = ""; 

        //if first combo box isn't set to empty string, create a join
        if (cb1.getValue() != "" && !jcol1.getText().isEmpty()) {
           joinClause1 = "\n" + cb1.getValue() + "JOIN " + jcol1.getText() + "\nON " + jcol2.getText() + " = " + jcol3.getText() ;
           
       } 
        //if first combo box isn't set to empty string, create a join
        if (cb2.getValue() != "" && !jcol4.getText().isEmpty()) {
           joinClause2 = "\n" + cb2.getValue() + "JOIN " + jcol4.getText() + " ON " + jcol5.getText() + " = " + jcol6.getText()  ; //check these jcols
       }
        
        //if where columns not empty, create where statement
        if (!wcol1.getText().isEmpty()) {
            whereStatement = "\n" + "WHERE ";
        } else {
            whereStatement = "";
        }

        whereClause1 = whereStatement + wcol1.getText() + (String) wcb1.getValue() + wcol2.getText();

        if (wcb2.getValue() != "" && !wcol3.getText().isEmpty()) {
            whereClause2 = (String) wcb2.getValue() + wcol3.getText() + " " + (String) wcb3.getValue() + wcol4.getText();
        }

        whereClauseComplete = whereClause1 + whereClause2;
        
        
        
       
        if (!obcol1.getText().isEmpty()) {
            orderBy1 = obcol1.getText();
        }

        
        if (obRad1.isSelected()){
                ascend = " ASCENDING ";
        }
        if (obRad2.isSelected()){
                descend = " DESCENDING ";
        }

        //put the results of select query to output box
        
                
          completeQuery = ("SELECT " + col1.getText() + "\n" + "FROM "
                + seldb.getText() + joinClause1 + joinClause2 + whereClause1 + whereClauseConnection + whereClause2 + groupBy + orderByClause + ascend + descend);
          outputBox.setText(completeQuery);
        // Button was clicked, do something...  
        
        
        /* MASSIVE BUG: 
        SELECT 
        FROM 
        LEFT JOIN awd
        ON awd = awd
        ORDER BY awd, adw, awd ASCENDING 
        
        These don't clear on reset button for whatever reason... even after adding stuff to clear arraylist on reset button press
        */
    }
    
    //Goodies tab -- extract 1 functionality 
    @FXML
    private void ExecuteBtn2(ActionEvent event) {
        
        extractStatement = "EXTRACT(" + ex1.getText() + " FROM " + ex2.getText() + ") ";
        outputBox2.setText(extractStatement);  
    }
    // extract 2 functionality 
    

    
    
    @FXML
    private void ExecuteBtn3(ActionEvent event) {
        
        extractStatement2 = "EXTRACT(" + ex3.getText() + " FROM " + ex4.getText() + ") ";
        outputBox3.setText(extractStatement2);  
    }
    @FXML
    private void ExecuteBtn4(ActionEvent event) {
        
        
        outputBox4.setText("EXTRACT(" + excb1.getValue() + " FROM " + ex4.getText() + ")" );  
    }
    @FXML
    private void ExecuteBtn5(ActionEvent event) {
        
       
        outputBox5.setText("EXTRACT(" + excb2.getValue() + " FROM " + ex5.getText() + ") "
                + " + " + "EXTRACT(" + excb3.getValue() + " FROM " + ex6.getText() + ") ");  
    }
    @FXML
    private void ExecuteBtn6(ActionEvent event) {
        
        outputBox6.setText("EXTRACT(" + excb4.getValue() + " FROM " + ex7.getText() + ") "
                + " + " + "EXTRACT(" + excb5.getValue() + " FROM " + ex8.getText() + ") " 
                + " + " + "EXTRACT(" + excb6.getValue() + " FROM " + ex9.getText() + ") "
        ); 
    }
    @FXML
    private void ExecuteBtn7(ActionEvent event) {
        
        
        sum1.setText("SUM(" + sum1.getText() + ")");  
    }
    
    @FXML
    private void ClrBtn1(ActionEvent event) {
        ex1.setText("");
        ex2.setText("");
        extractStatement = "";
        outputBox2.setText("");  
    }
    @FXML
    private void ClrBtn2(ActionEvent event) {
        ex3.setText("");
        ex4.setText("");
        extractStatement = "";
        outputBox3.setText("");  
    }
    
    @FXML
    private void ClrBtn3(ActionEvent event) {
        ex3.setText("");
        ex4.setText("");
        extractStatement = "";
        outputBox3.setText("");  
    }
    @FXML
    private void ClrBtn4(ActionEvent event) {
        ex4.setText("");
        outputBox4.setText("");
        excb1.setValue("");
    }
    @FXML
    private void ClrBtn5(ActionEvent event) {
        ex5.setText("");
        ex6.setText("");
        outputBox5.setText("");  
        excb2.setValue("");
        excb3.setValue("");
    }
    
    @FXML
    private void ClrBtn6(ActionEvent event) {
        ex7.setText("");
        ex8.setText("");
        ex9.setText("");
        outputBox6.setText("");  
        excb4.setValue("");
        excb5.setValue("");
        excb6.setValue("");
    }
    @FXML
    private void ClrBtn7(ActionEvent event) {
        sum1.setText(""); 
    }
    //cast statement generator. Currently, incomplete project
   
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cb1.setItems(joinTypes);
        cb2.setItems(joinTypes);
        wcb1.setItems(whereBox);
        wcb2.setItems(whereBoxConnector);
        wcb3.setItems(whereBox);
        excb1.setItems(exlist1);
        excb2.setItems(exlist1);
        excb3.setItems(exlist1);
        excb4.setItems(exlist1);
        excb5.setItems(exlist1);
        excb6.setItems(exlist1);
        
        
        //excb2.setItems(exlist1); //doesn't yet exist so commented out
                
        //add functionality so both radio buttons can't be checked at once
        if (obRad1.isSelected()) {
            obRad2.setSelected(false);

        }
    }
}
