package edu.cse;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
    static Queue _queue;
    //static Label _output;
    static ScrollPane _scroll;
    static VBox _labelHolder;
    public void start (final Stage primaryStage) {
        Thread.currentThread().setName("GUI Thread");
        Label question = new Label("Type something.");
        TextField input = new TextField ();
        HBox prompt = new HBox();
        Button submit = new Button("Submit");
        VBox layout = new VBox();

        prompt.setSpacing(10);
        layout.setSpacing(10);
        submit.setOnAction((e) -> {
            if (input.getText() != "") {
                boolean didPut = _queue.put(input.getText());
                while (!didPut) {
                    Thread.currentThread().yield();
                    _queue.put(input.getText());
                }
            }
        });
        prompt.getChildren().addAll(question, input);
        layout.getChildren().addAll(prompt,submit,_scroll);
        Group s1 = new Group();
        s1.getChildren().addAll(layout);
        Scene scene1 = new Scene(s1,310,100);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("fvhvbkbd");
        primaryStage.show();

    }
    public static void main(String[] args) {
        //_output = new Label("bjhbh");
        _queue = new Queue();
        _labelHolder = new VBox();
        _scroll = new ScrollPane();
        _scroll.setContent(_labelHolder);
        _scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        _scroll.fitToWidthProperty();
        Getter myGetter = new Getter(_queue, _labelHolder);
        Thread getterThread = new Thread(myGetter);
        getterThread.start();

        Application.launch(args);
    }
}

