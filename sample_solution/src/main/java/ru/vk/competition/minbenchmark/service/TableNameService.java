package ru.vk.competition.minbenchmark.service;

import org.springframework.data.domain.Pageable;
import ru.vk.competition.minbenchmark.dto.TableNameDto;
import ru.vk.competition.minbenchmark.dto.TableNamePageDto;
import ru.vk.competition.minbenchmark.model.TableName;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface TableNameService {
    List<TableNameDto> findAll();
    TableNamePageDto getPage(Pageable pageable);
    Optional<TableNameDto> getByPrimaryKey(@NotEmpty String primaryKey);
    TableNameDto save(@Valid TableNameDto tableName);
    void deleteByPrimaryKey (@NotEmpty String primaryKey);
    void delete(@Valid TableName tableName);
}
