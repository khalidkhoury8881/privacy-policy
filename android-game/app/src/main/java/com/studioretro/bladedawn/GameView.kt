package com.studioretro.bladedawn

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.math.max

class GameView(context: Context) : SurfaceView(context), Runnable {
    private val holderRef: SurfaceHolder = holder
    @Volatile private var running = true

    private val bgPaint = Paint().apply { color = Color.rgb(18, 22, 34) }
    private val heroPaint = Paint().apply { color = Color.rgb(240, 240, 255) }
    private val enemyPaint = Paint().apply { color = Color.rgb(220, 70, 90) }
    private val groundPaint = Paint().apply { color = Color.rgb(60, 100, 70) }
    private val textPaint = Paint().apply {
        color = Color.WHITE
        textSize = 56f
        isFakeBoldText = true
    }

    private var heroX = 200f
    private var heroY = 600f
    private var velocityY = 0f
    private var score = 0
    private var gameOver = false

    private var enemyX = 1500f
    private val enemyY = 640f

    private val gravity = 1.4f
    private val jumpForce = -26f
    private val groundY = 700f

    init { Thread(this).start() }

    override fun run() {
        while (running) {
            update()
            drawFrame()
            Thread.sleep(16)
        }
    }

    private fun update() {
        if (gameOver) return

        velocityY += gravity
        heroY += velocityY

        if (heroY > groundY - 120f) {
            heroY = groundY - 120f
            velocityY = 0f
        }

        enemyX -= 16f
        if (enemyX < -80f) {
            enemyX = width + 500f
            score += 10
        }

        val hitX = heroX + 100f > enemyX && heroX < enemyX + 80f
        val hitY = heroY + 120f > enemyY && heroY < enemyY + 80f
        if (hitX && hitY) gameOver = true
    }

    private fun drawFrame() {
        if (!holderRef.surface.isValid) return
        val canvas: Canvas = holderRef.lockCanvas()
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), bgPaint)
        canvas.drawRect(0f, groundY, width.toFloat(), height.toFloat(), groundPaint)

        canvas.drawRect(heroX, heroY, heroX + 100f, heroY + 120f, heroPaint)
        canvas.drawRect(enemyX, enemyY, enemyX + 80f, enemyY + 80f, enemyPaint)

        canvas.drawText("Score: $score", 48f, 80f, textPaint)
        if (gameOver) {
            canvas.drawText("GAME OVER - Tap to restart", max(40f, width / 5f), 160f, textPaint)
        }

        holderRef.unlockCanvasAndPost(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            if (gameOver) {
                score = 0
                gameOver = false
                heroY = groundY - 120f
                velocityY = 0f
                enemyX = width + 300f
            } else if (heroY >= groundY - 120f) {
                velocityY = jumpForce
            }
        }
        return true
    }
}
