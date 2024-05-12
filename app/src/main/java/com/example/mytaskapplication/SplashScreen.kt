package com.example.mytaskapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreen : AppCompatActivity() {
    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        // Use coroutine to fetch tasks from the database in the background
        GlobalScope.launch(Dispatchers.IO) {
            val tasks = database.dao().getTask()

            // Once tasks are retrieved, update DataObject and start MainActivity
            withContext(Dispatchers.Main) {
                DataObject.listdata = tasks as MutableList<CardInfo>
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finish the SplashScreen activity
    }
}

/**package com.example.mytaskapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.room.Room

class SplashScreen : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        GlobalScope.launch {
            DataObject.listdata = database.dao().getTask() as MutableList<CardInfo>
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Finish the current activity after starting MainActivity
        }, 2000)
    }

}**/
/**package com.example.mytaskapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreen : AppCompatActivity() {
    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        GlobalScope.launch(Dispatchers.Main) {
            // Perform database operation in background
            val tasks = withContext(Dispatchers.IO) {
                database.dao().getTask()
            }

            // Update DataObject with the retrieved tasks
            DataObject.listdata = tasks as MutableList<CardInfo>

            // Launch MainActivity
            launchMainActivity()
        }
    }

    private fun launchMainActivity() {
        val intent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
        finish() // Optional: Finish the current activity after starting MainActivity
    }
}**/

/**package com.example.mytaskapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreen : AppCompatActivity() {
    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        // Use coroutine to fetch tasks from the database in the background
        GlobalScope.launch(Dispatchers.IO) {
            val tasks = database.dao().getTask()

            // Once tasks are retrieved, update DataObject and start MainActivity
            withContext(Dispatchers.Main) {
                DataObject.listdata = tasks as MutableList<CardInfo>
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finish the SplashScreen activity
    }
}**/

