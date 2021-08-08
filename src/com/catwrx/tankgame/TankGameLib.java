package com.catwrx.tankgame;

import java.util.Vector;

public class TankGameLib {
    public static Vector<BaseGameObject> updateVector(Vector<BaseGameObject> baseGameObjectVector) {
        Vector<BaseGameObject> newVector = new Vector<>();
        for (BaseGameObject baseGameObject: baseGameObjectVector) {
            if (baseGameObject.isAlive()) {
                newVector.add(baseGameObject);
            }
        }
        return newVector;
    }
}
