package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()  // Первое значение кости будет случайным
        val rollButton: Button = findViewById(R.id.button2) // Кнопка нажимается
        rollButton.setOnClickListener { rollDice() }        // и мы запускаем алгоритм
    }
    /*
    ** Задаем кол-во поверхностей кубика, крутим его
    ** и выводим итог на экран
    */
    private fun rollDice() {
        val dice = Dice(6)  // Создаем класс, возвращающий случайное число до 6
        val diceRoll = dice.roll()    // Крутим кость
        val diceImage: ImageView = findViewById(R.id.imageView) // Создаем значение картинки
        val drawableResource = when (diceRoll) {                // Привсваеваем ей картинку
            1 -> R.drawable.dice_1                              // в папке drawable
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString() // Описание к каждой картинке
    }                                                      // для людей с ОВЗ
}

/*
** Класс получает кол-во граней и может возвращать рандомное
** число в этом промежутке от 1 до numSides
*/
class Dice(private val numSides: Int) { fun roll(): Int {return (1..numSides).random()} }