package com.laserpros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
	public static void main( String[] args ) {
		launch( args );
	}

	@Override
	public void start( Stage primaryStage ) throws Exception {
		Parent p = FXMLLoader.load( getClass().getResource( "/fxml/FlatWin.fxml" ) );

		Scene scene;

		String osName = System.getProperty( "os.name" );
		if ( osName != null && osName.startsWith( "Windows" ) ) {
			scene = ( new WindowsHack() ).getShadowScene( p );
			primaryStage.initStyle( StageStyle.TRANSPARENT );
		} else {
			scene = new Scene( p );
			primaryStage.initStyle( StageStyle.UNDECORATED );
		}

		scene.getStylesheets().add( "/css/fw.css" );

		primaryStage.setTitle( "flatwinapp" );
		primaryStage.setScene( scene );
		primaryStage.setMinHeight( 800.0d );
		primaryStage.setMinWidth( 600.0d );
		primaryStage.show();
	}

	public class WindowsHack {
		Scene getShadowScene( Parent p ) {
			Scene scene;
			VBox outer = new VBox();
			outer.getChildren().add( p );
			outer.setPadding( new Insets( 10.0d ) );
			outer.setBackground( new Background(
					new BackgroundFill( Color.rgb( 0, 0, 0, 0 ), new CornerRadii( 0 ), new Insets( 0 ) ) ) );

			p.setEffect( new DropShadow() );
			( (AnchorPane) p ).setBackground(
					new Background( new BackgroundFill( Color.WHITE, new CornerRadii( 0 ), new Insets( 0 ) ) ) );

			scene = new Scene( outer );
			scene.setFill( Color.rgb( 0, 255, 0, 0 ) );
			return scene;
		}
	}
}
