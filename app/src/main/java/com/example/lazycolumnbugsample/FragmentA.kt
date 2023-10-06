package com.example.lazycolumnbugsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentA : Fragment() {

    private fun navigateToFragmentB() {
        findNavController().navigate(R.id.action_fragmentA_to_fragmentB)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            val contents = List(size = 14, init = { it })

            setContent {
                val lazyListState = rememberLazyListState()

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan)
                ) {
                    LazyColumn(
                        state = lazyListState,
                        modifier = Modifier
                            .safeDrawingPadding()
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(contents) {
                            Row(
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .background(Color.White)
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                                    .height(200.dp)
                                    .clickable(onClick = ::navigateToFragmentB),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Index = $it")
                            }
                        }
                    }
                }
            }
        }
    }
}