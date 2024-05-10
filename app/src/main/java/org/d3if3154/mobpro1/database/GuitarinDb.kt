package org.d3if3154.mobpro1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3154.mobpro1.model.Guitarin


@Database(entities = [Guitarin::class], version = 1, exportSchema = false)
abstract class GuitarinDb : RoomDatabase() {
    abstract val dao: GuitarinDao

    companion object {
        @Volatile
        private var INSTANCE: GuitarinDb? = null

        fun getInstance(context: Context): GuitarinDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GuitarinDb::class.java,
                        "guitarin.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}