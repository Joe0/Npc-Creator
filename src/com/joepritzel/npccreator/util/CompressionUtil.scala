package com.joepritzel.npccreator.util
import java.io.{FileOutputStream, FileInputStream, File}
import java.util.zip.{GZIPOutputStream, GZIPInputStream}

import scala.xml.XML

object CompressionUtil {
	def getXMLFromGZIP(file : String) = {
	  val rootZip = new GZIPInputStream(new FileInputStream(new File(file)))
	  XML.load(rootZip)
	}
	
	private def getGZIPOutputStream(file: String) = {
	  new GZIPOutputStream(new FileOutputStream(new File(file)))
	}
	
	def saveXML(file : String, xml : String) = {
	  val output = getGZIPOutputStream(file)
	  
	  output.write(xml.getBytes)
	  
	  output.close
	}
}