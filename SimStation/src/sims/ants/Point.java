package sims.ants;

import simstation.*;
import java.awt.*;
import java.util.*;
import mvc.*;

class Point {

    private int xc, yc;

    public Point(int xc, int yc) {
        super();
        this.xc = xc;
        this.yc = yc;
    }

    public int getXc() { return xc; }
    public int getYc() { return yc; }
    public void setXc(int xc) { this.xc = xc; }
    public void setYc(int xc) { this.yc = yc; }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + xc;
        result = prime * result + yc;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        if (xc != other.xc) return false;
        if (yc != other.yc) return false;
        return true;
    }
}