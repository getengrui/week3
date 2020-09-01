package com.bw.bean;

public class Middle {
    private int hid;
    private int oid;

    public Middle(int hid, int oid) {
        this.hid = hid;
        this.oid = oid;
    }

    public Middle() {
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "Middle{" +
                "hid=" + hid +
                ", oid=" + oid +
                '}';
    }
}
