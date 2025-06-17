package OOP;

public class Ceilinglight {
    private String name;
    private boolean isOn;
    private int brightNess;

    public Ceilinglight() {}

    public Ceilinglight(String name, int brightNess, boolean isOn){
        setName( name );
        setBrightNess( brightNess );
        if (isOn) {
            turnOn();
        } else {
            turnOff();
        }
    }

    public void turnOn(){
        isOn = true;
    }
    public void turnOff() {
        isOn = false;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBrightNess(int brightNess) {
        if (brightNess > 0 && brightNess <= 100) {
            this.brightNess = brightNess;
        }
    }

    public void displayInfo() {
        String status = this.isOn ? "on" : "off";
        System.out.println(this.name + " is " + status + " with level of brightness: " + this.brightNess);
    }
}

class AutoLight extends Ceilinglight {
    private int timer;

    public AutoLight(String name, int brightness, boolean isOn, int timer) {
        super(name, brightness, isOn);
        setTimer( timer );
    }

    public void setTimer(int timer){
        this.timer = timer;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Timer: " + this.timer);
    }
}

class lightTestDrive {
    public static void main(String[] args) {
        Ceilinglight light1 = new Ceilinglight();
        light1.setName("Bedroom Light");
        light1.setBrightNess(20);
        light1.turnOn();
        light1.displayInfo();

        Ceilinglight light2 = new Ceilinglight();
        light2.setName("Hall Light");
        light2.setBrightNess(50);
        light2.turnOff();
        light2.displayInfo();

        AutoLight light3 = new AutoLight("Kitchen Light", 75, false, 15);
        light3.displayInfo();

        Ceilinglight[] myLights = {light1, light2, light3};

        for (Ceilinglight l : myLights) {
            l.displayInfo();
            System.out.println("---");
        }
    }
}
