package com.bw.bean;

public class House {
    private int hid;
    private String address;
    private int purpose;
    private Double acreage;
    private String pic;
    private Owner owner;

    public House() {
    }

    public House(int hid, String address, int purpose, Double acreage, String pic, Owner owner) {
        this.hid = hid;
        this.address = address;
        this.purpose = purpose;
        this.acreage = acreage;
        this.pic = pic;
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getHid() {
        return hid;
    }

    public void setId(int hid) {
        this.hid = hid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "House{" +
                "hid=" + hid +
                ", address='" + address + '\'' +
                ", purpose=" + purpose +
                ", acreage=" + acreage +
                ", pic='" + pic + '\'' +
                ", owner=" + owner +
                '}';
    }
}
