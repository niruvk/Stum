package com.example.stocksummarizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Graphics extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //nlpPipeline.init();
        FXMLLoader fxmlLoader = new FXMLLoader(Graphics.class.getResource("graphics-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 700);
        stage.setTitle("Stock Summarizer");
        stage.setScene(scene);
        stage.show();

        GraphicsController.setStage(stage);
        GraphicsController.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}



//Hey sisters!