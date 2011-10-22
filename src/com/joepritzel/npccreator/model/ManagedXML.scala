package com.joepritzel.npccreator.model
import scala.xml.{ XML, Elem }

class ManagedXML(var xml : Elem) {
	def append(root : String, o : Any) = {
		XML.loadString("<" + root + ">" + (xml.head.child :+ XML.loadString(o.toString)).mkString("") + "\n</" + root + ">")
	}
}