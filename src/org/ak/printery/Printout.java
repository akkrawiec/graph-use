package org.ak.printery;

import java.util.List;

/**
 * Printout data
 */
public final class Printout {
    private final String name;
    private final String content;
    private final List<String> brochures;

    private Printout(Builder builder) {
        this.name = builder.name;
        this.content = builder.content;
        this.brochures = builder.brochures;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public List<String> getBrochures() {
        return brochures;
    }

    @Override
    public String toString() {
        return "Printout{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", brochures=" + brochures +
                '}';
    }

    public static class Builder {
        private final String name;
        private String content;
        private List<String> brochures;

        public Builder(String name) {
            if (name == null) {
                throw new IllegalArgumentException("name can not be null");
            }
            this.name = name;
        }

        public Builder withContent(String content) {
            this.content = content;
            return this;
        }

        public Builder withBrochures(List<String> brochures) {
            this.brochures = brochures;
            return this;
        }

        public Printout build() {
            return new Printout(this);
        }
    }
}
