//Guy Kozliner - 316612662
//Yakov Hazut - 205874233

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // הקמת סוכנות רכב המכילה 10 רכבים
        ArrayList<Agent> agentArray = new ArrayList<Agent>();
        CarAgency newAgency = new CarAgency("The best agency");
        Cars newCar = new Cars(2014, 3, 52000, 120000, 2343335, 90, "Chevrolet","black");
        Cars newCar1 = new Cars(2011, 1, 5000, 300000, 2343335, 95, "Volvo","black");
        Cars newCar2 = new Cars(2019, 6, 62000, 120000, 2340465, 122, "Kia","black");
        Cars newCar3 = new Cars(2006, 9, 92000, 1000, 2343495,63, "Suzuki","black");
        Cars newCar4 = new Cars(2002, 3, 159000, 120000, 2343465,49, "Dodge","black");
        Cars newCar5 = new Cars(2001, 1, 222000, 17000, 2349465,57, "Toyota","black");
        Cars newCar6 = new Cars(1995, 2, 300000, 57000, 2344465,54, "Toyota","black");
        Cars newCar7 = new Cars(2012, 2, 11000, 66000, 2347465,73, "Kia","black");
        Cars newCar8 = new Cars(2017, 2, 5700, 15000, 2343415, 135, "Suzuki","black");
        Cars newCar9 = new Cars(2011, 1, 5000, 300000, 2300465, 95, "Kia","black");
        newAgency.addCar(newCar);
        newAgency.addCar(newCar1);
        newAgency.addCar(newCar2);
        newAgency.addCar(newCar3);
        newAgency.addCar(newCar4);
        newAgency.addCar(newCar5);
        newAgency.addCar(newCar6);
        newAgency.addCar(newCar7);
        newAgency.addCar(newCar8);
        newAgency.addCar(newCar9);

        // הקמת רשימת סוכנים הכוללת קליטת שמות סוכנים ומספרם מהמשתמש
        newAgency.setAgentsList(agentArray);
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of desired agents: \n");
        int numOfAgents = input.nextInt();
        for (int i = 0; i < numOfAgents; i++) {
            System.out.println("Please enter the agent's name: \n");
            String newName = input.next();
            newAgency.addAgent(newName);
        }

        // שליחת 3 חיפושי רכב שונים
        newAgency.searchCar(120000, 80000,2 );
        newAgency.searchCar(20000, 2014);
        newAgency.searchCar("Dodge", 2012);
    }
}
