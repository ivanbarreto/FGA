package com.mathewsachin.fategrandautomata.scripts.models

import com.mathewsachin.libautomata.Location
import com.mathewsachin.libautomata.Region

sealed class CommandCard(
    val clickLocation: Location,
    val servantMatchRegion: Region,
    val servantCropRegion: Region
) {
    abstract val supportCheckRegion: Region

    class Face private constructor(
        val index: Int,
        clickLocation: Location,
        // see docs/card_affinity_regions.png
        val affinityRegion: Region,
        // see docs/card_type_regions.png
        val typeRegion: Region,
        servantMatchRegion: Region,
        servantCropRegion: Region
    ) : CommandCard(
        clickLocation,
        servantMatchRegion,
        servantCropRegion
    ) {
        companion object {
            val list = listOf(
                Face(
                    index = 1,
                    clickLocation = Location(300+120, 1000),
                    affinityRegion = Region(295+120, 650, 250, 200),
                    typeRegion = Region(0+120, 1060, 512, 200),
                    servantMatchRegion = Region(106+200, 800, 300, 200),
                    servantCropRegion = Region(200+120, 890, 115, 85)
                ),
                Face(
                    index = 2,
                    clickLocation = Location(750+120, 1000),
                    affinityRegion = Region(810+120, 650, 250, 200),
                    typeRegion = Region(512+120, 1060, 512, 200),
                    servantMatchRegion = Region(620+200, 800, 300, 200),
                    servantCropRegion = Region(714+120, 890, 115, 85)
                ),
                Face(
                    index = 3,
                    clickLocation = Location(1300+120, 1000),
                    affinityRegion = Region(1321+120, 650, 250, 200),
                    typeRegion = Region(1024+120, 1060, 512, 200),
                    servantMatchRegion = Region(1130+200, 800, 300, 200),
                    servantCropRegion = Region(1224+120, 890, 115, 85)
                ),
                Face(
                    index = 4,
                    clickLocation = Location(1800+120, 1000),
                    affinityRegion = Region(1834+120, 650, 250, 200),
                    typeRegion = Region(1536+120, 1060, 512, 200),
                    servantMatchRegion = Region(1644+200, 800, 300, 200),
                    servantCropRegion = Region(1738+120, 890, 115, 85)
                ),
                Face(
                    index = 5,
                    clickLocation = Location(2350+120, 1000),
                    affinityRegion = Region(2348+120, 650, 250, 200),
                    typeRegion = Region(2048+120, 1060, 512, 200),
                    servantMatchRegion = Region(2160+200, 800, 300, 200),
                    servantCropRegion = Region(2254+120, 890, 115, 85)
                )
            )
        }

        override val supportCheckRegion = affinityRegion + Location(-50, 100)

        override fun toString() = "$index"
    }

    class NP private constructor(
        clickLocation: Location,
        val autoSkillCode: Char,
        servantMatchRegion: Region,
        servantCropRegion: Region
    ) : CommandCard(
        clickLocation,
        servantMatchRegion,
        servantCropRegion
    ) {
        companion object {
            val list = listOf(
                NP(
                    clickLocation = Location(1000-80, 220),
                    autoSkillCode = '4',
                    servantMatchRegion = Region(778, 190, 300, 200),
                    servantCropRegion = Region(712, 290, 115, 65)
                ),
                NP(
                    clickLocation = Location(1300, 400),
                    autoSkillCode = '5',
                    servantMatchRegion = Region(1238, 190, 300, 200),
                    servantCropRegion = Region(1350, 290, 115, 65)
                ),
                NP(
                    clickLocation = Location(1740+80, 400),
                    autoSkillCode = '6',
                    servantMatchRegion = Region(1606+180, 190, 300, 200),
                    servantCropRegion = Region(1694+180, 290, 115, 65)
                )
            )
        }

        override val supportCheckRegion = (servantMatchRegion + Location(110, 0))
            .copy(Height = 110)

        override fun toString() = "$autoSkillCode"
    }
}