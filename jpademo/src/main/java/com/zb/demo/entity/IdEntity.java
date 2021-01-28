package com.zb.demo.entity;

import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class IdEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(
            name = "ID",
            length = 64,
            nullable = false,
            unique = true
    )
    protected String id = UUID.randomUUID().toString();

    public IdEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;

    }

    protected interface IDGenerator {
        String generateID();
    }
}