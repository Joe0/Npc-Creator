package com.joepritzel.npccreator.util
import java.io.{ FileOutputStream, FileInputStream, File }
import java.util.zip.{ GZIPOutputStream, GZIPInputStream }
import scala.xml.XML
import java.util.zip.Deflater

object CompressionUtil {

	def getXMLFromGZIP(file : String) = {
		val rootZip = new GZIPInputStream(new FileInputStream(new File(file)))
		val temp = XML.load(rootZip)
		rootZip.close
		temp
	}

	private def getGZIPOutputStream(file : String) = {
		val f = new File(file)
		if (!f.exists) {
			f.mkdirs // Create folders
			f.delete // Delete the folder created by mkdirs
			f.createNewFile // Create the file
		}
		new GZIPOutputStream(new FileOutputStream(f)) {
			// Attempt to change compression to best.
			try {
				this.getClass.getSuperclass.getSuperclass.getDeclaredField("def").get(this)
					.asInstanceOf[Deflater].setLevel(Deflater.BEST_COMPRESSION)
			} catch {
				case _ => println("Failed to change compression level to best.")
			}
		}
	}

	def saveXML(file : String, xml : String) = {
		val output = getGZIPOutputStream(file)

		output.write(xml.getBytes)

		output.close
	}
}