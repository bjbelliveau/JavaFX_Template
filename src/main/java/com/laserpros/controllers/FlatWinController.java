package com.laserpros.controllers;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class FlatWinController implements Initializable {

	public HBox title;

	private double _xOffset = 0;
	private double _yOffset = 0;

	private Stage _stage;

	@Override
	public void initialize( URL location, ResourceBundle resources ) {
		Platform.runLater( () -> _stage = (Stage) title.getScene().getWindow() );

		title.setOnMousePressed( event -> {
			_xOffset = event.getSceneX();
			_yOffset = event.getSceneY();
		} );

		title.setOnMouseDragged( event -> {
			_stage.setX( event.getScreenX() - _xOffset );
			_stage.setY( event.getScreenY() - _yOffset );
		} );
	}

	public void close( MouseEvent mouseEvent ) {
		System.out.println( "Close" );

		_stage.hide();
	}
}