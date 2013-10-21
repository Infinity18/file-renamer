package by.infinity18.file_renamer.view;

import java.awt.*;

import static java.awt.GridBagConstraints.*;

/**
* @author Evgeniy Myslovets
* @date 21.10.13
*/
class GridBagBucket {
    private int gridX;
    private int gridY;
    private int gridWidth;
    private int gridHeight;
    private int weightX;
    private int weightY;
    private int anchor;
    private int fill;
    private int ipadX;
    private int ipadY;
    private Insets insets;

    public GridBagBucket() {
        this.gridX = RELATIVE;
        this.gridY = RELATIVE;
        this.gridWidth = 1;
        this.gridHeight = 1;

        this.weightX = 0;
        this.weightY = 0;
        this.anchor = CENTER;
        this.fill = NONE;

        this.insets = new Insets(0, 0, 0, 0);
        this.ipadX = 0;
        this.ipadY = 0;
    }

    public GridBagBucket withGridX(int gridX) {
        this.gridX = gridX;
        return this;
    }

    public GridBagBucket withGridY(int gridY) {
        this.gridY = gridY;
        return this;
    }

    public GridBagBucket withGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
        return this;
    }

    public GridBagBucket withGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
        return this;
    }

    public GridBagBucket withWeightX(int weightX) {
        this.weightX = weightX;
        return this;
    }

    public GridBagBucket withWeightY(int weightY) {
        this.weightY = weightY;
        return this;
    }

    public GridBagBucket withAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    public GridBagBucket withFill(int fill) {
        this.fill = fill;
        return this;
    }

    public GridBagBucket withInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    public GridBagBucket withIpadX(int ipadX) {
        this.ipadX = ipadX;
        return this;
    }

    public GridBagBucket withIpadY(int ipadY) {
        this.ipadY = ipadY;
        return this;
    }

    public GridBagConstraints toConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = this.gridX;
        gbc.gridy = this.gridY;
        gbc.gridwidth = this.gridWidth;
        gbc.gridheight = this.gridHeight;

        gbc.weightx = this.weightX;
        gbc.weighty = this.weightY;
        gbc.anchor = this.anchor;
        gbc.fill = this.fill;

        gbc.insets = this.insets;
        gbc.ipadx = this.ipadX;
        gbc.ipady = this.ipadY;
        return gbc;
    }
}
