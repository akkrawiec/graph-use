package org.ak.printery;

/**
 */
public class PrinterImpl implements Printer {
    private PrintoutStrategy strategy;

    public PrinterImpl(PrintoutStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        Printout printout = strategy.execute();
        result.append(printout.getName()).append(",").append(printout.getContent()).append(",").append(printout.getBrochures());
        return result.toString();
    }
}
