package com.horizontech.thoughtspace.features.presentation.componentes


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.horizontech.thoughtspace.R

@Composable
fun ThoughtSpaceCard(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    containerColor: Color,
    @DrawableRes image: Int,
    onClick : () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable{onClick()},
        colors = CardDefaults.cardColors(containerColor = containerColor),
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(start = 20.dp, top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                ThoughtSpaceText(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
                ThoughtSpaceText(
                    text = subTitle,
                    style = MaterialTheme.typography.labelSmall
                )
            }

            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

@Composable
fun ThoughtSpaceCardContainer() {
    ThoughtSpaceCard(
        title = "Journal",
        subTitle = "Last edited: 13 Nov, 24",
        containerColor = MaterialTheme.colorScheme.background,
        image = R.drawable.journal_img
    ){}

}

@Preview(name = "ThoughtSpaceCard")
@Composable
private fun PreviewThoughtSpaceCard() {
    ThoughtSpaceCardContainer()
}