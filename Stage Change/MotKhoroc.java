public class MotKhoroc{
    String Date;
    String Day;
    int Taka;
    String Comment;

    public MotKhoroc(String Date, String Day, int Taka, String Comment) {
        this.Date = Date;
        this.Day = Day;
        this.Taka = Taka;
        this.Comment = Comment;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public int getTaka() {
        return Taka;
    }

    public void setTaka(int Taka) {
        this.Taka = Taka;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    
}