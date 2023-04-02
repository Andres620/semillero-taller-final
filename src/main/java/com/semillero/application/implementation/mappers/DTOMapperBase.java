package com.semillero.application.implementation.mappers;

import java.util.List;

public abstract class DTOMapperBase<DTOType, DbModelType> {
    public abstract DTOType DbModelToDTOMapper(DbModelType input);

    public abstract DbModelType DTOToDbModelMapper(DTOType input);

    public abstract List<DTOType> DbModelToDTOMapper(List<DbModelType> input);

    public abstract List<DbModelType> DTOToDbModelMapper(List<DTOType> input);
}
