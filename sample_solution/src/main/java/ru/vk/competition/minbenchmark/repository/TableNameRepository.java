package ru.vk.competition.minbenchmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.vk.competition.minbenchmark.model.TableName;

@RepositoryRestResource(path = "tableNames")
public interface TableNameRepository extends JpaRepository <TableName, String> {
}
