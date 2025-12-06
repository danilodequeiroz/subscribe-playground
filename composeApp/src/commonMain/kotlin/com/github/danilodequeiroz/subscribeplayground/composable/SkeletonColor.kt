package com.github.danilodequeiroz.subscribeplayground.composable

import androidx.compose.ui.graphics.Color
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.github.danilodequeiroz.subscribeplayground.PlayGroundTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import subscribeplayground.composeapp.generated.resources.Res
import subscribeplayground.composeapp.generated.resources.shimmer_transition

val SkeletonColor = Color(0xFFE0E0E0)
val DarkSkeletonColor = Color(0xFF3A3A3A)

@Composable
fun UserListItemSkeleton(isDarkTheme: Boolean) {
    
    val baseColor = if (isDarkTheme) DarkSkeletonColor else SkeletonColor

    val transition = rememberInfiniteTransition(label = stringResource(Res.string.shimmer_transition))

    val alpha by transition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val shimmerColor = baseColor.copy(alpha = alpha)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(shimmerColor)
        )

        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(shimmerColor)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(12.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(shimmerColor)
            )
        }
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(36.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(shimmerColor)
        )
    }
}

@Preview
@Composable
fun UserListItemSkeleton_Preview(){
    PlayGroundTheme {
        UserListItemSkeleton(
            isDarkTheme = false
        )
    }
}