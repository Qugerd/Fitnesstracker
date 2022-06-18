package com.example.fitnesstracker.Data

import com.example.fitnesstracker.ListItem

import org.joda.time.DateTime

class DataActivityUsers {

    private val dateFormat = "dd.MM.YYYY"

    private val data = listOf<ListItem>(
        ListItem.Date(0, DateTime.now().toString(dateFormat)),
        ListItem.Card(1 , "322 км", "10 мин", "Бег", DateTime.now().toString(dateFormat), "@Он"),
        ListItem.Date(2, DateTime.now().toString(dateFormat)),
        ListItem.Card(3 , "1 км", "3 мин", "серфинг", DateTime.now().toString(dateFormat), "@она"),
        ListItem.Date(4, DateTime.now().toString(dateFormat)),
        ListItem.Card(5 , "12 км", "23 мин", "флекс", DateTime.now().toString(dateFormat), "@Путин")
    )

    fun getData() = data
}