/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculatorfxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import simplecalculatorfxapp.SimpleCalculator;

/**
 * FXML Controller class
 *
 * @author chiangyong
 */
public class FXMLSimpleCalculatorController implements Initializable {
    
    SimpleCalculator sCal = new SimpleCalculator();
    private String dispStr;
    private String tempStr = "0";
  
    boolean operatorFlag = false;
    boolean equalFlag = false;
    double result = 0;
   
    @FXML
    private Button clearBtn;
    @FXML
    private Button sevenBtn;
    @FXML
    private Button ceBtn;
    @FXML
    private Button bsBtn;
    @FXML
    private Button divBtn;
    @FXML
    private Button fourBtn;
    @FXML
    private Button oneBtn;
    @FXML
    private Button zeroBtn;
    @FXML
    private Button eightBtn;
    @FXML
    private Button nineBtn;
    @FXML
    private Button mulBtn;
    @FXML
    private Button fiveBtn;
    @FXML
    private Button sixBtn;
    @FXML
    private Button subBtn;
    @FXML
    private Button twoBtn;
    @FXML
    private Button threeBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button plusminusBtn;
    @FXML
    private Button dotBtn;
    @FXML
    private Button equalBtn;
    @FXML
    private TextField dispText;
    @FXML
    private Label lblTitle;

    @FXML
    public void btnOne()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
        tempStr += disp("1");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnTwo()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
         tempStr += disp("2");
         operatorFlag = false;
         equalFlag = false;
    }
    
    @FXML
    public void btnThree()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
        tempStr += disp("3");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnFour()
    {
       if(operatorFlag || equalFlag)
            dispText.setText(""); 
       tempStr += disp("4");
       operatorFlag = false;
        equalFlag = false;
    }
    @FXML
    public void btnFive()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
        tempStr += disp("5");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnSix()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
        tempStr += disp("6");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnSeven()
    {
        if(operatorFlag || equalFlag)
            dispText.setText(""); 
        tempStr += disp("7");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnEight()
    {
        if(operatorFlag || equalFlag)
            dispText.setText(""); 
        tempStr += disp("8");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnNine()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
        tempStr += disp("9");
        operatorFlag = false;
        equalFlag = false;
    }
    @FXML
    public void btnZero()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
        tempStr += disp("0");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnDot()
    {
        if(operatorFlag || equalFlag)
            dispText.setText("");
        disp(".");
        operatorFlag = false;
        equalFlag = false;
    }
    
    @FXML
    public void btnPlusMinus()
    {
        dispStr = dispText.getText();
        if(dispStr.substring(0,1).equals("-"))
        {
            dispStr=dispStr.substring(1, dispStr.length());
            dispText.setText(dispStr);
        }
        else
        {
            dispText.setText("-"+dispStr);
        }
    }
    @FXML
    public void btnAdd()
    {
        if(equalFlag)
            tempStr += dispText.getText();
        dispOp("+");
        
    }
    
    @FXML
    public void btnSub()
    {
        if(equalFlag)
            tempStr +=dispText.getText();
        dispOp("-");
     
    }
    
    @FXML
    public void btnDiv()
    {
        if(equalFlag)
           tempStr += dispText.getText();
        dispOp("/");
        
    }
    
    @FXML
    public void btnMul()
    {
        if(equalFlag)
           tempStr += dispText.getText();
        dispOp("x");
        
    }
    
    @FXML
    public void btnEqual()
    {
             
        if(!equalFlag)       //disallow subsequent equal button pressed
        {
//            if(operatorFlag)
//            {
                System.out.println("Operator Flag : "+operatorFlag);
                tempStr = tempStr.substring(0, tempStr.length()-1); //remove the last operator
                tempStr += dispText.getText();
               System.out.println("tempStr = " + tempStr);
                result = sCal.evaluateExp(tempStr);
                
                if(sCal.errMsg.isEmpty())
                {
                    dispText.setText(String.format("%.1f", result));
                }
                else
                    dispText.setText(sCal.errMsg);
                
//            }
        }
      
        tempStr = "0";
        dispStr = "";
        equalFlag = true;
    }
    

    
    public String disp(String inpText) {
        dispStr = dispText.getText();
       
        System.out.println(dispStr);

        if (dispStr.length() < 12) {
            if (inpText.equals(".")) {                       //Check if dot or decimal is initial pressed
                if (dispStr.equals("0")||dispStr.isEmpty()) {
                    dispStr = "0.";
                    dispText.setText(dispStr);            //then need to add "0."

                } else if (!sCal.isInStr(dispStr, '.')) //else add a decimal to the "xxx.xx"
                {
                    dispStr = dispStr + ".";
                    dispText.setText(dispStr);
                }
            } else {
                if (dispStr.equals("0")||dispStr.isEmpty()) {
                    dispStr = inpText;
                    dispText.setText(dispStr);
                    return dispStr;
                } else {
                    dispStr = dispText.getText() + inpText;
                    dispText.setText(dispStr);
                }
            }
        }
        return dispText.getText();
    }
    
    
    private void dispOp(String ops)
    {
        
        if(!operatorFlag)
        {   
           // System.out.println("Operator Flag in dispOp = " + operatorFlag);
            tempStr += ops;
            operatorFlag = true;
            equalFlag = false;
        }
    }
    
    
    @FXML
    public void btnClear()
    {
        tempStr = "";
        dispText.setText("0");
        
    }
    
    @FXML
    public void btnClearEntry()
    {
        dispStr = dispText.getText();
        
        if(!tempStr.isEmpty())
            dispStr = "0";
        
        dispText.setText(dispStr);
    }
    
    @FXML
    public void btnBackSpace()
    {
        String str = dispText.getText();
        if(!str.isEmpty()&&str.length()>1)
        {
            dispStr = str.substring(0,str.length()-1);
            
        }
        else
        {
            dispStr = "0";
        }
        dispText.setText(dispStr);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getDispText() {
        return dispText;
    }

    public void setDispText(TextField dispText) {
        this.dispText = dispText;
    }

    @Override
    public String toString() {
        return "FXMLSimpleCalculatorController{" + "dispText=" + dispText + '}';
    }
    
    
    
}
