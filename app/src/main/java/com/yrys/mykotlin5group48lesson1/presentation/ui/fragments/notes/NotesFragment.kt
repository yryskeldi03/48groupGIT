package com.yrys.mykotlin5group48lesson1.presentation.ui.fragments.notes

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yrys.mykotlin5group48lesson1.R
import com.yrys.mykotlin5group48lesson1.databinding.FragmentNotesBinding
import com.yrys.mykotlin5group48lesson1.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : BaseFragment(R.layout.fragment_notes) {
    private val viewModel by viewModels<NotesViewModel>()
    private val notesAdapter by lazy { NotesAdapter() }
    private val binding by viewBinding(FragmentNotesBinding::bind)

    override fun initialize() {
        setupNoteRecycler()
    }

    override fun setupListeners() {
        binding.btnAddEditNote.setOnClickListener {
            findNavController().navigate(
                R.id.action_notesFragment_to_addEditNoteFragment
            )
        }
    }

    override fun setupRequests() {
        viewModel.getNotes()
    }

    override fun setupSubscribers() {
        viewModel.getNotesState.collectState(
            onLoading = {
                binding.progress.isVisible = true
            },
            onError = {
                binding.progress.isVisible = false
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                binding.progress.isVisible = false
                notesAdapter.submitList(it)
            }
        )
    }

    private fun setupNoteRecycler() = with(binding.rvNotes) {
        adapter = notesAdapter
        layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

}