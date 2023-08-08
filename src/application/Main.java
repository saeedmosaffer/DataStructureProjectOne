package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;

public class Main extends Application {
	File F1 = null;
	File F2 = null;

	
	@Override
	public void start(Stage primaryStage) {

		LinkedList LN = new LinkedList();
		GridPane root = new GridPane();
		primaryStage.setMaximized(true);
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10, 10, 10, 10));
		Image image = new Image(
				"https://1.bp.blogspot.com/-c0f7NVq2BS0/YB6FqVsGNwI/AAAAAAAAIt4/BFI2xiCK-x0pKP17YAFeMz8eUmSlQ6z-wCLcBGAsYHQ/s16000/%25D8%25A7%25D9%2584%25D8%25AE%25D8%25B7%25D9%2588%25D8%25B7-%25D8%25A7%25D9%2584%25D8%25AC%25D9%2588%25D9%258A%25D8%25A9-%25D8%25A7%25D9%2584%25D9%2581%25D9%2584%25D8%25B3%25D8%25B7%25D9%258A%25D9%2586%25D9%258A%25D8%25A9.jpg");
		ImageView imagevi4 = new ImageView();
		imagevi4.setImage(image);
		imagevi4.setFitWidth(1030);
		imagevi4.setFitHeight(550);

		Button x0 = new Button("Read data");
		Button x1 = new Button("1) Display flight information.");
		Button x2 = new Button("2) Display Passengers information for a specific flight.");
		Button x3 = new Button("3) Add/Edit flight.");
		Button x4 = new Button("4) Reserve a ticket for a specific flight.");
		Button x5 = new Button("5) Cancel a reservation.");
		Button x6 = new Button("6) Check if the ticket is reserved for a specific person.");
		Button x7 = new Button("7) Search for a passenger and print all his information.");
		Button x8 = new Button("8) Exit");

		x0.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x1.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x2.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x3.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x4.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x5.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x6.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x7.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
		x8.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");

		x1.setPrefSize(300, 100);
		x2.setPrefSize(300, 100);
		x3.setPrefSize(300, 100);
		x4.setPrefSize(300, 100);
		x5.setPrefSize(300, 100);
		x6.setPrefSize(300, 100);
		x7.setPrefSize(300, 100);
		x8.setPrefSize(300, 100);

		vb.getChildren().addAll(x0, x1, x2, x3, x4, x5, x6, x7, x8);
		root.add(imagevi4, 25, 1);
		root.add(vb, 1, 1);

		Scene scene = new Scene(root, 400, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Project");
		primaryStage.show();

		x0.setOnAction(ccv45 -> {

			Stage stage1 = new Stage();
			GridPane Gridpane1 = new GridPane();
			Gridpane1.setPadding(new Insets(20, 20, 20, 20));
			Gridpane1.setAlignment(Pos.CENTER);
			Gridpane1.setVgap(20);
			Gridpane1.setHgap(20);

			Button b1 = new Button("Read Passengers file  ");
			Button b2 = new Button("Read flight file");

			b1.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
			b2.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");

			Image image22 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView imagevi22 = new ImageView();
			imagevi22.setImage(image22);
			imagevi22.setFitWidth(15);
			imagevi22.setFitHeight(15);
			Button back1 = new Button("back", imagevi22);
			back1.setPrefSize(60, 40);
			Gridpane1.add(back1, 2, 4);

			back1.setOnAction(agrr -> {
				stage1.close();
			});

			b1.setOnAction(fff2 -> {

				readFlightsPassengers(LN, stage1);
			});

			b2.setOnAction(fff0 -> {

				readFlights(LN, stage1);
			});
			b1.setPrefSize(250, 50);
			b2.setPrefSize(250, 50);

			Gridpane1.add(b1, 2, 1);
			Gridpane1.add(b2, 2, 0);

			Scene scene1 = new Scene(Gridpane1, 500, 500);
			stage1.setScene(scene1);
			stage1.setTitle("read file");
			stage1.show();

		});

		x1.setOnAction(v059 -> {
			Stage Stage2 = new Stage();
			GridPane GridPane2 = new GridPane();
			GridPane2.setPadding(new Insets(20, 20, 20, 20));
			GridPane2.setVgap(20);
			GridPane2.setHgap(30);

			Label Label1 = new Label("Information:");

			TextArea textArea2 = new TextArea();

			Image Image1 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView ImageView1 = new ImageView();
			ImageView1.setImage(Image1);
			ImageView1.setFitWidth(15);
			ImageView1.setFitHeight(15);
			Button Button1 = new Button("back", ImageView1);
			Button1.setPrefSize(100, 40);
			GridPane2.add(Button1, 1, 3);

			Button1.setOnAction(sdfa -> {
				Stage2.close();
			});

			Image Image2 = new Image("https://img.icons8.com/office/344/print.png");
			ImageView ImageView2 = new ImageView();
			ImageView2.setImage(Image2);
			ImageView2.setFitWidth(15);
			ImageView2.setFitHeight(15);
			Button intreted1 = new Button("Print all informaton", ImageView2);
			intreted1.setPrefSize(145, 40);
			GridPane2.add(intreted1, 0, 3);

			intreted1.setOnAction(u34 -> {

				try {
					textArea2.setText(LN.printFlight());
				} catch (Exception d) {
					textArea2.setText(LN.printFlight());
				}

			});

			GridPane2.addRow(2, Label1);
			GridPane2.addRow(2, textArea2);

			Scene scene2 = new Scene(GridPane2, 800, 400);
			Stage2.setScene(scene2);
			Stage2.setTitle("print information for a flight");
			Stage2.show();

		});

		x2.setOnAction(w2 -> {

			Stage Stage3 = new Stage();
			GridPane GridPane3 = new GridPane();
			GridPane3.setPadding(new Insets(20, 20, 20, 20));
			GridPane3.setVgap(20);
			GridPane3.setHgap(30);

			Label renttext2 = new Label("Flight Number:");
			TextField textField2 = new TextField();

			TextArea textArea2 = new TextArea("Passenger information on this plane");

			Image Image4 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView ImageView4 = new ImageView();
			ImageView4.setImage(Image4);
			ImageView4.setFitWidth(15);
			ImageView4.setFitHeight(15);
			Button Button4 = new Button("back", ImageView4);
			Button4.setPrefSize(100, 40);
			GridPane3.add(Button4, 2, 5);

			Button4.setOnAction(w4 -> {
				Stage3.close();
			});

			Image n2 = new Image("https://img.icons8.com/office/344/print.png");
			ImageView nn2 = new ImageView();
			nn2.setImage(n2);
			nn2.setFitWidth(15);
			nn2.setFitHeight(15);
			Button intreted1 = new Button("Print ", nn2);
			intreted1.setPrefSize(120, 40);
			GridPane3.add(intreted1, 0, 3);

			intreted1.setOnAction(m -> {
				textArea2.setText(LN.printPassengers(Integer.parseInt(textField2.getText())));

			});

			GridPane3.addRow(1, renttext2, textField2);
			GridPane3.addRow(3, textArea2);

			Scene sceneRent2 = new Scene(GridPane3, 800, 400);
			Stage3.setScene(sceneRent2);
			Stage3.setTitle("print information for a passengers");
			Stage3.show();

		});

		x3.setOnAction(e2 -> {

			Stage Stage5 = new Stage();
			GridPane GridPane5 = new GridPane();
			GridPane5.setPadding(new Insets(20, 20, 20, 20));
			GridPane5.setAlignment(Pos.CENTER);
			GridPane5.setVgap(20);
			GridPane5.setHgap(20);

			Button b1 = new Button("Add Flight");
			Button b2 = new Button("Edit Flight");

			b1.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");
			b2.setStyle("-fx-background-color:dodgerblue;-fx-background-radius:10px");

			Image Image6 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView ImageView6 = new ImageView();
			ImageView6.setImage(Image6);
			ImageView6.setFitWidth(15);
			ImageView6.setFitHeight(15);
			Button Button6 = new Button("back", ImageView6);
			Button6.setPrefSize(60, 40);
			GridPane5.add(Button6, 2, 4);

			Button6.setOnAction(es -> {
				Stage5.close();
			});

			b1.setPrefSize(250, 50);
			b2.setPrefSize(250, 50);

			GridPane5.add(b1, 2, 0);
			GridPane5.add(b2, 2, 1);

			Scene st1 = new Scene(GridPane5, 500, 500);
			Stage5.setScene(st1);
			Stage5.setTitle("Add or Edit Flight");
			Stage5.show();

			b1.setOnAction(esrg -> {

				Stage Stageb1 = new Stage();
				GridPane GridPaneb1 = new GridPane();
				GridPaneb1.setPadding(new Insets(25, 25, 25, 25));
				GridPaneb1.setVgap(40);
				GridPaneb1.setHgap(40);

				Label FN1 = new Label("Flight Number:");
				TextField FNT1 = new TextField();

				Label AN1 = new Label("Airline Name:");
				TextField ANT1 = new TextField();

				ANT1.setDisable(true);
				FNT1.setOnKeyTyped(j -> {
					ANT1.setDisable(false);
				});

				Label SOR1 = new Label("Source:");
				TextField SORT1 = new TextField();
				SORT1.setDisable(true);
				ANT1.setOnKeyTyped(j -> {
					SORT1.setDisable(false);
				});

				Label D1 = new Label("Destination:");
				TextField DT1 = new TextField();
				DT1.setDisable(true);
				SORT1.setOnKeyTyped(j -> {
					DT1.setDisable(false);
				});

				Label C1 = new Label("Capacity:");
				TextField CT1 = new TextField();
				CT1.setDisable(true);
				DT1.setOnKeyTyped(j -> {
					CT1.setDisable(false);
				});

				GridPaneb1.addRow(0, FN1, FNT1);
				GridPaneb1.addRow(1, AN1, ANT1);
				GridPaneb1.addRow(2, SOR1, SORT1);
				GridPaneb1.addRow(3, D1, DT1);
				GridPaneb1.addRow(4, C1, CT1);

				Image i1 = new Image("https://img.icons8.com/cute-clipart/344/add.png");
				ImageView ii1 = new ImageView();
				ii1.setImage(i1);
				ii1.setFitWidth(15);
				ii1.setFitHeight(15);
				Button add1 = new Button("add", ii1);
				add1.setPrefSize(60, 50);
				GridPaneb1.add(add1, 0, 6);

				add1.setOnAction(d022 -> {

					LN.AddFlightSorted(Integer.parseInt(FNT1.getText()), ANT1.getText(), SORT1.getText(), DT1.getText(),
							Integer.parseInt(CT1.getText()));
				});

				Image c = new Image(
						"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
				ImageView cc = new ImageView();
				cc.setImage(c);
				cc.setFitWidth(15);
				cc.setFitHeight(15);
				Button ccc = new Button("back", cc);
				ccc.setPrefSize(60, 50);
				GridPaneb1.add(ccc, 1, 6);

				Scene scene2 = new Scene(GridPaneb1, 550, 500);
				Stageb1.setScene(scene2);
				Stageb1.setTitle("Add flight");
				Stageb1.show();

				ccc.setOnAction(b31 -> {
					Stageb1.close();
				});

			});

			b2.setOnAction(f23 -> {

				Stage s5 = new Stage();
				GridPane root5 = new GridPane();
				root5.setPadding(new Insets(50, 50, 50, 50));
				root5.setVgap(30);
				root5.setHgap(30);

				Label p00 = new Label("Flight Number:");
				TextField p0 = new TextField();
				Label p1 = new Label("Airline Name:");
				TextField p11 = new TextField();
				Label p2 = new Label("Source:");
				TextField p22 = new TextField();
				Label p4 = new Label("Destination:");
				TextField p44 = new TextField();
				Label p33 = new Label("Capacity:");
				TextField p3 = new TextField();

				root5.addRow(0, p00, p0);
				root5.addRow(1, p1, p11);
				root5.addRow(2, p2, p22);
				root5.addRow(3, p4, p44);
				root5.addRow(4, p33, p3);

				Image image51 = new Image(
						"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-search-alignment-and-tools-kiranshastry-gradient-kiranshastry.png");
				ImageView imagevi51 = new ImageView();
				imagevi51.setImage(image51);
				imagevi51.setFitWidth(15);
				imagevi51.setFitHeight(15);
				Button Search = new Button("Search", imagevi51);
				Search.setPrefSize(80, 40);
				root5.add(Search, 1, 5);

				Search.setOnAction(d699 -> {

					p0.setEditable(false);
					Flight c44 = LN.SearchFlight(Integer.parseInt(p0.getText()));

					p11.setText(c44.getAirlineName());
					p22.setText(c44.getSource());
					p44.setText(c44.getDestination());
					p3.setText(String.valueOf(c44.getCapacity()));

				});

				Image image41 = new Image("https://img.icons8.com/cotton/344/loop.png");
				ImageView imagevi41 = new ImageView();
				imagevi41.setImage(image41);
				imagevi41.setFitWidth(15);
				imagevi41.setFitHeight(15);
				Button Update = new Button("Update", imagevi41);
				Update.setPrefSize(80, 40);
				root5.add(Update, 2, 5);

				Update.setOnAction(d93 -> {

					LN.EditFlight(Integer.parseInt(p0.getText()), p11.getText(), p22.getText(), p44.getText(),
							Integer.parseInt(p3.getText()));
				});

				Image image52 = new Image(
						"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
				ImageView imagevi52 = new ImageView();
				imagevi52.setImage(image52);
				imagevi52.setFitWidth(15);
				imagevi52.setFitHeight(15);
				Button back4 = new Button("back", imagevi52);
				back4.setPrefSize(80, 40);
				root5.add(back4, 0, 5);

				Scene scene5 = new Scene(root5, 500, 450);
				s5.setScene(scene5);
				s5.setTitle("Edit flight");
				s5.show();

				back4.setOnAction(b3 -> {
					s5.close();
				});

			});

		});

		x4.setOnAction(rr4 -> {

			Stage s2 = new Stage();
			GridPane root2 = new GridPane();
			root2.setPadding(new Insets(25, 25, 25, 25));
			root2.setVgap(40);
			root2.setHgap(40);

			Label FlightNumber1 = new Label("Flight Number:");
			TextField FlightNumberTex1 = new TextField();

			Label TicketNumber1 = new Label("Ticket Number:");
			TextField TicketNumberTex1 = new TextField();
			TicketNumberTex1.setDisable(true);
			FlightNumberTex1.setOnKeyTyped(j -> {
				TicketNumberTex1.setDisable(false);
			});

			Label FullName1 = new Label("Full Name:");
			TextField FullNameText1 = new TextField();
			FullNameText1.setDisable(true);
			TicketNumberTex1.setOnKeyTyped(j -> {
				FullNameText1.setDisable(false);
			});

			Label passportNumber1 = new Label("Passport Number:");
			TextField passportNumberTex1 = new TextField();
			passportNumberTex1.setDisable(true);
			FullNameText1.setOnKeyTyped(j -> {
				passportNumberTex1.setDisable(false);
			});

			Label Nationality1 = new Label("Nationality:");
			TextField NationalityTex1 = new TextField();
			NationalityTex1.setDisable(true);
			passportNumberTex1.setOnKeyTyped(j -> {
				NationalityTex1.setDisable(false);
			});

			Label birthDate1 = new Label("birth Date:");
			TextField birthDate1Tex1 = new TextField();
			birthDate1Tex1.setDisable(true);
			NationalityTex1.setOnKeyTyped(j -> {
				birthDate1Tex1.setDisable(false);
			});

			root2.addRow(0, FlightNumber1, FlightNumberTex1);
			root2.addRow(1, TicketNumber1, TicketNumberTex1);
			root2.addRow(2, FullName1, FullNameText1);
			root2.addRow(3, passportNumber1, passportNumberTex1);
			root2.addRow(4, Nationality1, NationalityTex1);
			root2.addRow(5, birthDate1, birthDate1Tex1);

			Image i1 = new Image("https://img.icons8.com/cute-clipart/344/add.png");
			ImageView ii1 = new ImageView();
			ii1.setImage(i1);
			ii1.setFitWidth(15);
			ii1.setFitHeight(15);
			Button add1 = new Button("add", ii1);
			add1.setPrefSize(60, 50);
			root2.add(add1, 0, 6);

			add1.setOnAction(d77800 -> {

				LN.AddPassengersSorted(Integer.parseInt(FlightNumberTex1.getText()),
						Integer.parseInt(TicketNumberTex1.getText()), FullNameText1.getText(),
						passportNumberTex1.getText(), NationalityTex1.getText(), birthDate1Tex1.getText());
			});

			Image image22 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView imagevi22 = new ImageView();
			imagevi22.setImage(image22);
			imagevi22.setFitWidth(15);
			imagevi22.setFitHeight(15);
			Button bb = new Button("back", imagevi22);
			bb.setPrefSize(60, 50);
			root2.add(bb, 1, 6);

			Scene scene2 = new Scene(root2, 550, 500);
			s2.setScene(scene2);
			s2.setTitle("Reserve a ticket for a specific flight");
			s2.show();

			bb.setOnAction(b1 -> {
				s2.close();
			});

		});

		x5.setOnAction(k6791 -> {

			Stage v2 = new Stage();
			GridPane GP2 = new GridPane();
			GP2.setPadding(new Insets(50, 50, 50, 50));
			GP2.setVgap(30);
			GP2.setHgap(30);

			Label FlightNumber2 = new Label("Flight Number:");
			TextField FlightNumberTex2 = new TextField();

			Label FullName2 = new Label("Full Name:");
			TextField FullName2Tex2 = new TextField();

			GP2.addRow(0, FlightNumber2, FlightNumberTex2);
			GP2.addRow(1, FullName2, FullName2Tex2);

			Image G1 = new Image(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-delete-multimedia-kiranshastry-gradient-kiranshastry.png");
			ImageView GG1 = new ImageView();
			GG1.setImage(G1);
			GG1.setFitWidth(15);
			GG1.setFitHeight(15);
			Button D2 = new Button("delete", GG1);
			D2.setPrefSize(80, 40);
			GP2.add(D2, 0, 4);

			D2.setOnAction(d678971 -> {

				LN.deletPassenger(Integer.parseInt(FlightNumberTex2.getText()), FullName2Tex2.getText());
			});

			Image b1 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView bb1 = new ImageView();
			bb1.setImage(b1);
			bb1.setFitWidth(15);
			bb1.setFitHeight(15);
			Button backG2 = new Button("back", bb1);
			backG2.setPrefSize(80, 40);
			GP2.add(backG2, 1, 4);

			backG2.setOnAction(k3 -> {
				v2.close();
			});

			Scene sceneGame2 = new Scene(GP2, 500, 450);
			v2.setScene(sceneGame2);
			v2.setTitle("Cancel a reservation");
			v2.show();

		});

		x7.setOnAction(e4 -> {

			Stage rentStage2 = new Stage();
			GridPane rentpane2 = new GridPane();
			rentpane2.setPadding(new Insets(20, 20, 20, 20));
			rentpane2.setVgap(20);
			rentpane2.setHgap(30);

			Label renttext2 = new Label("Full name passenger:");
			TextField textField2 = new TextField();

			TextArea textArea2 = new TextArea(" information for a passengers");

			Image n1 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView nn1 = new ImageView();
			nn1.setImage(n1);
			nn1.setFitWidth(15);
			nn1.setFitHeight(15);
			Button backre2 = new Button("back", nn1);
			backre2.setPrefSize(100, 40);
			rentpane2.add(backre2, 2, 5);

			backre2.setOnAction(w4 -> {
				rentStage2.close();
			});

			Image n2 = new Image(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-search-alignment-and-tools-kiranshastry-gradient-kiranshastry.png");
			ImageView nn2 = new ImageView();
			nn2.setImage(n2);
			nn2.setFitWidth(15);
			nn2.setFitHeight(15);
			Button intreted1 = new Button("Search", nn2);
			intreted1.setPrefSize(120, 40);
			rentpane2.add(intreted1, 0, 3);

			intreted1.setOnAction(m -> {

				textArea2.setText(LN.serchPassenger(textField2.getText()));

			});

			rentpane2.addRow(1, renttext2, textField2);
			rentpane2.addRow(3, textArea2);

			Scene sceneRent2 = new Scene(rentpane2, 800, 400);
			rentStage2.setScene(sceneRent2);
			rentStage2.setTitle("print information for a passengers");
			rentStage2.show();

		});

		x6.setOnAction(w982 -> {

			Stage rentStage2 = new Stage();
			GridPane rentpane2 = new GridPane();
			rentpane2.setPadding(new Insets(20, 20, 20, 20));
			rentpane2.setVgap(20);
			rentpane2.setHgap(30);

			Label renttext2 = new Label("Flight Number:");
			TextField textField2 = new TextField();

			Label renttext3 = new Label("Full name:");
			TextField textField3 = new TextField();

			TextArea textArea2 = new TextArea("true or false");

			Image n1 = new Image(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png");
			ImageView nn1 = new ImageView();
			nn1.setImage(n1);
			nn1.setFitWidth(15);
			nn1.setFitHeight(15);
			Button backre2 = new Button("back", nn1);
			backre2.setPrefSize(100, 40);
			rentpane2.add(backre2, 2, 5);

			backre2.setOnAction(w894 -> {
				rentStage2.close();
			});

			Image n2 = new Image("https://img.icons8.com/office/344/print.png");
			ImageView nn2 = new ImageView();
			nn2.setImage(n2);
			nn2.setFitWidth(15);
			nn2.setFitHeight(15);
			Button intreted1 = new Button("Check", nn2);
			intreted1.setPrefSize(80, 40);
			rentpane2.add(intreted1, 0, 4);

			intreted1.setOnAction(f99er -> {
				boolean x = LN.cheakPerson(Integer.parseInt(textField2.getText()), textField3.getText());
				textArea2.setText(String.valueOf(x));
			});

			rentpane2.addRow(1, renttext2, textField2);
			rentpane2.addRow(2, renttext3, textField3);
			rentpane2.addRow(4, textArea2);

			Scene sceneRent2 = new Scene(rentpane2, 800, 400);
			rentStage2.setScene(sceneRent2);
			rentStage2.setTitle("Check whether a ticket is reserved for a particular person");
			rentStage2.show();

		});

		x8.setOnAction(w1341 -> {

			primaryStage.close();
		});

	}

	private void readFlightsPassengers(LinkedList L, Stage stage) {

		FileChooser FI1 = new FileChooser();
		F1 = FI1.showOpenDialog(stage);
		Scanner input;

		String[] string = new String[6];
		try {
			input = new Scanner(F1);
			while (input.hasNextLine()) {
				string = input.nextLine().split(",");
				L.AddPassengersSorted(Integer.parseInt(string[0].trim()), Integer.parseInt(string[1].trim()),
						string[2].trim(), string[3].trim(), string[4].trim(), string[5].trim());
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	private void readFlights(LinkedList L, Stage stage) {

		FileChooser FI2 = new FileChooser();
		F2 = FI2.showOpenDialog(stage);
		Scanner in;
		String[] string = new String[5];
		try {
			in = new Scanner(F2);
			while (in.hasNextLine()) {
				string = in.nextLine().split(",");

				L.AddFlightSorted(Integer.parseInt(string[0].trim()), string[1].trim(), string[2].trim(),
						string[3].trim(), Integer.parseInt(string[0].trim()));
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}