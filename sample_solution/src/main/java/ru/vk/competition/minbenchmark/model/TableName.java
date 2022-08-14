package ru.vk.competition.minbenchmark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TABLE_NAME")
public class TableName {

    @Id
    @NotEmpty
    @Column(name = "primaryKey", nullable = false, unique = true)
    private String primaryKey;

    @NotEmpty
    @Column(name = "tableName", nullable = false, unique = true)
    private String tableName;
}
