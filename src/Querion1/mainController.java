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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.objects.NativeRegExp.test;



/**
 *
 * @author Some fucking guy
 */
public class mainController implements Initializable {
    
    String select1 = "";
    public static String selectStatement = "";
    public static String orderByList = "";
    public static String orderBy = "ORDER BY ";
    public static String orderBy1 = "";
    public static String orderBy2 = "";
    public static String orderByClause = "";
    public static String groupByList = "";
    public static String groupBy1 = "";
    public static String groupBy2 = "";
    public static String groupBy3 = "";
    public static String groupBy4 = "";
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

    //array list for the select statement
    ArrayList<String> columnlist = new ArrayList<String>();
    //array list for the group by and order by
    ArrayList<String> gblist = new ArrayList<String>();
    ArrayList<String> oblist = new ArrayList<String>();
    //create a list of join types
    ObservableList<String> joinTypes = FXCollections.observableArrayList("", "LEFT ", "INNER ", "OUTER ");
    //create a list of where combo box stuff
    ObservableList<String> whereBox = FXCollections.observableArrayList("", " = ", " != ", " > ", " < ", " IS NULL ", " IS NOT NULL ");
    ObservableList<String> whereBoxConnector = FXCollections.observableArrayList("", " AND ", " OR ");
    
    @FXML
    private TextField col1;
    @FXML
    private TextField col2;
    @FXML
    private TextField col3;
    @FXML
    private TextField col4;
    @FXML
    private TextField seldb;
    @FXML
    private TextField seltable;
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
    private TextField obcol2;
    @FXML
    private TextField obcol3;
    @FXML
    private TextField cast1;
    @FXML
    private TextField cast2;
    @FXML
    private TextField cast3;
    @FXML
    private TextField cast4;
    @FXML
    private ComboBox cb1;
    @FXML
    private ComboBox cb2;
    @FXML
    private ComboBox wcb1;
    @FXML
    private ComboBox wcb2;
    @FXML
    private ComboBox wcb3;
    @FXML
    private CheckBox gb1;
    @FXML
    private CheckBox gb2;
    @FXML
    private CheckBox gb3;
    @FXML
    private CheckBox gb4;
    @FXML
    private RadioButton obRad1;
    @FXML
    private RadioButton obRad2;
    @FXML
    private Button executeBtn;
    @FXML
    private Button clrBtn1;
    @FXML
    private Button clrBtn2;
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
        col2.setText("");
        col3.setText("");
        col4.setText("");
        seldb.setText("");
        seltable.setText("");
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
        obcol2.setText("");
        obcol3.setText("");
        cb1.setValue("");
        cb2.setValue("");
        wcb1.setValue("");
        wcb2.setValue("");
        wcb3.setValue("");
        gb1.setSelected(false);
        gb2.setSelected(false);
        gb3.setSelected(false);
        gb4.setSelected(false);
        obRad1.setSelected(true);
        obRad2.setSelected(false);
        outputBox.setText("");
        columnlist.clear();
        gblist.clear();
        oblist.clear();
        completeQuery = "";
        select1 = "";
        joinClause1 = "";
        joinClause2 = "";
        groupByList = "";
        orderByList = ""; 
        orderByClause="";
        whereClause1 = "";
        whereClauseConnection = "";
        whereClause2 = "";
        groupBy = "";
        
    }
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       completeQuery = ""; 
       columnlist.clear();
       gblist.clear();
       oblist.clear();
       //check each select field, and if it's not empty, add it to the array list
       if (!col1.getText().isEmpty()) {
           columnlist.add(col1.getText());
       }

       if (!col2.getText().isEmpty()) {
           columnlist.add(col2.getText());
       }
       if (!col3.getText().isEmpty()) {
           columnlist.add(col3.getText());
       }

       if (!col4.getText().isEmpty()) {
           columnlist.add(col4.getText());
       }
       //join together all non-empty columns, separate by column
       select1 = String.join(", ", columnlist);
        
        
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

        if (gb1.isSelected() && !col1.getText().isEmpty()) {
            gblist.add(col1.getText());
        }
        if (gb2.isSelected() && !col2.getText().isEmpty()) {
            gblist.add(col2.getText());
        }
        if (gb3.isSelected() && !col3.getText().isEmpty()) {
            gblist.add(col3.getText());
        }
        if (gb4.isSelected() && !col4.getText().isEmpty()) {
            gblist.add(col4.getText());
        }
        groupByList = String.join(", ", gblist);
        
        //if group by is selected but col empty, will not allow it
        if ((gb1.isSelected() && !col1.getText().isEmpty()) || (gb2.isSelected() && !col2.getText().isEmpty())
                || (gb3.isSelected() && !col3.getText().isEmpty()) || (gb4.isSelected() && !col4.getText().isEmpty())) {
            groupBy = "\n" + "GROUP BY ";
        }
        
        
        
       
        if (!obcol1.getText().isEmpty()) {
            oblist.add(obcol1.getText());
        }

        if (!obcol2.getText().isEmpty()) {
            oblist.add(obcol2.getText());
        }

        if (!obcol3.getText().isEmpty()) {
            oblist.add(obcol3.getText());
        }

        orderByList = String.join(", ", oblist);

        //if any of the order by fields not empty, should be an order By statement. Otherwise, nope
        //so for instance, if there's just one item in the Order By list, it'll output that one item
        if (!obcol1.getText().isEmpty() || !obcol2.getText().isEmpty() || !obcol3.getText().isEmpty()) {
            orderByClause = "\n" + "ORDER BY " + orderByList;
        }
        
        if (obRad1.isSelected()){
                ascend = " ASCENDING ";
        }
        if (obRad2.isSelected()){
                descend = " DESCENDING ";
        }

        //put the results of select query to output box
        
                
          completeQuery = ("SELECT " + select1 + "\n" + "FROM "
                + seltable.getText() + joinClause1 + joinClause2 + whereClause1 + whereClauseConnection + whereClause2 + groupBy + groupByList + orderByClause + ascend + descend);
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
    private void ClrBtn1(ActionEvent event) {
        ex1.setText("");
        ex2.setText("");
        extractStatement = "";
        outputBox2.setText("");  
    }
    
    
    
    
    
    @FXML
    private void ExecuteBtn3(ActionEvent event) {
        
        extractStatement2 = "EXTRACT(" + ex3.getText() + " FROM " + ex4.getText() + ") ";
        outputBox3.setText(extractStatement2);  
    }
    @FXML
    private void ClrBtn2(ActionEvent event) {
        ex3.setText("");
        ex4.setText("");
        extractStatement = "";
        outputBox3.setText("");  
    }
    //cast statement generator. Currently, incomplete project
    @FXML
    private void ExecuteBtn4(ActionEvent event) {
        
          
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cb1.setItems(joinTypes);
        cb2.setItems(joinTypes);
        wcb1.setItems(whereBox);
        wcb2.setItems(whereBoxConnector);
        wcb3.setItems(whereBox);
        
                
        //add functionality so both radio buttons can't be checked at once
        if (obRad1.isSelected()) {
            obRad2.setSelected(false);

        }
    }
}
