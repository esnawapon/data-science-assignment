package swe690.causesofdeath;

import java.util.Objects;

public class CodRecord implements Comparable<CodRecord> {
    private Integer time;
    private String geo;
    private String sex;
    private String icd10;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10;
    }

    @Override
    public String toString() {
        return "CodRecord{" +
                "time=" + time +
                ", geo='" + geo + '\'' +
                ", sex='" + sex + '\'' +
                ", icd10='" + icd10 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodRecord that = (CodRecord) o;
        return time.equals(that.time) &&
                geo.equals(that.geo) &&
                sex.equals(that.sex) &&
                icd10.equals(that.icd10);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, geo, sex, icd10);
    }

    @Override
    public int compareTo(CodRecord o) {
        if (o == null) return -1;
        if (this.equals(o)) return 0;
        if (!time.equals(o.time)) return time.compareTo(o.time);
        if (!geo.equals(o.geo)) return geo.compareTo(o.geo);
        if (!sex.equals(o.sex)) return sex.compareTo(o.sex);
        return icd10.compareTo(o.icd10);
    }
}
