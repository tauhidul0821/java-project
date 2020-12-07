
import java.util.ArrayList;
import java.util.List;

public class TakaJomaService{
  
    
    public ArrayList<TakaJoma> getAll(){
		ArrayList<TakaJoma> userList = new ArrayList<TakaJoma>();
		userList.add(new TakaJoma("30-April-2016","Friday",4000,"Joma Diyeci"));
		userList.add(new TakaJoma("3-May-2016", "Friday",1000,"Joma Diyeci"));
		return userList;
	}
	public TakaJoma getById(String Date){
		for(TakaJoma u: this.getAll()){
			if(u.Date.equals(Date)){
				return u;
			}
		}
		return null;
	}
}