package com.example.myapplication.Data

import com.example.fitnesstracker.ListItem

import org.joda.time.DateTime

class DataActivityUsers {

    private val datePattern = "dd.MM.YYYY"

//    private val data = mapOf<Int, ListItem>(
//        7 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        8 to ListItem.Card(2 , "100 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
//        9 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        10 to ListItem.Card(2 , "150 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
//        11 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        12 to ListItem.Card(2 , "200 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
//    )

    private val data = listOf<ListItem>(
        ListItem.Date(0, DateTime.now().toString(datePattern)),
        ListItem.Card(1 , "322 км", "10 мин", "Бег", DateTime.now().toString(datePattern), "@Он"),
        ListItem.Date(2, DateTime.now().toString(datePattern)),
        ListItem.Card(3 , "1 км", "3 мин", "серфинг", DateTime.now().toString(datePattern), "@она"),
        ListItem.Date(4, DateTime.now().toString(datePattern)),
        ListItem.Card(5 , "12 км", "23 мин", "флекс", DateTime.now().toString(datePattern), "@Путин")
    )

    fun getData() = data

    //private fun getMaxId() = data.maxOf{it.id}

}