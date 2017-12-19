package edu.cse;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import java.util.Objects;

public class Main extends Application{
    public void start (Stage primaryStage) throws Exception {
        Queue queue = new Queue();
        Label question = new Label("Type something.");
        TextField input = new TextField ();
        HBox prompt = new HBox();
        prompt.getChildren().addAll(question, input);
        prompt.setSpacing(10);
        Button submit = new Button("Submit");
        Label output = new Label("");
        VBox layout = new VBox();
        layout.setSpacing(10);
        submit.setOnAction((e) -> {
            if (input.getText() != null) {
//                if (Objects.equals(input.getText(), "happy")) {
//                    output.setText("Are you as happy as a enemy conquering plant?"); }
                queue.put(input.getText());
            }
        });
        layout.getChildren().addAll(prompt,submit,output);
        Group s1 = new Group();
        s1.getChildren().addAll(layout);
        Scene scene1 = new Scene(s1,310,100);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("fvhvbkbd");
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

