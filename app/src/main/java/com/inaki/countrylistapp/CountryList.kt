package com.inaki.countrylistapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.ListFragment

class CountryList : ListFragment(), AdapterView.OnItemClickListener {

    // here we are setting our array of countries
    private val countries = arrayListOf(
        "India",
        "Pakistan",
        "US",
        "Japan",
        "China",
        "Mexico",
        "Brazil"
    )

    // property for the array adapter
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_list, container, false)

        // assigning our array adapter
        // creating array adapter with context, layout, data
        adapter = ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            countries
        )

        // setting adapter to the list adapter coming from list fragment
        listAdapter = adapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // assigning the click listener to the list view
        // this click listener is the one we are extending in the class header
        // AdapterView.OnItemClickListener
        // 'this' is making reference to that one
        listView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // this method is performing the action when you tap on any item on the list

        // here we are getting the country name listed in the given position
        val country = parent?.adapter?.getItem(position).toString()

        // we log in logcat
        Log.d("CountryFragment", "Item: $position")

        // displaying toast with the country name
        Toast.makeText(requireContext(), "Item: $country", Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CountryList()
    }
}