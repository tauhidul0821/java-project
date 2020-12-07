
import java.util.ArrayList;
import java.util.List;

public class MealEntryService{
    static ArrayList<MealEntry>MealEntryList;
	
  
    int total=0;
    public ArrayList<MealEntry> getAll(){
		ArrayList<MealEntry> userList = new ArrayList<MealEntry>();
		userList.add(new MealEntry("30-April-2016", "Monday",1 ,"Fish"));
		userList.add(new MealEntry("1-May-2016", "Wednesday",2 ,"Fish"));
		userList.add(new MealEntry("3-May-2016", "Friday", 3,"Fish"));
		//userList.add(new MealEntry("Total ", "Meal ==", (total+=Meal),"Fish"));
		
		return userList;
	}
	public MealEntry getById(String Date){
		for(MealEntry u: this.getAll()){
			if(u.Date.equals(Date)){
				return u;
			}
		}
		return null;
	}
      
	/*  
	
	public boolean add(MealEntry mealEntry){
        MealEntryList.add(mealEntry);
        return true;
    }
	public boolean edit(MealEntry mealEntry){
        //query
        return true;
    }
	public boolean delete(MealEntry mealEntry){
        MealEntryList.remove(this.getByDay(Day));
        return true;
    }
	
    public MealEntry getByDay(MealEntry mealEntry){
        for(MealEntry mealEntry: MealEntryList){
            if(mealEntry.getId().equals(id))
                return mealEntry;
        }
        return null;
    }
	public MealEntry getByDate(String Date){
		for(MealEntry mealEnt: MealEntryList){
			if(mealEnt.getDate().equals(Date)){
				return mealEnt;
			}
		}
		return null;
	}
	
    public List<MealEntry> getAll(){        
        return MealEntryList;
    }*/
}