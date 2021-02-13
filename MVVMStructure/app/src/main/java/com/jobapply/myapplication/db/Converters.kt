package com.jobapply.myapplication.db

import androidx.room.TypeConverter
import com.jobapply.myapplication.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }


}