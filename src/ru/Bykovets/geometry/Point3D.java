package ru.Bykovets.geometry;

public class Point3D extends Point implements Cloneable {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Point3D point3D = (Point3D) obj;
        return Double.compare(point3D.z, z) == 0;
    }


    @Override
    public Point3D clone() throws CloneNotSupportedException {
        return (Point3D) super.clone();
    }
}
