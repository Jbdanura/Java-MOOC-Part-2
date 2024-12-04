/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jotabe
 */
import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    @Override
    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        return this.history.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
    }

    public double minValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        return this.history.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }

    public double average() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        return this.history.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}

