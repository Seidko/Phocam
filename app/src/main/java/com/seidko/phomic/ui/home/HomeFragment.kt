package com.seidko.phomic.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.seidko.phomic.base.adapter.ConnectionRecyclerAdapter
import com.seidko.phomic.data.entities.Connection
import com.seidko.phomic.data.entities.ConnectionType
import com.seidko.phomic.databinding.FragmentPhomicBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentPhomicBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    @Suppress("MemberVisibilityCanBePrivate")
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        @Suppress("UNUSED_VARIABLE")
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentPhomicBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val connectionRecyclerView = binding.connectionRecyclerView
        val layoutManager = LinearLayoutManager(this.context)
        val connectionList = ArrayList<Connection>()
        connectionList.add(Connection(ConnectionType.USB, "Test USB"))
        connectionList.add(Connection(ConnectionType.WiFi, "Test WiFi"))
        connectionList.add(Connection(ConnectionType.Bluetooth, "Test Bluetooth"))

        connectionRecyclerView.adapter = ConnectionRecyclerAdapter(connectionList)
        connectionRecyclerView.layoutManager = layoutManager


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}