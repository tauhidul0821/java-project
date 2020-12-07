
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

public class CurrentBalanceFx extends Application {  
    TableView CurrentBalanceFxTable;
    TextField NoTextField;
    TextField DayTextField;
    TextField TakaTextField;
	TextField CommentTextField;
		/*String Date;
	String Day;
	int Taka;
	String Comment;*/
    
    public void start(Stage stage) {
        /*****/
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
                 
		
		HBox headline= new HBox(80,MealEntry,TakaJoma,MotKhoroc,CurrentBalance,MealRate);
        Separator headlineseparator = new Separator();
		headlineseparator.setPadding(new Insets(10, 0, 0, 0));
		
		Label NoLabel = new Label("Taka");
		NoTextField = new TextField();
       
		
        
		Label TakaLabel = new Label("Taka");
		TakaTextField = new TextField();
        HBox TakaHBox = new HBox(5,NoLabel ,NoTextField,TakaLabel, TakaTextField); 
		
		
        /*****/
	
        Button editButton = new Button("Edit");
          Button saveButton = new Button("Save");
        /*
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
        HBox top = new HBox(5, TakaHBox,editButton,saveButton);
        
        /*****/
        
        Separator topSeparator = new Separator();
	topSeparator.setPadding(new Insets(10, 0, 0, 0));
                
        /************/
        //Working with TableView ............................................. 
        // Creating the TableView object
       CurrentBalanceFxTable = new TableView();
        
        // Creating the columns
        TableColumn NoColumn = new TableColumn("No"); 
       
        TableColumn TakaColumn = new TableColumn("Taka"); 
        //Mapping columns with person object        
        NoColumn.setCellValueFactory(new PropertyValueFactory<CurrentBalance, String>("No"));
        TakaColumn.setCellValueFactory(new PropertyValueFactory<CurrentBalance, Integer>("Taka"));
        
        
        // Adding the columns
        CurrentBalanceFxTable.getColumns().addAll(NoColumn, TakaColumn);
       
       // try{
            CurrentBalanceService CurrentBalanceServiceObject = new CurrentBalanceService();
            // Setting contactList to table as a observable list
            CurrentBalanceFxTable.setItems(FXCollections.observableArrayList(CurrentBalanceServiceObject.getAll()));
        //}
        //catch(Exception ex){
            
        //}
        
        CurrentBalanceFxTable.getSelectionModel().selectedItemProperty().addListener(
              new ChangeListener<CurrentBalance>() {
                @Override
                public void changed(ObservableValue observable, CurrentBalance oldValue, CurrentBalance newValue) {
                    NoTextField.setText(newValue.getNo());
                    TakaTextField.setText(newValue.getTaka());
                    
                }
        }
        );
         /*
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
		

        VBox root = new VBox(5,headline,headlineseparator, top, topSeparator,CurrentBalanceFxTable, bottomSeparator, addButton);
        root.setPadding(new Insets(10));
		
		//root.getChildren().addAll(CurrentBalanceFxTable);
		
        Scene scene = new Scene(root,900, 600);
        stage.setTitle("Current Balance ");
        stage.setScene(scene);
        stage.show();
    }
}