//Guy Kozliner

public class Cars {
    private String color;
    private int yearOfManufacture, yad, price, miles, carLicensePlate, speed;
    private String manufacturer;

    // בנאי מלא
    public Cars(int yearOfManufacture, int yad, int price, int miles, int carLicensePlate, int speed,String manufacturer,String color) {
        this.yearOfManufacture = yearOfManufacture;
        this.yad = yad;
        this.price = price;
        this.miles = miles;
        this.carLicensePlate = carLicensePlate;
        this.speed = speed;
        this.manufacturer = manufacturer;
        this.color=color;
	}
	// בנאי ריק
    public Cars() {}

	//בנאי העתקה
	public Cars(Cars other) {
		this(other.yearOfManufacture, other.yad,other.price,other.miles,other.carLicensePlate,other.speed,other.manufacturer,other.color);
		}

    // בניית פונקציות GET ו SET על פי צורך
	public int getMiles(){ return this.miles; }
    public int getPrice(){ return this.price; }
    public int getYad(){ return this.yad; }
    public int getCarLicensePlate(){return this.carLicensePlate;}
    public int getYearOfManufacture(){ return this.yearOfManufacture; }
    public String getManufacturer(){ return this.manufacturer; }
    public String getColor() {
        return this.color;
    }
    public int getSpeed() {
        return this.speed;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setMiles(int miles) {this.miles = miles; }

    // עדכון מהירות רכב
    public void setAcceleration(int speed){
        if (speed < 180){
            this.speed = speed+1;
            System.out.println("The new speed is " + this.speed);
        }
        else { System.out.println("The speed is higher then 180!"); }
    }

    // עדכון מהירות רכב
	public void setDeceleration(int speed){
        if (this.speed > 0){
            this.speed = speed-1;
            System.out.println("The new speed is " + this.speed);
        }
        else { System.out.println("The car is not moving, you cant decelerate the speed.\n"); }
    }

    // עדכון עצירה של רכב
    public void setStop (){
        this.speed = 0;
        System.out.println("The car has stopped and the current speed is " + this.speed);
    }

    // עדכון יד נוספת שהרכב עבר
    public void setYad (int yad){
        this.yad = yad+1;
        System.out.println("The current owner is the " + this.yad + " hand");
    }

    // הבנה האם שתי רכבים זהים על בסיס מספר לוחית רישוי
    public boolean equalsCars(Cars otherCar){ return this.carLicensePlate == otherCar.carLicensePlate; }

    // מבוסס על TOSTRING, מבצעת הדפסה באופן יותר ישיר
    public void describeCar(){
        System.out.println("The car number " + this.carLicensePlate + " designed by " + this.manufacturer + " and drove already " +
                this.miles +" miles.\n her price is " + this.price + " and her color is " + this.color +".\n her year of manufacture is " +
                this.yearOfManufacture +" number of previous owners is "+this.yad);
    }

    // במידה ונרצה להשתמש בפונקציית TOSTRING היא תראה כך
    /*public String toString() {
        return "Cars [Color=" + color + ", YearOfManufacture=" + yearOfManufacture + ", Yad=" + yad + ", Price=" + price
                + ", Miles=" + miles + ", CarLicensePlate=" + carLicensePlate + ", Manufacturer=" + manufacturer + "]";
    }*/

}

