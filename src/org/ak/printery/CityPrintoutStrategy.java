package org.ak.printery;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class CityPrintoutStrategy extends PrintoutAbstractStrategy {
    private static final String BROCHURE_TEXT = "Brochure";
    private int brochures;


    public CityPrintoutStrategy(String name, String content, int brochures) {
        super(name, content);
        this.brochures = brochures;
    }

    public int getBrochures() {
        return brochures;
    }

    public void setBrochures(int brochures) {
        this.brochures = brochures;
    }

    @Override
    public Printout execute() {
        List<String> brochures = new ArrayList<String>();
        for (int i = 0; i < this.getBrochures(); i++) {
            brochures.add(BROCHURE_TEXT);
        }
        return (new Printout.Builder(this.getName())).withContent(this.getContent()).withBrochures(brochures).build();
    }
}