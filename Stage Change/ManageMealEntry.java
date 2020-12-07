
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageMealEntry extends Application {  
    TableView MealEntryTable;
    TextField DateTextField;
    TextField DayTextField;
    TextField MealTextField;
	TextField CommentTextField;
		/*String Date;
	String Day;
	int Meal;
	String Comment;*/
    
    public void start(Stage stage) {
        /*********************************/
		Button MealEntry = new Button("Meal Entry");
               
                  MealEntry.setOnAction(e->{
                    ManageMealEntry ManageMealEntryObject = new ManageMealEntry();
            ManageMealEntryObject.start(stage);
                //System.out.println("MealEntry ");
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
                //System.out.println("MealEntry ");
                });
		Button MealRate = new Button("Meal Rate");
                 MealRate.setOnAction(e->{
                     MealRateFx MealRateFxObject =new MealRateFx();
                     MealRateFxObject.start(stage);
               // System.out.println("MealRate");
                });
	/********************************************/	
		HBox headline= new HBox(80,MealEntry,TakaJoma,MotKhoroc,CurrentBalance,MealRate);
        Separator headlineseparator = new Separator();
		headlineseparator.setPadding(new Insets(10, 0, 0, 0));
		
		Label DateLabel = new Label("Date");
		DateTextField = new TextField();
        HBox DateHBox = new HBox(5, DateLabel, DateTextField); 
		
		Label DayLabel = new Label("Day");
		DayTextField = new TextField();
        HBox DayHBox = new HBox(5, DayLabel, DayTextField); 
		
		Label MealLabel = new Label("Meal");
		MealTextField = new TextField();
        HBox MealHBox = new HBox(5, MealLabel, MealTextField); 
		
		Label CommentLabel = new Label("Comment");
		CommentTextField = new TextField();
        HBox CommentHBox = new HBox(5, CommentLabel, CommentTextField); 
		
		
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
        Button saveButton = new Button("Save");
         
        HBox top = new HBox(5, DateHBox, DayHBox, MealHBox, CommentHBox,editButton,saveButton);
        
        /*****/
        
        Separator topSeparator = new Separator();
	topSeparator.setPadding(new Insets(10, 0, 0, 0));
                
        /************/
        //Working with TableView ............................................. 
        // Creating the TableView object
        MealEntryTable = new TableView();
        
        // Creating the columns
        TableColumn DateColumn = new TableColumn("Date"); 
        TableColumn DayColumn = new TableColumn("Day"); 
        TableColumn MealColumn = new TableColumn("Meal"); 
        TableColumn CommentColumn = new TableColumn("Comment"); 		
        
        //Mapping columns with person object        
        DateColumn.setCellValueFactory(new PropertyValueFactory<MealEntry, String>("Date"));
        DayColumn.setCellValueFactory(new PropertyValueFactory<MealEntry, String>("Day"));
       MealColumn.setCellValueFactory(new PropertyValueFactory<MealEntry, Integer>("Meal"));
	CommentColumn.setCellValueFactory(new PropertyValueFactory<MealEntry, String>("Comment"));
        
        // Adding the columns
        MealEntryTable.getColumns().addAll(DateColumn, DayColumn, MealColumn,CommentColumn);
		
		
		
       
        try{
            MealEntryService MealEntryServiceObject = new MealEntryService();
            // Setting contactList to table as a observable list
            MealEntryTable.setItems(FXCollections.observableArrayList(MealEntryServiceObject.getAll()));
         
        }
        catch(Exception ex){
            
        }
         /*
        MealEntryTable.getSelectionModel().selectedItemProperty().addListener(
              new ChangeListener<MealEntry>() {
                @Override
                public void changed(ObservableValue observable, MealEntry oldValue, MealEntry newValue) {
                    DateTextField.setText(newValue.getDate());
                    DayTextField.setText(newValue.getDay());
                    MealTextField.setText(newValue.getMeal());
                    CommentTextField.setText(newValue.getComment());
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
		//MealEntryService mealEntryService=new MealEntryService();
		//MealEntryTable.setItem(FXCollections.observableList(mealEntryService.getAll()));
		
		

        VBox root = new VBox(5,headline,headlineseparator, top, topSeparator,MealEntryTable,bottomSeparator, addButton);
        root.setPadding(new Insets(10));
		
		//root.getChildren().addAll(MealEntryTable);
		
        Scene scene = new Scene(root,900, 600);
        stage.setTitle("ManageMealEntry");
        stage.setScene(scene);
        stage.show();
    }
}