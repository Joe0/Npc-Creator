package com.joepritzel.npccreator.model
import com.joepritzel.npccreator.util.Config

class NPCDef(val name: String, val description: String, val command: String, val stats: Array[Int], val attackable: Boolean, val aggressive: Boolean, val respawnTime: Int, val sprites: Array[Int], val colors: Array[Int], val camera1: Int, val camera2: Int, val walkModel: Int, val combatModel: Int, val combatSprite: Int, val drops: Array[ItemDropDef]) {
  override def toString = {
    val sb = new StringBuilder("\t<NPCDef>\n")
    sb.append("\t\t<name>").append(name).append("</name>\n")
    sb.append("\t\t").append("<description>").append(description).append("</description>\n")
    sb.append("\t\t<command>").append(command).append("</command>\n")
    
    Config.STAT_NAMES.foldLeft(0) {
      (index, stat) =>
      sb.append("\t\t<").append(stat).append(">").append(stats(index)).append("</").append(stat).append(">\n")
      index + 1
    }
    
    sb.append("\t\t<aggressive>").append(aggressive).append("</aggressive>\n")
    sb.append("\t\t<respawnTime>").append(respawnTime).append("</respawnTime>\n")
    
    sb.append("\t\t<sprites>\n")
    sprites.foreach {
      sprite =>
        sb.append("\t\t\t<int>").append(sprite).append("</int>\n")
    }
    sb.append("\t\t</sprites>\n")
    
    Config.COLORS.foldLeft(0) {
      (index, color) =>
      sb.append("\t\t<").append(color).append(">").append(colors(index)).append("</").append(color).append(">\n")
      index + 1
    }
    
    sb.append("\t\t<camera1>").append(camera1).append("</camera1>\n")
    sb.append("\t\t<camera2>").append(camera2).append("</camera2>\n")
    sb.append("\t\t<walkModel>").append(walkModel).append("</walkModel>\n")
    sb.append("\t\t<combatModel>").append(combatModel).append("</combatModel>\n")
    sb.append("\t\t<combatSprite>").append(combatSprite).append("</combatSprite>\n")
    
    sb.append("\t\t<drops>\n")
    
    drops.foreach {
      drop =>
        sb.append("\t\t\t").append("<ItemDropDef>\n")
        sb.append("\t\t\t\t").append("<id>").append(drop.id).append("</id>\n")
        sb.append("\t\t\t\t").append("<amount>").append(drop.amount).append("</amount>\n")
        sb.append("\t\t\t\t").append("<weight>").append(drop.weight).append("</weight>\n")
        sb.append("\t\t\t").append("</ItemDropDef>\n")
    }
    sb.append("\t\t</drops>\n")
    sb.append("\t</NPCDef>\n")
    
    sb.toString
  }
}