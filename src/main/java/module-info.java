module com.spiel.cities {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.spiel.cities to javafx.fxml;
    exports com.spiel.cities;
}