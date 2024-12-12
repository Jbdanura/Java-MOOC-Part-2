package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> listOfSensors;
    private List<Integer> listOfAver;

    public AverageSensor() {
        this.listOfSensors = new ArrayList<>();
        this.listOfAver = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        listOfSensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : listOfSensors) {
            if (!sensor.isOn()) {
                return false;  
            }
        }
        return true;  
    }

    @Override
    public void setOn() {
        listOfSensors.forEach(Sensor::setOn);     
    }

    @Override
    public void setOff() {
        listOfSensors.forEach(Sensor::setOff);  
    }

    @Override
    public int read() {
        if (!isOn() || listOfSensors.isEmpty()) {
            throw new IllegalArgumentException("Unable to get average: sensor is off or no sensors available");
        }

        int sum = 0;
        for (Sensor sensor : listOfSensors) {
            sum += sensor.read();
        }

        int average = sum / listOfSensors.size();
        listOfAver.add(average);
        return average;
    }

    public List<Integer> readings() {
        return new ArrayList<>(listOfAver); 
    }
}
