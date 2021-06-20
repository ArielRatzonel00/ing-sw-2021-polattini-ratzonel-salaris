package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Network.Client.UserInterface;
import it.polimi.ingsw.Network.Messages.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

/*
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

 */

public class GUI extends Application implements UserInterface {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    Stage window;
    Scene play_scene, login_scene, single_multi_scene, how_many_scene,  waiting_scene, discard_scene;
    Button play_button, login_button, single_multi_button, startgame_button;
    Scanner scanner;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        window = primaryStage;
        window.setTitle("Masters_of_Renaissance");

        // -- scena titolo --
        Label masters = new Label("Welcome to Masters of Renaissance");
        play_button = new Button("PLAY!");
        //play_button.setOnAction();

        //Vbox -> children are laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(masters, play_button);
        layout1.setAlignment(Pos.CENTER);
        play_scene = new Scene(layout1, WIDTH, HEIGHT);

        window.setScene(play_scene);
        window.show();

    }

    @Override
    public void Waiting(Scanner scanner) {
        StackPane layout4 = new StackPane();
        Label waiting_label = new Label("Waiting for other players ...");
        layout4.getChildren().addAll(waiting_label);
        layout4.setAlignment(Pos.CENTER);
        waiting_scene = new Scene(layout4, WIDTH, HEIGHT);
        window.setScene(waiting_scene);
    }

    @Override
    public boolean askMultiplayer(Scanner scanner) {
        GridPane layout3 = new GridPane();
        layout3.setPadding(new Insets(100,100,100,100));
        layout3.setVgap(8);
        layout3.setHgap(20);

        Label sing_multi = new Label("Would you play SinglePlayer or MultiPlayer?");
        GridPane.setConstraints(sing_multi, 0,0);

        ToggleGroup single_multi_group = new ToggleGroup();
        RadioButton single_button = new RadioButton("SinglePlayer");
        single_button.setToggleGroup(single_multi_group);
        GridPane.setConstraints(single_button, 1,0);
        RadioButton multi_button = new RadioButton("MultiPlayer");
        multi_button.setToggleGroup(single_multi_group);
        GridPane.setConstraints(multi_button, 2,0);

        single_multi_button = new Button("NEXT ->");
        GridPane.setConstraints(single_multi_button, 1,1);
        single_multi_button.setOnAction( e -> {
            if (single_multi_group.getSelectedToggle() == single_button) {
                System.out.println("SINGLEPLAYER GAME"); //
            } else {
                if (single_multi_group.getSelectedToggle() == multi_button) {
                    System.out.println("MULTIPLAYER GAME"); //
                } else {
                    System.out.println("NO SELECTION"); //
                }
            }
        });

        layout3.getChildren().addAll(sing_multi, single_button,multi_button, single_multi_button);
        layout3.setAlignment(Pos.CENTER);
        single_multi_scene = new Scene(layout3, WIDTH,HEIGHT);
        window.setScene(single_multi_scene);


        return false; //deve tornare qualcosa
    }


    @Override
    public String askNickname(Scanner scanner) {
        GridPane layout2 = new GridPane();
        layout2.setPadding(new Insets(100,100,100,100));
        layout2.setVgap(8);
        layout2.setHgap(10);
        Label nickname_label = new Label("Nickname:");
        GridPane.setConstraints(nickname_label, 0,0);
        TextField nicknameInput = new TextField();
        nicknameInput.setPromptText("nickname");
        GridPane.setConstraints(nicknameInput,1,0);

        login_button = new Button("LOG IN");
        GridPane.setConstraints(login_button, 1,2);

        layout2.getChildren().addAll(nickname_label, nicknameInput, login_button);
        layout2.setAlignment(Pos.CENTER);
        login_scene = new Scene(layout2, WIDTH,HEIGHT);
        window.setScene(login_scene);

        login_button.setOnAction(e -> {
            String name = nicknameInput.getText().toString();
            System.out.println(name); //
        });

        return null; //devo tornare il nickname
    }

    @Override
    public int askNumberOfPlayers(Scanner scanner) {
        GridPane layout4 = new GridPane();
        layout4.setPadding(new Insets(100,100,100,100));
        layout4.setVgap(8);
        layout4.setHgap(20);

        Label how_many = new Label("How many players in the game?");
        GridPane.setConstraints(how_many, 0,0);

        ToggleGroup howmany_group = new ToggleGroup();
        RadioButton two_button = new RadioButton("TWO");
        two_button.setToggleGroup(howmany_group);
        GridPane.setConstraints(two_button, 1,0);
        RadioButton three_button = new RadioButton("THREE");
        three_button.setToggleGroup(howmany_group);
        GridPane.setConstraints(three_button, 2,0);
        RadioButton four_button = new RadioButton("FOUR");
        four_button.setToggleGroup(howmany_group);
        GridPane.setConstraints(four_button, 3,0);

        startgame_button = new Button("START GAME!");
        GridPane.setConstraints(startgame_button, 1,1);
        startgame_button.setOnAction( e -> {
            if (howmany_group.getSelectedToggle() == two_button) {
                System.out.println("TWO PLAYERS"); //
            } else {
                if (howmany_group.getSelectedToggle() == three_button) {
                    System.out.println("THREE PLAYERS"); //
                } else {
                    if (howmany_group.getSelectedToggle() == four_button) {
                        System.out.println("FOUR PLAYERS"); //
                    } else{
                        System.out.println("NO SELECTION"); //
                    }
                }
            }
        });

        layout4.getChildren().addAll(how_many, startgame_button, two_button, three_button, four_button);
        layout4.setAlignment(Pos.CENTER);
        how_many_scene = new Scene(layout4, WIDTH, HEIGHT);
        window.setScene(how_many_scene);

        return 0; //
    }

    @Override
    public FourLeaderCardsMessage FourLeaderCards(Scanner scanner) {
        FourLeaderCardsMessage fourLeaderCardsMessage = new FourLeaderCardsMessage();
        return fourLeaderCardsMessage;
    }

    @Override
    public void DiscardInitialLeaderCards(Scanner scanner, ArrayList<LeaderCard> leaderCards, DiscardInitialLeaderCardsMessage discardInitialLeaderCardsMessage){
        int cont = 0;

        GridPane layout5 = new GridPane();
        layout5.setPadding(new Insets(100,100,100,100));
        layout5.setVgap(8);
        layout5.setHgap(20);

        Label discard_label = new Label("Select the ONLY two cards you want to discard.");
        GridPane.setConstraints(discard_label, 0,0);

        // load the image
        Image card0 = new Image("file:src/main/resources/Masters of Renaissance_Cards_FRONT_3mmBleed_1-1-1.png");
        ImageView iv0 = new ImageView();
        iv0.setImage(card0);
        iv0.setFitWidth(200);
        iv0.setPreserveRatio(true);
        iv0.setSmooth(true);


        Image card1 = new Image("file:src/main/resources/Masters of Renaissance_Cards_FRONT_3mmBleed_1-2-1.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(card1);
        iv1.setFitWidth(200);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);

        Image card2 = new Image("file:src/main/resources/Masters of Renaissance_Cards_FRONT_3mmBleed_1-3-1.png");
        ImageView iv2 = new ImageView();
        iv2.setImage(card2);
        iv2.setFitWidth(200);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);

        Image card3 = new Image("file:src/main/resources/Masters of Renaissance_Cards_FRONT_3mmBleed_1-4-1.png");
        ImageView iv3 = new ImageView();
        iv3.setImage(card3);
        iv3.setFitWidth(200);
        iv3.setPreserveRatio(true);
        iv3.setSmooth(true);

        GridPane.setConstraints(iv0, 0,2);
        GridPane.setConstraints(iv1, 1,2);
        GridPane.setConstraints(iv2, 2,2);
        GridPane.setConstraints(iv3, 3,2);

        CheckBox box0 = new CheckBox("LeaderCard 0");
        CheckBox box1 = new CheckBox("LeaderCard 1");
        CheckBox box2 = new CheckBox("LeaderCard 2");
        CheckBox box3 = new CheckBox("LeaderCard 3");
        GridPane.setConstraints(box0, 0,3);
        GridPane.setConstraints(box1, 1,3);
        GridPane.setConstraints(box2, 2,3);
        GridPane.setConstraints(box3, 3,3);

        Button next_button = new Button("Next ->");

        /*
        box0.selectedProperty().addListener( (v, oldValue, newValue) ->{
           if( (box0.isSelected() && box1.isSelected() && box2.isSelected()==false && box3.isSelected() == false) ||
                   (box0.isSelected() && box2.isSelected()&& box1.isSelected()==false && box3.isSelected() == false) ||
                   (box0.isSelected() && box3.isSelected()&& box2.isSelected()==false && box1.isSelected() == false)){
               next_button.setDisable(false);
           }
           else {
               next_button.setDisable(true);
           }
        });

        box1.selectedProperty().addListener( (v, oldValue, newValue) ->{
            if( (box1.isSelected() && box0.isSelected() && box2.isSelected()==false && box3.isSelected() == false) ||
                    (box1.isSelected() && box2.isSelected() && box0.isSelected()==false && box3.isSelected() == false) ||
                    (box1.isSelected() && box3.isSelected() && box2.isSelected()==false && box0.isSelected() == false)){
                next_button.setDisable(false);
            }
            else {
                next_button.setDisable(true);
            }
        });

        box2.selectedProperty().addListener( (v, oldValue, newValue) ->{
            if( (box2.isSelected() && box0.isSelected() && box1.isSelected()==false && box3.isSelected() == false) ||
                    (box1.isSelected() && box2.isSelected() && box0.isSelected()==false && box3.isSelected() == false) ||
                    (box2.isSelected() && box3.isSelected() && box1.isSelected()==false && box0.isSelected() == false)){
                next_button.setDisable(false);
            }
            else {
                next_button.setDisable(true);
            }
        });

        box3.selectedProperty().addListener( (v, oldValue, newValue) ->{
            if( (box3.isSelected() && box0.isSelected() && box1.isSelected()==false && box2.isSelected() == false) ||
                    (box3.isSelected() && box2.isSelected() && box1.isSelected()==false && box0.isSelected() == false) ||
                    (box1.isSelected() && box3.isSelected() && box2.isSelected()==false && box0.isSelected() == false)){
                next_button.setDisable(false);
            }
            else {
                next_button.setDisable(true);
            }
        });

         */

        GridPane.setConstraints(next_button, 2,4);

        layout5.getChildren().addAll(discard_label, iv0, iv1, iv2, iv3, box0, box1, box2, box3, next_button);
        layout5.setAlignment(Pos.CENTER);
        discard_scene = new Scene(layout5, WIDTH, HEIGHT);
        window.setScene(discard_scene);


        /*

        for (LeaderCard l : leaderCards) {
            System.out.println("[" + cont + "]");
            System.out.println(l.StampaCarta());
            //userInterface.ShowCard(l);
            //System.out.println(l);
            cont++;
            System.out.println("\n");

        }
        int a = 4;
        int b = 4;

        while (a > 3 || b > 3) {
            System.out.println("Which ones you want to discard? insert 2 index [0-3]");
            a = nextInt(scanner);
            b = nextInt(scanner);
            if (a > 3 || b > 3 || a == b) {
                a = 4;
                System.out.println("wrong indexes, try again");
            }
        }
        discardInitialLeaderCardsMessage.setIndexLeaderCard1(a);
        discardInitialLeaderCardsMessage.setIndexLeaderCard2(b);
    }

         */
    }



    @Override
    public void InitialResources(Scanner scanner, int PlayerIndex, InitialResourcesMessage initialResourcesMessage) {

    }

    @Override
    public int Menù(Scanner scanner, boolean actionDone, int leaderCardActionAvailable, boolean isSinglePlayer) {
        return 0;
    }

    @Override
    public void DealWithResourcesFromMarketTray(Scanner scanner, MarketTrayActionResponse marketTrayActionResponse, DealWithResourcesFromMarketTrayMessage dealWithResourcesFromMarketTrayMessage, int id) {

    }

    @Override
    public void PopeFavorStateEventOccured(Scanner scanner) {

    }

    @Override
    public void DealWithResFromMarkTrayResponse(Scanner scanner, DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse, boolean isSinglePlayer) {

    }

    @Override
    public void WantToBuyCardResponse(Scanner scanner, WantToBuyCardResponse wantToBuyCardResponse, int ID) {

    }

    @Override
    public void PrintMessages(String string) {

    }

    @Override
    public void Payment(Scanner scanner, ArrayList<CostOfCard> cost, ArrayList<CostOfCard> resourcesFromStrongbox, ArrayList<CostOfCard> resourcesFromWarehouse, ArrayList<Integer> rows, int playerIndex) {

    }

    @Override
    public void WantToActivateProdResponse(Scanner scanner, int PlayerIndex) {

    }

    @Override
    public void Produce(Scanner scanner, WantActivateProductionResponse wantActivateProductionResponse, ProduceMessage produceMessage, int PlayerIndex, int prod) {

    }

    @Override
    public int ActionMenu(Scanner scanner) {
        return 0;
    }

    @Override
    public void BuyCardChoice(Scanner scanner, WantToBuyCardMessage wantToBuyCardMessage, int ID) {

    }

    @Override
    public int ProduceChoice(Scanner scanner, int ID, WantActivateProductionMessage wantActivateProductionMessage) {
        return 0;
    }

    @Override
    public void MarketTrayActionChoice(Scanner scanner, MarketTrayActionMessage marketTrayActionMessage) {

    }

    @Override
    public void SeePersonalBoardChoice(Scanner scanner, int ID, boolean isSinglePlayer) {

    }

    @Override
    public void MoveResourcesChoice(Scanner scanner, int ID, MoveResourcesMessage moveResourcesMessage) {

    }

    @Override
    public int LeaderCardActionChoice(Scanner scanner, int ID) {
        return 0;
    }

    @Override
    public int ActivateLeaderCardActionChoice(Scanner scanner) {
        return 0;
    }

    @Override
    public int DiscardLeaderCardActionChoice(Scanner scanner) {
        return 0;
    }

    @Override
    public void GameStarted(Scanner scanner) {

    }

    @Override
    public void GeneralInformationchoice(Scanner scanner) {

    }

    @Override
    public void newWarehosue(Scanner scanner, int ID) {

    }

    @Override
    public void waitingForOtherPlayers(Scanner scanner) {

    }

    @Override
    public void singlePlayerGameFinished(boolean redWon, int TotalPoints) {

    }

    @Override
    public void handleDisconnection() {

    }
}

/*
    //FILE FXML
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        primaryStage.setResizable(false);

        // import fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/inizio.fxml"));
        loader.setController(this);

        inizio = new Scene(loader.load(),WIDTH,HEIGHT);

        window.setTitle("Masters_of_Renaissance.exe");
        window.setScene(inizio);
        window.show();
    }

    public void gotopage2Action(javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/login screen.fxml"));
        loader.setController(this);
        login = new Scene(loader.load(),WIDTH,HEIGHT);

        window.setScene(login);
    }

    //corrisponde alla asknickname
    public void loginAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/online_offline.fxml"));
        loader.setController(this);
        on_off = new Scene(loader.load(),WIDTH,HEIGHT);

        window.setScene(on_off);
    }

    public void onlineAction(ActionEvent actionEvent) throws Exception {
        //String name= nickname_field.getText().toString();
        //System.out.print(name);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/singleplayer_multiplayer.fxml"));
        loader.setController(this);
        sing_multi = new Scene(loader.load(),WIDTH,HEIGHT);

        window.setScene(sing_multi);
    }

    public void offlineAction(ActionEvent actionEvent) {
    }

    public void singleplayerAction(ActionEvent actionEvent) {
    }

    public void multiplayerAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/how_many_players.fxml"));
        loader.setController(this);
        how_many = new Scene(loader.load(),WIDTH,HEIGHT);

        window.setScene(how_many);
    }
     */
