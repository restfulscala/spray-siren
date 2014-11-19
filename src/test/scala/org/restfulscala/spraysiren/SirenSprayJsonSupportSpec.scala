package org.restfulscala.spraysiren

class SirenSprayJsonSupportSpec extends SirenSupportSpec   {

  import spray.json.CompactPrinter
  implicit val printer = CompactPrinter
  override implicit def sirenRootEntityMarshaller = SirenSprayJsonSupport.sirenSprayJsonMarshaller
  override def sirenSupportTypeName: String = "SirenSprayJsonSupport"

}
