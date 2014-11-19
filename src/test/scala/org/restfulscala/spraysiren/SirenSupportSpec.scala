package org.restfulscala.spraysiren

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.{EitherValues, WordSpec}

abstract class SirenSupportSpec extends WordSpec with TypeCheckedTripleEquals with EitherValues {

  import com.yetu.siren.SirenRootEntityWriter
  import com.yetu.siren.model.Entity.RootEntity
  import spray.httpx.marshalling._

  def sirenSupportTypeName: String
  implicit def sirenRootEntityMarshaller: Marshaller[RootEntity]

  sirenSupportTypeName must {
    "allow marshalling a Siren root entity with the correct content type" in {
      val rootEntity = RootEntity(classes = Some(List("order")))
      assert(marshal(rootEntity).right.value.toString ===
        """HttpEntity(application/vnd.siren+json; charset=UTF-8,{"class":["order"]})""")
    }
    "allow marshalling a value of a type that can be converted to a Siren root entity" in {
      case class Foo(bar: String)
      implicit val fooWriter = new SirenRootEntityWriter[Foo] {
        override def toSiren(a: Foo) = RootEntity(classes = Some(List("foo")))
      }
      assert(marshal(Foo("bar")).right.value.toString ===
        """HttpEntity(application/vnd.siren+json; charset=UTF-8,{"class":["foo"]})""")
    }
  }


}
