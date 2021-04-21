//Guy Kozliner - 316612662
//Yakov Hazut - 205874233
import java.util.ArrayList;

public class Agent {
    private int employeeID, salesAmount;
    private String name;
    private double salary;

    // בניית בנאי מלא
    public Agent(String name,int employeeID, int salesAmount ,double salary) {
        this.salesAmount = salesAmount;
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
    }
	//בנאי העתקה
	public Agent(Agent other) {
		this(other.name, other.employeeID,other.salesAmount,other.salary);
		}

    // בניית פונקציות GET ו SET
    public int getSalesAmount(){return this.salesAmount;}
    public double getSalary(){return this.salary;}
    public int getEmployeeID(){return this.employeeID;}
    public void setSalesAmount(int anotherSale){ this.salesAmount = anotherSale; }
    public void setSalary(int Bonus){ this.salary = this.salary+Bonus; }

    // חיפוש רכב על בסיס ק"מ, מחיר ויד
    public void searchCar(ArrayList<Cars> CarsList, int maxMile, int maxPrice, int maxYad) {
        for (Cars car : CarsList)
        {
            if (car.getMiles() < maxMile && car.getPrice() < maxPrice && car.getYad() < maxYad)
            {
                car.describeCar(); // תיאור הרכב במידה ועומד בתנאים
            }
        }
    }
    // חיפוש רכב על בסיס מחיר ושנת ייצור מינימלית
    public void searchCar(ArrayList<Cars> CarsList, int maxPrice, int minYearOfManufacture) {
        for (Cars car : CarsList)
        {
            if (car.getPrice() < maxPrice && car.getYearOfManufacture() > minYearOfManufacture)
            {
            	 car.describeCar(); // תיאור הרכב במידה ועומד בתנאים
            }
        }
    }
    // חיפוש רכב על בסיס דגש ושנת ייצור מינימלית
    public void searchCar(ArrayList<Cars> CarsList, String Brand, int minYearOfManufacture) {
        for (Cars car : CarsList)
        {
            if (car.getManufacturer() == Brand && car.getYearOfManufacture() > minYearOfManufacture)
            {
           	 car.describeCar(); // תיאור הרכב במידה ועומד בתנאים
            }
        }
    }
    // בדיקה ששני הסוכנים שונים על בסיס מספר מזהה
    public boolean equalsAgent(Agent otherAgent){ return this.employeeID == otherAgent.employeeID; }

    // מבוסס על TOSTRING, מבצעת הדפסה באופן יותר ישיר
    public void describeAgent() {
        System.out.println("The agent number " + this.employeeID + " and his name is " + this.name + ". His total amount of sales so far is " +
                this.salesAmount + ".");
    }

	// במידה ונרצה להשתמש בפונקציית TOSTRING היא תראה כך
    /*public String toString() {
        return "Agent [name=" + name + ", employeeId=" + employeeId + ", sells=" + sells + "]";
    }*/
}