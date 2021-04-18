package com.base.project.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample_entity")
data class SampleEntity(

    @PrimaryKey
    @ColumnInfo(name = "databaseId")
    var id: String,
) {
}