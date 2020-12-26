package com.mathewsachin.fategrandautomata.scripts.models

import com.mathewsachin.libautomata.Location

sealed class Skill(
    val clickLocation: Location,
    val autoSkillCode: Char
) {
    class Servant private constructor(
        clickLocation: Location,
        autoSkillCode: Char
    ) : Skill(clickLocation, autoSkillCode) {
        companion object {
            val list = listOf(
                Servant(Location(241, 1155), 'a'),
                Servant(Location(420, 1155), 'b'),
                Servant(Location(600, 1155), 'c'),

                Servant(Location(875, 1155), 'd'),
                Servant(Location(1050, 1155), 'e'),
                Servant(Location(1230, 1155), 'f'),

                Servant(Location(1500, 1155), 'g'),
                Servant(Location(1700, 1155), 'h'),
                Servant(Location(1865, 1155), 'i')
            )
        }
    }

    class Master private constructor(
        clickLocation: Location,
        autoSkillCode: Char
    ) : Skill(clickLocation, autoSkillCode) {
        companion object {
            val list = listOf(
                Master(Location(2075, 620), 'j'),
                Master(Location(2260, 620), 'k'),
                Master(Location(2435, 620), 'l')
            )
        }
    }
}