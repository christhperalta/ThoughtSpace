package com.horizontech.thoughtspace.features.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.horizontech.thoughtspace.R
import com.horizontech.thoughtspace.features.presentation.componentes.ThoughtSpaceButton
import com.horizontech.thoughtspace.features.presentation.componentes.ThoughtSpaceCard
import com.horizontech.thoughtspace.features.presentation.componentes.ThoughtSpaceText

@Composable
fun HomeScreen(
    onNavigateToJournal : ()-> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Box(
            Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxSize()
        ) {

            ThoughtSpaceText(
                modifier = Modifier.align(alignment = Alignment.TopCenter).offset(y = 50.dp),
                text = "Thought Space",
                style = MaterialTheme.typography.headlineLarge
            )

            Column(
                modifier = Modifier.align(alignment = Alignment.Center),
            ) {
                ThoughtSpaceCard(
                    title = stringResource(R.string.home_journal_card_title),
                    subTitle = "Last edited: 7 Nov, 24",
                    image = R.drawable.journal_img,
                    containerColor = Color(0xFFE0E3EB)
                ){onNavigateToJournal()}
                Spacer(modifier = Modifier.height(20.dp))
                ThoughtSpaceCard(
                    title = stringResource(R.string.home_quick_notes_card_title),
                    subTitle = "Last edited: 7 Nov, 24",
                    image = R.drawable.quick_note_img,
                    containerColor = Color(0xFFDAE2D8)
                ){}
                Spacer(modifier = Modifier.height(20.dp))
                ThoughtSpaceCard(
                    title = stringResource(R.string.home_goal_card_title),
                    subTitle = "Last edited: 7 Nov, 24",
                    image = R.drawable.journal_img,
                    containerColor = Color(0xFFF1E7D3)
                ){}
            }

            ThoughtSpaceButton(
                modifier = Modifier.align(alignment = Alignment.BottomCenter),
                text = stringResource(R.string.home_button_text)
            ) {}

        }
    }
}

@Composable
fun HomeScreenContainer () {
    HomeScreen(onNavigateToJournal = {})
}


@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreenContainer()
}