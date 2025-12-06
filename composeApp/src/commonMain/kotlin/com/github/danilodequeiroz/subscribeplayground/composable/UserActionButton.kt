package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import com.github.danilodequeiroz.subscribeplayground.composable.state.UserActionState
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import subscribeplayground.composeapp.generated.resources.Res
import subscribeplayground.composeapp.generated.resources.button_follow
import subscribeplayground.composeapp.generated.resources.button_following

@Composable
fun UserActionButton(
    state: UserActionState,
    onClick: () -> Unit
) {
    val buttonText: String
    val buttonColors: ButtonColors

    when (state) {
        UserActionState.FOLLOWING -> {
            buttonText = stringResource(Res.string.button_following)
            buttonColors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
        UserActionState.FOLLOW -> {
            buttonText = stringResource(Res.string.button_follow)
            buttonColors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        else -> {
            buttonText = stringResource(Res.string.button_follow)
            buttonColors = ButtonDefaults.buttonColors()
        }
    }

    Button(
        onClick = onClick,
        colors = buttonColors,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.height(36.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
    ) {
        Text(text = buttonText, style = MaterialTheme.typography.labelMedium)
    }
}

@Preview
@Composable
fun UserActionButton_Follow_Preview(){
    PlayGroundTheme {
        UserActionButton(
            state = UserActionState.FOLLOW,
            onClick = {}
        )
    }
}


@Preview
@Composable
fun UserActionButton_Following_Preview(){
    PlayGroundTheme {
        UserActionButton(
            state = UserActionState.FOLLOWING,
            onClick = {}
        )
    }
}