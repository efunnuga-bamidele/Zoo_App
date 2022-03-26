package com.bjtmtechnologies.zooapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Load animals
        listOfAnimals.add(Animal("Baboon", "Baboon lives in places with big trees.", R.drawable.baboon, false))
        listOfAnimals.add(Animal("Bulldog", "Bull lives in with humans, as they are man's best friends.", R.drawable.bulldog, false))
        listOfAnimals.add(Animal("Panda", "Panda lives in the forest with bamboo trees present.", R.drawable.panda, false))
        listOfAnimals.add(Animal("Swallow Bird", "Swallow bird lives in tall and big trees.", R.drawable.swallow_bird, false))
        listOfAnimals.add(Animal("White Tiger", "White tiger lives in dens deep in the forest.", R.drawable.white_tiger, true))
        listOfAnimals.add(Animal("Zebra", "Zebra lives in places with small trees with low grasses for grazing", R.drawable.zebra, false))

        adapter = AnimalsAdapter(this, listOfAnimals)
        txtListView.adapter = adapter
    }

    class AnimalsAdapter: BaseAdapter {
        var listOfAnimals = ArrayList<Animal>()
        var context: Context? = null
        constructor(context: Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }
        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//            var itemsLayout: LinearLayout
            val animal = listOfAnimals[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.animal_ticket, null)

            myView.imgViewAnimal.setImageResource(animal.image!!)
            myView.textViewName.text = animal.name!!
            myView.textViewDesc.text = animal.desc!!

            return myView


        }

    }
}