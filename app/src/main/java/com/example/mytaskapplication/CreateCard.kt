package com.example.mytaskapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.mytaskapplication.databinding.ActivityCreateCardBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class CreateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    private lateinit var binding: ActivityCreateCardBinding

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        binding.saveButton.setOnClickListener {
            val title = binding.createTitle.text.toString()
            val priority = binding.createPriority.text.toString()
            val description = binding.createDescription.text.toString()
            val date = binding.createDate.text.toString()

            if (title.isNotBlank() && priority.isNotBlank()){
                DataObject.setData(title,priority,description, date )
                GlobalScope.launch {
                    database.dao().insertTask(Entity(0,title,priority,description,date))
                }
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                }
            else{
                Toast.makeText(this,"Please enter title and priority",Toast.LENGTH_SHORT).show()


            }
        }
    }
}