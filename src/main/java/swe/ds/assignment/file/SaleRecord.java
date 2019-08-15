package swe.ds.assignment.file;

import java.util.Objects;

public class SaleRecord implements Comparable<SaleRecord> {
    private int id;
    private String saleId;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ", " + saleId + ", " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleRecord record = (SaleRecord) o;
        return id == record.id &&
                Objects.equals(saleId, record.saleId) &&
                Objects.equals(name, record.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, saleId, name);
    }

    @Override
    public int compareTo(SaleRecord o) {
        if (this.equals(o)) return 0;
        return id - o.id;
    }
}
