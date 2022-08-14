package ru.vk.competition.minbenchmark.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vk.competition.minbenchmark.dto.TableNameDto;
import ru.vk.competition.minbenchmark.dto.TableNamePageDto;
import ru.vk.competition.minbenchmark.mapper.TableNameMapper;
import ru.vk.competition.minbenchmark.model.TableName;
import ru.vk.competition.minbenchmark.repository.TableNameRepository;
import ru.vk.competition.minbenchmark.service.TableNameService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableNameServiceImpl implements TableNameService {

    private final TableNameRepository tableNameRepository;
    private final TableNameMapper tableNameMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TableNameDto> findAll() {
        return tableNameMapper.toDtos(tableNameRepository.findAll());
    }

    @Override
    public TableNamePageDto getPage(Pageable pageable) {
        Page<TableName> currentPage = tableNameRepository.findAll(pageable);
        return new TableNamePageDto(tableNameMapper.toDtos(currentPage.getContent()),
                currentPage.getTotalPages(),
                currentPage.getNumber());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TableNameDto> getByPrimaryKey(@NotEmpty String primaryKey) {
        return tableNameMapper.toOptionalDto(tableNameRepository.findById(primaryKey));
    }

    @Override
    @Transactional
    public TableNameDto save(@Valid TableNameDto tableName) {
        return tableNameMapper.toDto(tableNameRepository.save(tableNameMapper.toEntity(tableName)));
    }

    @Override
    @Transactional
    public void deleteByPrimaryKey (@NotEmpty String primaryKey) {
        tableNameRepository.deleteById(primaryKey);
    }

    @Override
    @Transactional
    public void delete (@Valid TableName tableName) {
        tableNameRepository.delete(tableName);
    }
}
