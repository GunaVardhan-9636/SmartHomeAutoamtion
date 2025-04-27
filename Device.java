public abstract class Device {
    protected String name;
    protected boolean status;

    public Device(String name) {
        this.name = name;
        this.status = false;
    }

    public void turnOn() {
        status = true;
        System.out.println(name + " is turned ON.");
    }

    public void turnOff() {
        status = false;
        System.out.println(name + " is turned OFF.");
    }

    public boolean isOn() {
        return status;
    }

    public String getName() {
        return name;
    }
}
