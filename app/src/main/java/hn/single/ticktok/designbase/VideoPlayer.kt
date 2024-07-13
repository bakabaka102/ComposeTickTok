package hn.single.ticktok.designbase

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

@UnstableApi
@Composable
fun VideoPlayer(modifier: Modifier = Modifier, player: Player) {

    AndroidView(factory = {
        PlayerView(it).also { playerView ->
            playerView.player = player
            playerView.useController = true
            playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
        }
    }, modifier = modifier)
}