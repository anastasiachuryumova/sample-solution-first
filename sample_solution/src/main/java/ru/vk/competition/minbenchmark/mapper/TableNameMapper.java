package ru.vk.competition.minbenchmark.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vk.competition.minbenchmark.dto.TableNameDto;
import ru.vk.competition.minbenchmark.model.TableName;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface TableNameMapper {

    @Mapping(target = "primaryKey", source = "entity.primaryKey")
    @Mapping(target = "tableName", source = "entity.tableName")
    TableNameDto toDto(TableName entity);

    @Mapping(target = "primaryKey", source = "dto.primaryKey")
    @Mapping(target = "tableName", source = "dto.tableName")
    TableName toEntity(TableNameDto dto);

    default List<TableNameDto> toDtos (List<TableName> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<TableNameDto> toOptionalDto (Optional<TableName> entity) {
        return entity.map(this::toDto);
    }
}
