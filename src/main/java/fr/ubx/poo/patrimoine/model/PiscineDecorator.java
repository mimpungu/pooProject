// PiscineDecorator.java
package fr.ubx.poo.patrimoine.model;

public class PiscineDecorator extends BienImmobilierDecorator {
    public PiscineDecorator(BienImmobilier bien) {
        super(bien);
    }

    @Override
    public String getType() {
        return bien.getType() + " avec Piscine";
    }
}
