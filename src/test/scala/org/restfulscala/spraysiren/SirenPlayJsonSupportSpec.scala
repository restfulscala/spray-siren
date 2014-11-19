package org.restfulscala.spraysiren

class SirenPlayJsonSupportSpec extends SirenSupportSpec {

  override def sirenSupportTypeName: String = "SirenPlayJsonSupport"
  override implicit def sirenRootEntityMarshaller = SirenPlayJsonSupport.sirenPlayJsonMarshaller

}
