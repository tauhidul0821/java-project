public class MealRate{
    String No;
    int Taka;

    public MealRate(String No, int Taka) {
        this.No = No;
        this.Taka = Taka;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String No) {
        this.No = No;
    }

    public int getTaka() {
        return Taka;
    }

    public void setTaka(int Taka) {
        this.Taka = Taka;
    }

    @Override
    public String toString() {
        return No; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}