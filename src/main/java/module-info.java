module com.example.stocksummarizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires stanford.corenlp;
    requires org.jsoup;

    opens com.example.stocksummarizer to javafx.fxml;
    exports com.example.stocksummarizer;
}