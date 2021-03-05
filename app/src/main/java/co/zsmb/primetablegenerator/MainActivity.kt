package co.zsmb.primetablegenerator

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Primes() }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Primes() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFAD1457))
            .padding(8.dp),
        cells = GridCells.Fixed(10),
    ) {
        items(count = 100) { index ->
            PrimeSquare(offset = index * 10)
        }
    }
}

@Composable
fun PrimeSquare(offset: Int) {
    Box(
        Modifier
            .aspectRatio(1f)
            .padding(1.dp)
            .background(Color.DarkGray)
            .clipToBounds()
    ) {
        if ((offset + 1).isPrime()) One()
        if ((offset + 3).isPrime()) Three()
        if ((offset + 7).isPrime()) Seven()
        if ((offset + 9).isPrime()) Nine()
    }
}

// Not the smartest possible implementation
fun Int.isPrime(): Boolean {
    if (this < 2) return false
    return (2 until this).none { this % it == 0 }
}

@Composable fun One() = CornerLine(degrees = 0f)
@Composable fun Three() = CornerLine(degrees = -90f)
@Composable fun Seven() = CornerLine(degrees = -180f)
@Composable fun Nine() = CornerLine(degrees = -270f)

@Composable
fun CornerLine(degrees: Float) {
    Canvas(Modifier.fillMaxSize()) {
        rotate(degrees) {
            drawLine(
                color = Color.White,
                start = Offset.Zero,
                end = Offset(size.width / 2 + 2f, size.height / 2 + 2f),
                strokeWidth = 2.dp.toPx(),
            )
        }
    }
}
