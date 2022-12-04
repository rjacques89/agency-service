package com.tmt.domain.entity;


import com.tmt.validator.EditGroup;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @SuperBuilder
public abstract class ID implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull(message = "mainUuid is mandatory", groups = {EditGroup.class})
    protected UUID mainUuid;

    protected Boolean published = false;


    @Version
    private int version;

    @CreationTimestamp
    protected LocalDateTime created;

    @UpdateTimestamp
    protected LocalDateTime edited;

    protected String creator;
    protected String editor;
}
