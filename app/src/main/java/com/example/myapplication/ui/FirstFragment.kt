package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*
import org.koin.android.ext.android.inject


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: MainViewModel by inject()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var layoutManager: RecyclerView.LayoutManager? = null

    private lateinit var adapter: MainRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        /*  val toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
          val toolbar2 = view?.findViewById<Toolbar>(R.id.toolbar2)
          toolbar2?.visibility = View.GONE
          (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

          (activity as? AppCompatActivity)?.supportActionBar?.show()*/
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)

        }
        val onClickListener = MainRecyclerViewAdapter.OnClickListener {
            val bundle = Bundle()
            bundle.putString("firstName", it.firstName)
            bundle.putString("lastName", it.lastName)
            bundle.putString("phone", it.phone)
            bundle.putString("email", it.email)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
        adapter = MainRecyclerViewAdapter(arrayListOf(), onClickListener = onClickListener)
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(DividerItemDecoration(this.activity, LinearLayout.VERTICAL))

        viewModel.fetchContacts(requireContext())
        observeFromViewModal(adapter)


    }

    private fun observeFromViewModal(adapter: MainRecyclerViewAdapter) {
        viewModel.contacts.observe(requireActivity()) { contact ->
            adapter.loadData(contact)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}