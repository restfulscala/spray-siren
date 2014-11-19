package org.restfulscala.spraysiren

import com.yetu.siren.json.playjson.PlayJsonSirenFormat
import spray.httpx.PlayJsonSupport

trait SirenPlayJsonSupport extends PlayJsonSirenFormat with PlayJsonSupport {

  import com.yetu.siren.model.Entity.RootEntity
  import play.api.libs.json.{JsValue, Json}
  import spray.httpx.marshalling.Marshaller

  implicit val sirenPlayJsonMarshaller =
    Marshaller.delegate[RootEntity, JsValue](`application/vnd.siren+json`)(Json.toJson(_))

}

object SirenPlayJsonSupport extends SirenPlayJsonSupport
