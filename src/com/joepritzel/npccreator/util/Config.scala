package com.joepritzel.npccreator.util
import java.io.File

object Config {
  lazy val DATA_FOLDER = "data" + File.separator
  lazy val SERVER = "server" + File.separator
  lazy val DEFS = "defs" + File.separator
  lazy val STAT_NAMES = List("attack", "strength", "hits", "defense")
  lazy val COLORS = List("hairColour", "topColour", "bottomColour", "skinColour")
}