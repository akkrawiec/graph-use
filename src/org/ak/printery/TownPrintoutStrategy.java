package org.ak.printery;

/**
 */
public class TownPrintoutStrategy extends PrintoutAbstractStrategy {

    public TownPrintoutStrategy(String name, String content) {
        super(name, content);
    }

    @Override
    public Printout execute() {
        return (new Printout.Builder(this.getName())).withContent(this.getContent()).build();
    }
}
