module com.bpkb.fiveinrow.client.game{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires atlantafx.base;

    exports com.bpkb.fiveinrow.client to javafx.graphics;


    opens com.bpkb.fiveinrow.client to javafx.fxml;
    opens com.bpkb.fiveinrow.client.game to javafx.fxml;
    opens com.bpkb.fiveinrow.client.game.controllers to javafx.fxml;
    exports com.bpkb.fiveinrow.client.game;
    exports com.bpkb.fiveinrow.client.game.controllers;

}