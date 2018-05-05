package com.jasonbazen.bazenJaggedEdgeTest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class NonceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long nonce;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonceEntity that = (NonceEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nonce, that.nonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nonce);
    }

    @Override
    public String toString() {
        return "NonceEntity{" +
                "id=" + id +
                ", nonce=" + nonce +
                '}';
    }

}
