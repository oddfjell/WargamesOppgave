module Wargames {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires java.logging;

    opens WGames to javafx.fxml;
    exports WGames;
    opens WGames.Controller to javafx.fxml;
    exports WGames.Controller;

    opens TestResources to test;
    exports TestResources;

    exports WGames.Model;


}