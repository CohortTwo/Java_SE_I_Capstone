package javafxapplicationtesting;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML
    private Label Label1;


    @FXML
    private Label Label2;

    @FXML
    private TextArea TextResult;
    @FXML
    private Button button;
    @FXML
    private TextField TextInput;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String append = "";
        int x = Integer.valueOf(TextInput.getText());

//  (ternary) operator        
//        var age = 26;
//        var beverage = (age >= 21) ? "Beer" : "Juice";
//         console.log(beverage); // "Beer"

        
      //  append = append + String.valueOf(x) + " is prime? " + isPrime(x) + "\n";
      //  TextResult.setText(append);
      
        
        append = ( isPrime(x) ? (append + String.valueOf(x) + " is Prime" + "\n") : (append + String.valueOf(x) + " is not Prime" + "\n") );
        System.out.println("after append" + append) ;
        TextResult.setText(append);
        
        //append = append + String.valueOf(x) + " is odd? " + isOdd.test(x) + "\n";
        append = ( isOdd.test(x) ? (append + String.valueOf(x) + " is Odd" + "\n") : (append + String.valueOf(x) + " is Even" + "\n") );
        TextResult.setText(append);
        
        append = append + "The square of " + String.valueOf(x) + " is " + (int)(Math.pow(x,2)) + "\n";
        TextResult.setText(append);
        append = append + "The cube of " + String.valueOf(x) + " is " + (int)(Math.pow(x,3)) + "\n";
        TextResult.setText(append);
    }

    private static boolean isPrime(int number) {
    IntPredicate isDivisible = index -> number % index == 0;
    return number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
    }
    
   
    IntPredicate isOdd = index -> index % 2 == 1;  
}       
       
 
 
    

