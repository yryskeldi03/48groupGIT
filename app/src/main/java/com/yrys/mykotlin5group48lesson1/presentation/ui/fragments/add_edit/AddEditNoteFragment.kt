package com.yrys.mykotlin5group48lesson1.presentation.ui.fragments.add_edit

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yrys.mykotlin5group48lesson1.R
import com.yrys.mykotlin5group48lesson1.databinding.FragmentAddEditNoteBinding
import com.yrys.mykotlin5group48lesson1.domain.model.Note
import com.yrys.mykotlin5group48lesson1.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditNoteFragment : BaseFragment(R.layout.fragment_add_edit_note) {

    private val binding by viewBinding(FragmentAddEditNoteBinding::bind)
    private val viewModel by viewModels<AddEditNoteViewModel>()

    override fun setupListeners() {
        binding.btnSave.setOnClickListener {
            viewModel.createNote(
                Note(
                    title = binding.etTitle.text.toString(),
                    description = binding.etDescription.text.toString(),
                    createdAt = System.currentTimeMillis()
                )
            )
        }
    }

    override fun setupSubscribers() {
        viewModel.createNoteState.collectState(
            onLoading = {

            },
            onError = {

            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }

}