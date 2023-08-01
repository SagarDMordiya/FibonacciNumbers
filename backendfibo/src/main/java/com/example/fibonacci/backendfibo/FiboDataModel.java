package com.example.fibonacci.backendfibo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FiboDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fiboId;

    private Integer fiboIndex;

    private long fiboValue;

    @Override
    public String toString() {
        return "FiboDataModel [fiboId=" + fiboId + ", fiboIndex=" + fiboIndex + ", fiboValue=" + fiboValue + "]";
    }

    public FiboDataModel() {
    }

    public Long getFiboId() {
        return fiboId;
    }

    public void setFiboId(Long fiboId) {
        this.fiboId = fiboId;
    }

    public Integer getFiboIndex() {
        return fiboIndex;
    }

    public void setFiboIndex(Integer fiboIndex) {
        this.fiboIndex = fiboIndex;
    }

    public long getFiboValue() {
        return fiboValue;
    }

    public void setFiboValue(long fiboValue) {
        this.fiboValue = fiboValue;
    }

}
