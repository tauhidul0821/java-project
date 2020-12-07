
import java.util.ArrayList;
import java.util.List;

public class MotKhorocService{
    
    
    public ArrayList<MotKhoroc> getAll(){
		ArrayList<MotKhoroc> userList = new ArrayList<MotKhoroc>();
		userList.add(new MotKhoroc("1-May-2016","Friday" ,400,"Joma Diyeci"));
		userList.add(new MotKhoroc("2-May-2016", "Sunday",100,"Bajar koreci"));
		return userList;
	}
	public MotKhoroc getById(String Date){
		for(MotKhoroc u: this.getAll()){
			if(u.Date.equals(Date)){
				return u;
			}
		}
		return null;
	}
}