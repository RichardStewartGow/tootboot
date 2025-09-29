package tootboot;

import java.awt.GridBagConstraints;

public class GBContraintConfig {
    private final int fill;
    private final int gridwidth;
    private final int gridheight;
    private final int weightx;
    private final int weighty;

    private GBContraintConfig(GBContraintConfigBuilder builder) {
        this.fill = builder.fill;
        this.gridwidth = builder.gridwidth;
        this.gridheight = builder.gridheight;
        this.weightx = builder.weightx;
        this.weighty = builder.weighty;
    }

    public GridBagConstraints make() {
        GridBagConstraints gbcons = new GridBagConstraints();
        gbcons.fill = this.fill;
        gbcons.gridwidth = this.gridwidth;
        gbcons.gridheight = this.gridheight;
        gbcons.weightx = this.weightx;
        gbcons.weighty = this.weighty;

        return gbcons;
    }


    public static class GBContraintConfigBuilder {
        private int fill;
        private int gridwidth;
        private int gridheight;
        private int weightx;
        private int weighty;

        public GBContraintConfigBuilder fill(int fill) {
            this.fill = fill;
            return this;
        }

        public GBContraintConfigBuilder gridwidth(int gridwidth) {
            this.gridwidth = gridwidth;
            return this;
        }

        public GBContraintConfigBuilder gridheight(int gridheight) {
            this.gridheight = gridheight;
            return this;
        }

        public GBContraintConfigBuilder weightx(int weightx) {
            this.weightx = weightx;
            return this;
        }

        public GBContraintConfigBuilder weighty(int weighty) {
            this.weighty = weighty;
            return this;
        }

        public GBContraintConfig build() {
            return new GBContraintConfig(this);
        }
    }
}