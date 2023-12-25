package com.example.tetris

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tetris.ui.theme.TetrisTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TetrisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameBoard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Привет, $name!",
        modifier = modifier
    )
}

@Composable
fun GameBoard() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(Color(0xFFFAAA02))
//        drawRoundRect(
//            Color.Blue, topLeft = Offset(50.dp.toPx(), 50.dp.toPx()),
//            size = Size(width = 100.dp.toPx(), 100.dp.toPx()),
//            cornerRadius = CornerRadius(x=10.dp.toPx(), 10.dp.toPx())
//        )
        drawScreen(this)

    }
}

@Composable
fun drawFigureLine() {
    val paint = Paint()
    paint.color = Color.Red
    paint.strokeWidth = 5f
}

fun drawScreen(scope: DrawScope): DrawScope {
    val sizeX = 25.dp
    val sizeY = 25.dp
    val outline = 3.dp
    var outlinePath: Path = Path()
    var innerOutlinePath: Path = Path()
    var path: Path = Path()
    var pathTwo: Path = Path()

    return scope.apply {
        outlinePath.moveTo(sizeX.toPx() - outline.toPx(), sizeY.toPx() - outline.toPx())
        outlinePath.lineTo(this.size.width - sizeX.toPx() + outline.toPx(), sizeY.toPx() - outline.toPx())
        outlinePath.lineTo(this.size.width - sizeX.toPx() + outline.toPx(), (this.size.height/3*2) - sizeY.toPx() + (outline.toPx()/2))
        outlinePath.lineTo(this.size.width - sizeX.toPx() * 3 + (outline.toPx()/2), sizeY.toPx() + this.size.height/3*2 + outline.toPx())
        outlinePath.lineTo(sizeX.toPx() - outline.toPx(), sizeY.toPx() + (this.size.height/3*2) + outline.toPx())

        path.moveTo(sizeX.toPx(), sizeY.toPx())
        path.lineTo(this.size.width - sizeX.toPx(), sizeY.toPx())
        path.lineTo(this.size.width - sizeX.toPx(), (this.size.height/3*2) - sizeY.toPx())
        path.lineTo(this.size.width - sizeX.toPx() * 3, sizeY.toPx() + this.size.height/3*2)
        path.lineTo(sizeX.toPx(), sizeY.toPx() + (this.size.height/3*2))

        pathTwo.moveTo(sizeX.toPx() * 2 + outline.toPx(), sizeY.toPx() * 2 + outline.toPx())
        pathTwo.lineTo(this.size.width - sizeX.toPx() * 2 - outline.toPx(), sizeY.toPx() * 2 + outline.toPx())
        pathTwo.lineTo(this.size.width - sizeX.toPx() * 2 - outline.toPx(), (this.size.height/3*2) - (sizeY.toPx() * 1.5).toFloat() - (outline.toPx()/2))
        pathTwo.lineTo(this.size.width - (sizeX.toPx() * 3.5).toFloat() - (outline.toPx()/2), (this.size.height/3*2) - (outline.toPx()))
        pathTwo.lineTo(sizeX.toPx() * 2 + outline.toPx(), (this.size.height/3*2) - outline.toPx())

        innerOutlinePath.moveTo(sizeX.toPx() * 2, sizeY.toPx() * 2)
        innerOutlinePath.lineTo(this.size.width - sizeX.toPx() * 2, sizeY.toPx() * 2)
        innerOutlinePath.lineTo(this.size.width - sizeX.toPx() * 2, (this.size.height/3*2) - (sizeY.toPx() * 1.5).toFloat())
        innerOutlinePath.lineTo(this.size.width - (sizeX.toPx() * 3.5).toFloat(), (this.size.height/3*2))
        innerOutlinePath.lineTo(sizeX.toPx() * 2, (this.size.height/3*2))

        drawPath(path=outlinePath, color=Color(0xFF0F0F0F))
        drawPath(path=path, color=Color(0xFF1A1A1A))
        drawPath(path=innerOutlinePath, color=Color(0xFF0F0F0F))
        drawPath(path=pathTwo, color=Color(0xFF373642))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TetrisTheme {
        Greeting("Android")
    }
}