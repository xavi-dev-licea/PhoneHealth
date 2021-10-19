package com.xavidev.phonehealth.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xavidev.phonehealth.data.dao.*
import com.xavidev.phonehealth.data.entities.Charge
import com.xavidev.phonehealth.data.entities.Notification
import com.xavidev.phonehealth.data.entities.Reboot
import com.xavidev.phonehealth.data.entities.ScreenLock

@Database(
    entities = [Charge::class, ScreenLock::class, Notification::class, Reboot::class],
    exportSchema = false,
    version = 1,
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao
    abstract fun screenLockDao(): ScreenLockDao
    abstract fun rebootDao(): RebootDao
    abstract fun chargeDao(): ChargeDao
    abstract fun userDao(): UserDao
    abstract fun deviceDao(): DeviceDao

    companion object {
        private const val DATABASE_NAME = "health_db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context, AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}