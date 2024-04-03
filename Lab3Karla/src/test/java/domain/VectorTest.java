package domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void test() {
        Vector vector = new Vector(100);
        System.out.println("Size: "+vector.size());
        System.out.println("IsEmpty: "+vector.isEmpty());
        System.out.println(
                vector.isEmpty()
                        ?"El vector esta vacío"
                        :"El vector no esta vacío"

        );
        for (int i = 0; i < 50; i++) {
            vector.add(util.Utility.getRandom(50));
        }
        //System.out.println(vector.toString());
        System.out.println(vector); //llama al toString sin q se lo indique

        System.out.println("Size: "+vector.size());
        System.out.println("IsEmpty: "+vector.isEmpty());
        System.out.println(
                vector.isEmpty()
                        ?"El vector esta vacío"
                        :"El vector no esta vacío"

        );
        vector.add(5, 100);
        vector.add(80, 200);
        vector.add(60, 300);
        vector.add(70, 400);
        System.out.println(vector); //llama al toString sin q se lo indique
        System.out.println("Size: "+vector.size());
        vector.sort(); //ordeno el vector
        System.out.println(vector); //llama al toString sin q se lo indique

        //test del contains
        for (int i = 0; i < 30; i++) {
            int value = util.Utility.getRandom(50);
            System.out.println(
                    vector.contains(value)
                            ?"El elemento ["+value+"] existe en el vector "
                            +"en la posicion: "+vector.indexOf(value)
                            :"El elemento {"+value+"] no existe en el vector"
            );
        }
    }
}