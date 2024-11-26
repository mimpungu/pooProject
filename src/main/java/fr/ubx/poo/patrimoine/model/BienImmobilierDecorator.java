// BienImmobilierDecorator.java
package fr.ubx.poo.patrimoine.model;

public abstract class BienImmobilierDecorator extends BienImmobilier {
    protected BienImmobilier bien;

    public BienImmobilierDecorator(BienImmobilier bien) {
        // Pass all required parameters to the superclass constructor
        super(bien.getAdresse(), bien.getPrix(), bien.getLoyer(), bien.getType());
        this.bien = bien;
    }

    @Override
    public void louer() {
        bien.louer();
    }

    @Override
    public void liberer() {
        bien.liberer();
    }

    @Override
    public void mettreEnMaintenance() {
        bien.mettreEnMaintenance();
    }

    @Override
    public abstract String getType();
}
