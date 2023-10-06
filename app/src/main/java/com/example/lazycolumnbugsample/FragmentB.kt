package com.example.lazycolumnbugsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class FragmentB : Fragment() {

    private fun goBackToFragmentA() {
        val navController = findNavController()

        if (isDestinationInBackStack(destinationId = R.id.fragmentA, navController = navController)) {
            navController.popBackStack()
        } else {
            navController.navigate(R.id.action_fragmentB_to_fragmentA)
        }

    }

    private fun isDestinationInBackStack(@IdRes destinationId: Int, navController: NavController): Boolean {
        val backStack = navController.currentBackStack.value
        return backStack.any { it.destination.id == destinationId }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green)
                ) {
                    Button(
                        onClick = ::goBackToFragmentA,
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(
                            text = "Go back to A"
                        )
                    }
                }
            }
        }
    }
}