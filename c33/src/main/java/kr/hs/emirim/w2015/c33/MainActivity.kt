package kr.hs.emirim.w2015.c33

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val todos = mutableListOf<String>()
    lateinit var adapter : ArrayAdapter<String>
    lateinit var listView:ListView
    lateinit var editText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.main_list)
        editText = findViewById(R.id.edit)
        button = findViewById(R.id.button)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            todos
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            AlertDialog.Builder(this)
                .setTitle("remove todo")
                .setPositiveButton("OK"){dialog,which ->
                    todos.removeAt(i)
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("Cancel",null)
                .create()
                .show()
        }
        button.setOnClickListener{
            todos.add(editText.text.toString())
            editText.text.clear()
            adapter.notifyDataSetChanged()
        }
    }
}