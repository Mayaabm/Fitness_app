module Stronger {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
