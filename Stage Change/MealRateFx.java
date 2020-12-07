
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MealRateFx extends Application {  
    TableView  MealRateTable;
    TextField NoTextField;
    TextField TakaTextField;
    
    public void start(Stage stage) {
        
		Button MealEntry = new Button("Meal Entry");
                 MealEntry.setOnAction(e->{
                    ManageMealEntry ManageMealEntryObject = new ManageMealEntry();
            ManageMealEntryObject.start(stage);
                
                });
		Button TakaJoma = new Button("Taka Joma");
                TakaJoma.setOnAction(e->{ 
                     TakaJomaFx TakaJomaFxObject = new TakaJomaFx();
            TakaJomaFxObject.start(stage);
                });
		Button MotKhoroc = new Button("Mot Khoroc");
                MotKhoroc.setOnAction(e->{ 
                     MotKhorocFx MotKhorocFxObject = new MotKhorocFx();
            MotKhorocFxObject.start(stage);
                });
		Button CurrentBalance = new Button("Current Balance");
                CurrentBalance.setOnAction(e->{
                    CurrentBalanceFx CurrentBalanceFxObject = new CurrentBalanceFx();
            CurrentBalanceFxObject.start(stage);
                
                });
		Button MealRate = new Button("Meal Rate");
		 MealRate.setOnAction(e->{
                     MealRateFx MealRateFxObject =new MealRateFx();
                     MealRateFxObject.start(stage);
               
                });
                 
		HBox headline= new HBox(80,MealEntry,TakaJoma,MotKhoroc,CurrentBalance,MealRate);
        Separator headlineseparator = new Separator();
		headlineseparator.setPadding(new Insets(10, 0, 0, 0));
		
			Label NoLabel = new Label("No");
		NoTextField = new TextField();
        
		
		Label TakaLabel = new Label("Taka");
		TakaTextField = new TextField();
        HBox TakaHBox = new HBox(5, NoLabel, NoTextField,TakaLabel,TakaTextField); 
		
	
        /*****/
	
        Button editButton = new Button("Edit");/*
        editButton.setOnAction(e->{
            EditContact editContact = new EditContact((Contact)contactTable.getSelectionModel().getSelectedItem());
            editContact.start(stage);
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e->{            
            ContactService contactService = new ContactService();
            contactService.delete(((Contact)contactTable.getSelectionModel().getSelectedItem()).getId());
            contactTable.setItems(FXCollections.observableArrayList(contactService.getAll()));
        });*/
        HBox top = new HBox(5, TakaHBox,editButton);
        
        /*****/
        
        Separator topSeparator = new Separator();
	topSeparator.setPadding(new Insets(10, 0, 0, 0));
                
        /************/
        //Working with TableView ............................................. 
        // Creating the TableView object
        MealRateTable = new TableView();
        
        // Creating the columns
        TableColumn NoColumn = new TableColumn("No"); 
        TableColumn TakaColumn = new TableColumn("Taka"); 
        
        //Mapping columns with person object        
        NoColumn.setCellValueFactory(new PropertyValueFactory<MealRate, String>("No"));
       TakaColumn.setCellValueFactory(new PropertyValueFactory<MealRate, Integer>("Taka"));
        
        // Adding the columns
        MealRateTable.getColumns().addAll(NoColumn, TakaColumn);
        
        //try{
            MealRateService MealRateServiceObject = new MealRateService();
            // Setting contactList to table as a observable list
            MealRateTable.setItems(FXCollections.observableArrayList(MealRateServiceObject.getAll()));
       // }
       // catch(Exception ex){
            
       // }
        /*
        String No;
    int Taka;
        
        */
        
      /* 
        MealRateTable.getSelectionModel().selectedItemProperty().addListener(
              new ChangeListener<MealRate>() {
                
                public void changed(ObservableValue observable, MealRate oldValue, MealRate newValue) {
                    NoTextField.setText(newValue.getNo());
                   TakaTextField.setText(newValue.getSelectedIndex());
                    
                }
        }
        );
  
        */
        
        Separator bottomSeparator = new Separator();
	bottomSeparator.setPadding(new Insets(5, 0, 0, 0));        
        Button addButton = new Button("Add New");
       /* addButton.setOnAction(e->{
            AddContact addContact = new AddContact();
            //Stage stage1 = new Stage();
            addContact.start(stage);
        });*/
		/*MealEntryService mealEntryService=new MealEntryService();
		MealEntryTable.setItem(FXCollections.observableList(mealEntryService.getAll()));
		*/
		

        VBox root = new VBox(5,headline,headlineseparator, top, topSeparator,MealRateTable, bottomSeparator, addButton);
        root.setPadding(new Insets(10));
		
		//root.getChildren().addAll(MealRateTable);
		
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Meal Rate ");
        stage.setScene(scene);
        stage.show();
    }
}