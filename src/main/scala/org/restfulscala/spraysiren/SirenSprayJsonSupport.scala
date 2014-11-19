package org.restfulscala.spraysiren

import com.yetu.siren.json.sprayjson.SirenJsonFormat
import com.yetu.siren.model.Entity.RootEntity
import spray.httpx.marshalling.Marshaller
import spray.json.DefaultJsonProtocol

trait SirenSprayJsonSupport extends SirenJsonFormat with DefaultJsonProtocol {

  import spray.json._

  implicit def sirenSprayJsonMarshaller(implicit printer: JsonPrinter = PrettyPrinter) =
    Marshaller.delegate[RootEntity, String](`application/vnd.siren+json`) { siren =>
      printer(siren.toJson)
    }

}

object SirenSprayJsonSupport extends SirenSprayJsonSupport
