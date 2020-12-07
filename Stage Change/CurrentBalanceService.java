
import java.util.ArrayList;
import java.util.List;

public class CurrentBalanceService{
    
    
    public ArrayList<CurrentBalance> getAll(){
		ArrayList<CurrentBalance> userList = new ArrayList<CurrentBalance>();
		userList.add(new CurrentBalance("1","400"));
		
		return userList;
	}
	public CurrentBalance getById(String No){
		for(CurrentBalance u: this.getAll()){
			if(u.No.equals(No)){
				return u;
			}
		}
		return null;
	}
}