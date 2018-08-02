package com.milenkobojanic.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.milenkobojanic.swoosh.R
import com.milenkobojanic.swoosh.model.Player
import com.milenkobojanic.swoosh.utility.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillButton.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClicked(view: View) {
        beginnerSkillButton.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishClicked(view: View) {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, getString(R.string.skill_finish_toast), Toast.LENGTH_SHORT).show()
        }
    }
}
