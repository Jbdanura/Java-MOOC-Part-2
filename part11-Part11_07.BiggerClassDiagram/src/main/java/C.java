
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jotabe
 */
public class C extends B implements IC {
    private ArrayList<E> e = new ArrayList<>();
    @Override
    public void methodC() {
        System.out.println("Method C from class C");
    }
}
