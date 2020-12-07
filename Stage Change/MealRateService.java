
import java.util.ArrayList;
import java.util.List;

public class MealRateService{
    
    
    public ArrayList<MealRate> getAll(){
		ArrayList<MealRate> userList = new ArrayList<MealRate>();
		userList.add(new MealRate("1",40));
		
		return userList;
	}
	public MealRate getById(String No){
		for(MealRate u: this.getAll()){
			if(u.No.equals(No)){
				return u;
			}
		}
		return null;
	}
        
        
        
}