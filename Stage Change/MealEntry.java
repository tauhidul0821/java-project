public class MealEntry{
	String Date;
	String Day;
	int Meal;
	String Comment;
	int total=0;
	MealEntry(String Date,String Day,int Meal,String Comment){
		this.Date=Date;
		this.Day=Day;
		this.Meal=Meal;
		this.Comment=Comment;
		
	}
        public void total(){
         total=total+Meal;
        }
	public String getDate(){
		return Date;
	}
	public String getDay(){
		return Day;
	}
	public int getMeal(){
		return Meal;
	}
	public String getComment(){
		return Comment;
	}
	public void setDate(String Date){
		this.Date=Date;
	}
	public void setDay(String Day){
		this.Day=Day;
	}
	public void setMeal(int Meal){
		this.Meal=Meal;
	}
	public void setComment(String Comment){
		this.Comment=Comment;
	}
	
}