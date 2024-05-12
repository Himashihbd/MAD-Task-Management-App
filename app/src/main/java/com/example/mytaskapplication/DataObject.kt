package com.example.mytaskapplication

import android.icu.text.CaseMap.Title
import java.util.PrimitiveIterator

object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(title: String, priority: String, description: String,date: String){
        listdata.add(CardInfo(title, priority, description,date))

    }

    fun getAllData(): List<CardInfo>{
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }

    fun getData(pos:Int): CardInfo{
        return listdata[pos]
    }

    fun deleteData(pos: Int){
        listdata.removeAt(pos)
    }

    fun updateData(pos: Int,title: String,priority: String,description: String,date: String){
        listdata[pos].title=title
        listdata[pos].priority=priority
        listdata[pos].description=description
        listdata[pos].date=date
    }
}