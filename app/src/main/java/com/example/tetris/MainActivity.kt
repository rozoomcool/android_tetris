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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
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
        drawScreen(this)
//        drawPath(path=Path().apply {
//            this.lineTo(size.width, 0.dp.toPx())
//            this.lineTo(size.width, size.height,)
//            this.lineTo(0.dp.toPx(), size.height,)
//            this.lineTo(0.dp.toPx(), 0.dp.toPx(),)
//        }, color=Color(0xFFA17720), style = Stroke(width = 5.dp.toPx()))

    }
}

fun drawScreen(scope: DrawScope): DrawScope {
    val insetX = 25.dp
    val insetY = 25.dp
    val outline = 3.dp
    val rectSize: Float

    val outlinePath: Path = Path()
    val innerOutlinePath: Path = Path()
    val borderPath: Path = Path()
    val pathTwo: Path = Path()

    return scope.apply {
<<<<<<< Updated upstream
        drawPath(path = outlinePath.apply {
            rectSize = (size.width - (sizeX.toPx() * 2) - (outline.toPx() * 4)) / 10

            this.moveTo(sizeX.toPx() - outline.toPx(), sizeY.toPx() - outline.toPx())
            this.lineTo(size.width - sizeX.toPx() + outline.toPx(), sizeY.toPx() - outline.toPx())
            this.lineTo(
                size.width - sizeX.toPx() + outline.toPx(),
                (size.height / 3 * 2) - sizeY.toPx() + (outline.toPx() / 2)
            )
            this.lineTo(
                size.width - sizeX.toPx() * 3 + (outline.toPx() / 2),
                sizeY.toPx() + size.height / 3 * 2 + outline.toPx()
            )
            this.lineTo(
                sizeX.toPx() - outline.toPx(),
                sizeY.toPx() + (size.height / 3 * 2) + outline.toPx()
            )
        }, color = Color(0xFF0F0F0F))

        drawPath(path = borderPath.apply {
            this.moveTo(sizeX.toPx(), sizeY.toPx())
            this.lineTo(size.width - sizeX.toPx(), sizeY.toPx())
            this.lineTo(size.width - sizeX.toPx(), (size.height / 3 * 2) - sizeY.toPx())
            this.lineTo(size.width - sizeX.toPx() * 3, sizeY.toPx() + size.height / 3 * 2)
            this.lineTo(sizeX.toPx(), sizeY.toPx() + (size.height / 3 * 2))
        }, color = Color(0xFF1A1A1A))

        drawPath(path = innerOutlinePath.apply {
            this.moveTo(sizeX.toPx() * 2, sizeY.toPx() * 2)
            this.lineTo(size.width - sizeX.toPx() * 2, sizeY.toPx() * 2)
            this.lineTo(
                size.width - sizeX.toPx() * 2,
                (size.height / 3 * 2) - (sizeY.toPx() * 1.5).toFloat()
            )
            this.lineTo(size.width - (sizeX.toPx() * 3.5).toFloat(), (size.height / 3 * 2))
            this.lineTo(sizeX.toPx() * 2, (size.height / 3 * 2))
        }, color = Color(0xFF0F0F0F))

        drawPath(path = pathTwo.apply {
            this.moveTo(sizeX.toPx() * 2 + outline.toPx(), sizeY.toPx() * 2 + outline.toPx())
            this.lineTo(
                size.width - sizeX.toPx() * 2 - outline.toPx(),
                sizeY.toPx() * 2 + outline.toPx()
            )
            this.lineTo(
                size.width - sizeX.toPx() * 2 - outline.toPx(),
                (size.height / 3 * 2) - (sizeY.toPx() * 1.5).toFloat() - (outline.toPx() / 2)
            )
            this.lineTo(
                size.width - (sizeX.toPx() * 3.5).toFloat() - (outline.toPx() / 2),
                (size.height / 3 * 2) - (outline.toPx())
            )
            this.lineTo(sizeX.toPx() * 2 + outline.toPx(), (size.height / 3 * 2) - outline.toPx())
        }, color = Color(0xFF373642))

        size.height / 3

        repeat(10) {
            drawRect(
                Color.Red,
                topLeft = Offset(x = 54.dp.toPx() * (it+1), 54.dp.toPx()),
                size = Size(rectSize, rectSize)
            )

        }
=======
        drawPath(path=outlinePath.apply {
            this.moveTo(insetX.toPx() - outline.toPx(), insetY.toPx() - outline.toPx())
            this.lineTo(size.width - insetX.toPx() + outline.toPx(), insetY.toPx() - outline.toPx())
            this.lineTo(size.width - insetX.toPx() + outline.toPx(), (size.height/3*2) - insetY.toPx() + (outline.toPx()/2))
            this.lineTo(size.width - insetX.toPx() * 3 + (outline.toPx()/2), insetY.toPx() + size.height/3*2 + outline.toPx())
            this.lineTo(insetX.toPx() - outline.toPx(), insetY.toPx() + (size.height/3*2) + outline.toPx())
        }, color=Color(0xFF0F0F0F))

        drawPath(path=borderPath.apply {
            this.moveTo(insetX.toPx(), insetY.toPx())
            this.lineTo(size.width - insetX.toPx(), insetY.toPx())
            this.lineTo(size.width - insetX.toPx(), (size.height/3*2) - insetY.toPx())
            this.lineTo(size.width - insetX.toPx() * 3, insetY.toPx() + size.height/3*2)
            this.lineTo(insetX.toPx(), insetY.toPx() + (size.height/3*2))
        }, color=Color(0xFF1A1A1A))

        drawPath(path=innerOutlinePath.apply {
            this.moveTo(insetX.toPx() * 2, insetY.toPx() * 2)
            this.lineTo(size.width - insetX.toPx() * 2, insetY.toPx() * 2)
            this.lineTo(size.width - insetX.toPx() * 2, (size.height/3*2) - (insetY.toPx() * 1.5).toFloat())
            this.lineTo(size.width - (insetX.toPx() * 3.5).toFloat(), (size.height/3*2))
            this.lineTo(insetX.toPx() * 2, (size.height/3*2))
        }, color=Color(0xFF0F0F0F))

        drawPath(path=pathTwo.apply {
            this.moveTo(insetX.toPx() * 2 + outline.toPx(), insetY.toPx() * 2 + outline.toPx())
            this.lineTo(size.width - insetX.toPx() * 2 - outline.toPx(), insetY.toPx() * 2 + outline.toPx())
            this.lineTo(size.width - insetX.toPx() * 2 - outline.toPx(), (size.height/3*2) - (insetY.toPx() * 1.5).toFloat() - (outline.toPx()/2))
            this.lineTo(size.width - (insetX.toPx() * 3.5).toFloat() - (outline.toPx()/2), (size.height/3*2) - (outline.toPx()))
            this.lineTo(insetX.toPx() * 2 + outline.toPx(), (size.height/3*2) - outline.toPx())
        }, color=Color(0xFF373642))
>>>>>>> Stashed changes
    }
}

fun scoreBoard(scope: DrawScope){
    val insetX = 25.dp
    val insetY = 25.dp
    val outline = 3.dp

    scope.apply {
        drawPath(path=Path().apply {
            this.moveTo(insetX.toPx() * 2 + outline.toPx(), insetY.toPx() * 2 + outline.toPx())
            this.lineTo(size.width - insetX.toPx() * 2 - outline.toPx(), insetY.toPx() * 2 + outline.toPx())
            this.lineTo(size.width - insetX.toPx() * 2 - outline.toPx(), (size.height/3*2) - (insetY.toPx() * 1.5).toFloat() - (outline.toPx()/2))
            this.lineTo(size.width - (insetX.toPx() * 3.5).toFloat() - (outline.toPx()/2), (size.height/3*2) - (outline.toPx()))
            this.lineTo(insetX.toPx() * 2 + outline.toPx(), (size.height/3*2) - outline.toPx())
        }, color=Color(0xFFFFFFFF))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TetrisTheme {
        Greeting("Android")
    }
}