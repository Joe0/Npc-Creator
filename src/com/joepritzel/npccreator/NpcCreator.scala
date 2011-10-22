package com.joepritzel.npccreator
import scala.xml.XML

import com.joepritzel.npccreator.model.{NPCDef, ItemDropDef}
import com.joepritzel.npccreator.util.{Config, CompressionUtil}

object NpcCreator {

  def main(args: Array[String]): Unit = {
    var xml = CompressionUtil.getXMLFromGZIP(Config.DATA_FOLDER + Config.SERVER + Config.DEFS + "NPCDef.xml.gz")
    val v = (xml \\ "NPCDef-array").head.child :+ XML.loadString(new NPCDef("Random", "desc", "", Array(15, 15, 12, 12), false, false, 30, Array(6, 1, 2, -1, -1, -1, 82, 88, -1, -1, -1, -1), Array(1, 2, 3, 15523536), 145, 220, 6, 6, 5, Array(new ItemDropDef(20, 1, 0))).toString)
    CompressionUtil.saveXML(Config.DATA_FOLDER + Config.SERVER + Config.DEFS + "NPCDef-NEW.xml.gz", v.mkString(""))
  }
}
