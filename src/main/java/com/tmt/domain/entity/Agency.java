package com.tmt.domain.entity;

import com.tmt.domain.request.CreateAgency;
import com.tmt.utils.CustomBeanUtils;
import com.tmt.validator.CreateGroup;
import com.tmt.validator.EditGroup;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Agency extends ID {

    @NotNull(message = "Code is mandatory", groups = {CreateGroup.class})
    @Column(unique = true)
    private String code;

    @NotNull(message = "First Name is mandatory", groups = {CreateGroup.class})
    @Length(min = 3, max = 30, message = "Firstname length invalid (Mi:3,  Max: 30)", groups = {CreateGroup.class})
    private String name;

    @NotNull(message = "Last Name is mandatory", groups = {CreateGroup.class})
    private String address;

    private String picture;

    @ElementCollection(fetch = FetchType.EAGER)
    @NotNull(message = "Email is mandatory", groups = {CreateGroup.class})
    private Set<String> emails;

    @ElementCollection(fetch = FetchType.EAGER)
    @NotNull(message = "Email is mandatory", groups = {CreateGroup.class})
    private Set<String> phones;

    @Length(min = 3, max = 300, message = "Firstname length invalid (Mi:3,  Max: 300)",
            groups = {CreateGroup.class, EditGroup.class})
    private String about;

    public Agency(CreateAgency dto) {
        CustomBeanUtils.copyPropertiesIgnoreNull(dto, this);
    }

}
