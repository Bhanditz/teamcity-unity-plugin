/*
 * Copyright 2000-2019 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See LICENSE in the project root for license information.
 */

package jetbrains.buildServer.unity.logging

class PlayerStatisticsBlock : LogBlock {

    override val name = "Player statistics"

    override val logFirstLine = LogType.Outside

    override val logLastLine = LogType.Outside

    override fun isBlockStart(text: String) = blockStart.containsMatchIn(text)

    override fun isBlockEnd(text: String) = blockEnd.containsMatchIn(text)

    override fun getText(text: String) = text

    companion object {
        private val blockStart = Regex("\\*\\*\\*Player size statistics\\*\\*\\*")
        private val blockEnd = Regex("Unloading.*")
    }
}