package com.example.stocksummarizer;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GraphicsController {
    @FXML
    public TextField searchField;

    public static Stage stage;

    public static Scene scene;

    public static FlowPane flowPane;
    public static VBox textBox;

    private static ArrayList<Article> articles = new ArrayList<>();

    @FXML
    protected void onKeyPressed(KeyEvent e) throws IOException {
        //Make sure the person is pressing enter
        if(e.getCode() == KeyCode.ENTER) {
            textBox.getChildren().removeAll();
            textBox.getChildren().clear();
            MarketWatchScraper.scrape(searchField.getText());
        }
    }

    public static void addArticle(Article article) {
        articles.add(article);
        Label title = new Label(article.getTitle());
        title.setStyle("-fx-font-weight: bold;");
        Label summary = new Label(article.getSummaryText());
        Label empty = new Label();
        title.setWrapText(true);
        summary.setWrapText(true);
        textBox.getChildren().addAll(title, summary, empty);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage2) {
        stage = stage2;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene2) {
        scene = scene2;
        textBox = new VBox();
        flowPane = (FlowPane) scene.lookup("#flowPane");
        flowPane.getChildren().add(textBox);
        textBox.prefWidthProperty().bind(flowPane.widthProperty());
    }
}