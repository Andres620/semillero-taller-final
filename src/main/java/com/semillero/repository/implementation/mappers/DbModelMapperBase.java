package com.semillero.repository.implementation.mappers;
import java.util.List;

public abstract class DbModelMapperBase<DbModelType, DatabaseType> {

    public abstract DbModelType DatabaseToDbModelMapper(DatabaseType input);

    public abstract DatabaseType DbModelToDatabaseMapper(DbModelType input);

    public abstract List<DbModelType> DatabaseToDbModelMapper(List<DatabaseType> input);

    public abstract List<DatabaseType> DbModelToDatabaseMapper(List<DbModelType> input);
}
