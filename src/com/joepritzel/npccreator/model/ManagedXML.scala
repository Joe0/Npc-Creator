package com.joepritzel.npccreator.model
import scala.xml.{ XML, Elem }
import scala.xml.PrettyPrinter

class ManagedXML(var xml : Elem) {
	def append(root : String, o : Any) = {
		xml = XML.loadString(
			"<" + root + ">" +
				(xml.head.child :+ XML.loadString(o.toString)).mkString("")
				+ "</" + root + ">")
		this
	}

	def format = {
		new PrettyPrinter(80, 2).formatNodes(xml)
	}
}