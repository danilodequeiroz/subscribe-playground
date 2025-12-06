package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import com.github.danilodequeiroz.subscribeplayground.composable.state.UserActionState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import subscribeplayground.composeapp.generated.resources.Res
import subscribeplayground.composeapp.generated.resources.compose_multiplatform
import subscribeplayground.composeapp.generated.resources.user_photo_content_description

@Composable
fun UserListItem(
    profileImageUrl: String,
    userName: String,
    subName: String,
    actionButtonState: UserActionState,
    onActionClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(resource = Res.drawable.compose_multiplatform),
            contentDescription = stringResource(Res.string.user_photo_content_description, userName),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = userName,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subName,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        UserActionButton(state = actionButtonState, onClick = onActionClicked)
    }
}

@Composable
@Preview
fun UserListItem_Preview(){
    PlayGroundTheme {
        UserListItem(
            profileImageUrl = "https://i.etsystatic.com/40317824/r/il/339134/4827441773/il_794xN.4827441773_887m.jpg",
            userName = "User name",
            subName = "Sub name",
            actionButtonState = UserActionState.FOLLOW,
            onActionClicked = {}
        )
    }
}