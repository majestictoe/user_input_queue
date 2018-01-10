package edu.cse;
//import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.application.Platform;

public class Getter implements Runnable{
    String[] values;
    Queue queue;
//    private VBox labelHolder;
//    Getter(Queue q, VBox scrollyboy) {
//        queue = q;
//        labelHolder = scrollyboy;
//    }
    private Text outputBoi;
    Getter(Queue q, Text textYes){
        queue = q;
        outputBoi = textYes;
    }
    public void run(){
        Thread.currentThread().setName("GETTER Thread");

        while(true) {
            values = queue.getValues();
            while(values == null){
                Thread.currentThread().yield();
                values = queue.getValues();
            }
            System.out.println (values[0]);
 //           Platform.runLater(() -> {
                //lab.setText(values[0]);
 //           });
            //lab.setText(values[0]);
//            Label lab = new Label();
//            lab.setText(values[0]);
//            labelHolder.getChildren().add(lab);
            outputBoi.setText("You: "+values[0]+"\n"+outputBoi.getText());
            queue.finishPut();
        }
    }
}
