package com.joepritzel.npccreator.model
import com.joepritzel.npccreator.util.Config

class NPCDef(val name: String, val description: String, val command: String, val stats: Array[Int], val attackable: Boolean, val aggressive: Boolean, val respawnTime: Int, val sprites: Array[Int], val colors: Array[Int], val camera1: Int, val camera2: Int, val walkModel: Int, val combatModel: Int, val combatSprite: Int, val drops: Array[ItemDropDef]) {
  override def toString = {
    val sb = new StringBuilder("<NPCDef>")
    sb.append("<name>").append(name).append("</name>")
    sb.append("<description>").append(description).append("</description>")
    sb.append("<command>").append(command).append("</command>")
    
    Config.STAT_NAMES.foldLeft(0) {
      (index, stat) =>
      sb.append("<").append(stat).append(">").append(stats(index)).append("</").append(stat).append(">")
      index + 1
    }
    
    sb.append("<aggressive>").append(aggressive).append("</aggressive>")
    sb.append("<respawnTime>").append(respawnTime).append("</respawnTime>")
    
    sb.append("<sprites>")
    sprites.foreach {
      sprite =>
        sb.append("<int>").append(sprite).append("</int>")
    }
    sb.append("</sprites>")
    
    Config.COLORS.foldLeft(0) {
      (index, color) =>
      sb.append("<").append(color).append(">").append(colors(index)).append("</").append(color).append(">")
      index + 1
    }
    
    sb.append("<camera1>").append(camera1).append("</camera1>")
    sb.append("<camera2>").append(camera2).append("</camera2>")
    sb.append("<walkModel>").append(walkModel).append("</walkModel>")
    sb.append("<combatModel>").append(combatModel).append("</combatModel>")
    sb.append("<combatSprite>").append(combatSprite).append("</combatSprite>")
    
    sb.append("<drops>")
    
    drops.foreach {
      drop =>
        sb.append("<ItemDropDef>")
        sb.append("<id>").append(drop.id).append("</id>")
        sb.append("<amount>").append(drop.amount).append("</amount>")
        sb.append("<weight>").append(drop.weight).append("</weight>")
        sb.append("</ItemDropDef>")
    }
    sb.append("</drops>")
    sb.append("</NPCDef>")
    
    sb.toString
  }
}