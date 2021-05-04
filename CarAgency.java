//Guy Kozliner


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CarAgency {
    private String agencyName;
    private ArrayList<Cars> carsForSale;
    private ArrayList<Agent> agentsList;

    // בנאי מלא
    public CarAgency(String agencyName, ArrayList<Cars> carsForSale, ArrayList<Agent> agentsList) {
        this.agencyName = agencyName;
        this.carsForSale = carsForSale;
        this.agentsList = agentsList;
	}
	// בנאי ריק
    public CarAgency() {}
	//בנאי העתקה
	public CarAgency(CarAgency other) {
		this(other.agencyName, other.carsForSale,other.agentsList);
		}
    public void setName(String name){
        this.agencyName = name;
    }
    // שליפת רשימת רכבים למכירה
    public ArrayList<Cars> getCarsForSale() {
        return this.carsForSale;
    }
    // בנאי חלקי,יצירת סוכנות רכב
    public CarAgency(String name)
    {
        this.agencyName = new String(name);
        this.carsForSale = new ArrayList<Cars>();
        this.agentsList = new ArrayList<Agent>();
    }
    // to delete
    // הוספת רכב לרשימת הרכבים שמוצעים למכירה
    public void addCar(Cars car) {
        int flag = 0;
        for (Cars cars : carsForSale) { // ריצה על כל רשימת הרכבים למכירה
            if (cars.getCarLicensePlate() == car.getCarLicensePlate()) {
                System.out.println("Car already exist!");
                flag++;
                break;
            }
        }
        if (flag == 0) { // במידה והרכב לא נמצא, נוסיף אותו לרשימת הרכבים המוצעים למכירה
            carsForSale.add(car);
            System.out.println("The car was added successfully");
            car.describeCar();
        }
    }
    // מכירת רכב
    public void saleCar(int carNum, int EmployeeID)
    {
        int countAgent = 0;
        int countCar = 0;
        for (Agent agent : agentsList){ // ריצה על רשימת סוכנים
           	if (agent.getEmployeeID() == EmployeeID) 
           	{countAgent++;} // הסוכן נמצא
                for (Cars car : carsForSale){
                    if (car.getCarLicensePlate() == carNum){
                        countCar++;
                    	 if (countAgent == 1 && countCar==1) { // במידה וגם הסוכן וגם הרכב קיימים במאגר
                    	     carsForSale.remove(car);
                         	 car.setYad(car.getYad());
                             System.out.println("Congrats! you've got the car!");
                        	 agent.setSalesAmount(agent.getSalesAmount()+1);
                        	 break;
                         }
                    }
                }
           	break;
        }
        if (countCar == 0 && countAgent==1) // במידה ורק הסוכן נמצא במאגר
        {System.out.println("The CAR did not found in the Cars list, but agent exist");}
        else if(countCar == 0) // במידה ולא נמצא סוכן ורכב
        {System.out.println("The CAR did not found in the Cars list and Agent did not exist");}
        else if(countCar==1&&countAgent==0){System.out.println("The AGENT did not found in the agents list, but the CAR is exist in the list");}
    }
    // הוספת סוכן לרשימת סוכנים
    public void addAgent(String AgentName) {
        int min = 1000;
        int max = 9999;
        int i = 0;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min); // יצירת מספר רנדומלי בין 1000 ל 9999
                for (Agent agent : agentsList) {
                    while (i < agentsList.size()) {
                        if (agent.getEmployeeID() == random_int) {
                            random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
                            i = agentsList.size() + 1; // לצורך שבירת הלולאה
                        }
                        i++;
                    }
        }
        Agent agent = new Agent(AgentName,random_int,0,0);
        agentsList.add(agent);
        System.out.println("Agent number " + random_int + " successfully!");
        agent.describeAgent();
    }
    // פונקציות GET ו SET
    public ArrayList<Agent> getAgentsList() { return agentsList; }
	public void setAgentsList(ArrayList<Agent> agentsList) { this.agentsList = agentsList; }
	public void setCarsForSale(ArrayList<Cars> carsForSale) { this.carsForSale = carsForSale; }
	// מחיקת סוכן
	public void deleteAgent(int agentID){
		if(!agentsList.isEmpty())// במידה ורשימת הסוכנים לא ריקה
		{
			 int countAgent = 0;
		        for (Agent agent : agentsList){ // חיפוש סוכן ברשימת הסוכנים לפי מספר מזהה
		            if (agent.getEmployeeID() == agentID){
                        agentsList.remove(agent);
		                System.out.println("The AGENT deleted");
		                countAgent++;
		                break;
		            }
		        }
		        if (countAgent == 0){ // במידה והסוכן לא נמצא במאגר
		            System.out.println("The AGENT did not found in the agents list and can not be deleted");
		        }	
		}
		else { System.out.println("Agents not found, please add agent first."); }
    }
    // חיפוש רכב לפי מחיר, ק"מ, ויד
    public void searchCar(int maxMile, int maxPrice, int maxYad) {
        if (!agentsList.isEmpty()) {
            Agent smallSalaryAgent = agentsList.get(0); // אתחול לפי השכר של הסוכן הראשון ברשימה
            for (Agent agent : agentsList) {
                if (smallSalaryAgent.getSalary() > agent.getSalary()) { // מציאת מינימום
                    smallSalaryAgent = agent;
                }
            }
            smallSalaryAgent.searchCar(carsForSale, maxMile, maxPrice, maxYad);
            Scanner CustomerAnswer = new Scanner(System.in);
            System.out.println("Welcome to first option to buy a car, do you want to buy that car ? (YES/NO) \n");
            String customerAnswer = CustomerAnswer.next();
            if (customerAnswer.equals("YES") || customerAnswer.equals("yes") || customerAnswer.equals("Yes")) {
                System.out.println("Enter the desierd can number");
                int desiredCarNumber = CustomerAnswer.nextInt();
                saleCar(desiredCarNumber, smallSalaryAgent.getEmployeeID());
            }
            else { System.out.println("-We're here if you want to think about it again, see you!"); }
        }
        else {System.out.println("The agent's list is empty!");}
    }
    // חיפוש רכב לפי מחיר, ושנת ייצור
    public void searchCar(int maxPrice,int minYearOfManufacture ){
    	if(!agentsList.isEmpty()){ // במידה ויש סוכנים ברשימה
            Agent smallSalaryAgent = agentsList.get(0);
            for (Agent agent : agentsList) {
                if (smallSalaryAgent.getSalary() > agent.getSalary()) {
                    smallSalaryAgent = agent;
                }
            }
            smallSalaryAgent.searchCar(carsForSale,maxPrice,minYearOfManufacture);// הסוכן שולף רשימת רכבים רלוונטית
            Scanner CustomerAnswer = new Scanner(System.in); // הבנה האם הקונה רוצה לרכוש רכב
            System.out.println("Welcome to second option to buy a car, do you want to buy that car ? (YES/NO) \n");
            String customerAnswer = CustomerAnswer.next();
            if (customerAnswer.equals("YES") || customerAnswer.equals("yes") || customerAnswer.equals("Yes")) {
                System.out.println("Enter the desierd can number"); // מכירה על בסיס מספר רכב
                int desiredCarNumber = CustomerAnswer.nextInt();
                saleCar(desiredCarNumber, smallSalaryAgent.getEmployeeID());
            }
            else {System.out.println("--We're here if you want to think about it again, see you!");
            }
    	}
    	else {System.out.println("Agents not found, please add agent first");
    	}
    }
    // מכירת רכב על בסיס דגם ושנת ייצור
    public void searchCar(String brand,int minYearOfManufacture){
    	if(!agentsList.isEmpty())
    	{
            Agent smallSalaryAgent = agentsList.get(0);
            for (Agent agent : agentsList) {
                if (smallSalaryAgent.getSalary() > agent.getSalary()) { // מציאת מינימום
                    smallSalaryAgent = agent;
                }
            }
            smallSalaryAgent.searchCar(carsForSale,brand,minYearOfManufacture);
            Scanner CustomerAnswer = new Scanner(System.in);
            System.out.println("Welcome to third option to buy a car, do you want to buy that car ? (YES/NO) \n");
            String customerAnswer = CustomerAnswer.next();
            if (customerAnswer.equals("YES") || customerAnswer.equals("yes") || customerAnswer.equals("Yes")) {
                System.out.println("Enter the desierd can number");
                int desiredCarNumber = CustomerAnswer.nextInt();
                saleCar(desiredCarNumber, smallSalaryAgent.getEmployeeID()); // מכירת רכב
            }
            else {System.out.println("---We're here if you want to think about it again, see you!");}
    	}
    	else {System.out.println("Agents not found, please add agent first"); } // במידה ורשימת סוכנים ריקה, נדפיס זאת למשתמש
    }

    // בדיקה האם שני סוכנויות זהות על בסיס השם
    public boolean equalsCarAgency(CarAgency CarAgencyName){ return this.equals(CarAgencyName); }

    // מבוסס על TOSTRING, מבצעת הדפסה באופן יותר ישיר
    public void describeAgency(){
        System.out.println("The car agency name is " + this.agencyName + " and that's the amount of cars which availible for sale : \n " + this.carsForSale.size() +
                " The agency have  " + this.agentsList.size() + " agents at the moment.");
    }

    // במידה ונרצה להשתמש בפונקציית TOSTRING היא תראה כך
    /*public String toString() {
        return "CarAgency [AgencyName=" + agencyName + ", CarsForSale=" + carsForSale.size() + ", AgentsList=" + agentsList.size()
                + "]";
    }*/

}
