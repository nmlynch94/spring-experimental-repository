package com.example.demo.mappers;

import com.example.demo.domain.DomainObject;
import com.example.demo.dto.DTOObject;

public abstract class DomainToDtoMapper<A extends DomainObject, B extends DTOObject> {

    public abstract B toDTO(A domain);

    public abstract A toDomain(B dto);

}
