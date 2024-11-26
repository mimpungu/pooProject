// ParkingDecorator.java
package fr.ubx.poo.patrimoine.model;

public class ParkingDecorator extends BienImmobilierDecorator {
    public ParkingDecorator(BienImmobilier bien) {
        super(bien);
    }

    @Override
    public String getType() {
        return bien.getType() + " avec Parking";
    }
}
