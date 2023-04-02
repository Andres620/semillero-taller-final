package com.semillero.controllers.mappers;

import java.util.List;

public abstract class ModelMapperBase<Json, DTOType>  {
    
    public abstract Json DTOToModelMapper(DTOType input);

    public abstract DTOType ModelToDTOMapper(Json input);

    public abstract List<Json> DTOToModelMapper(List<DTOType> input);

    public abstract List<DTOType> ModelToDTOMapper(List<Json> input);
}

// public abstract class ModelMapperBase<ModelType, DTOType>  {
    
//     public abstract ModelType DTOToModelMapper(DTOType input);

//     public abstract DTOType ModelToDTOMapper(ModelType input);

//     public abstract List<ModelType> DTOToModelMapper(List<DTOType> input);

//     public abstract List<DTOType> ModelToDTOMapper(List<ModelType> input);
// }

