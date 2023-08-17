module com.bpkb.fiveinrow.client.game{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

//    exports com.bpkb.fiveinrow.client to javafx.graphics;

    opens com.bpkb.fiveinrow.client to javafx.fxml;
    exports com.bpkb.fiveinrow.client.game;
//    opens com.bpkb.fiveinrow.controllers to javafx.fxml;
}