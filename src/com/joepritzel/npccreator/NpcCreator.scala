package com.joepritzel.npccreator
import scala.xml.XML
import com.joepritzel.npccreator.model.{ NPCDef, ItemDropDef }
import com.joepritzel.npccreator.util.{ Config, CompressionUtil }
import com.joepritzel.npccreator.model.ManagedXML

object NpcCreator {

	def main(args : Array[String]) {
		var xml = new ManagedXML(CompressionUtil.getXMLFromGZIP(Config.DATA_FOLDER + Config.SERVER + Config.DEFS + "NPCDef.xml.gz"))
		test(xml)
		CompressionUtil.saveXML(
			Config.OUTPUT_FOLDER + Config.SERVER + Config.DEFS + "NPCDef.xml.gz",
			xml.format
		)
	}

	def test(xml : ManagedXML) {
		xml.append(
			"NPCDef-array",
			new NPCDef("Random", "desc", "", Array(15, 15, 12, 12),
				false, false, 30,
				Array(6, 1, 2, -1, -1, -1, 82, 88, -1, -1, -1, -1),
				Array(1, 2, 3, 15523536), 145, 220, 6, 6, 5,
				Array(new ItemDropDef(20, 1, 0))
			)
		)
	}
}
