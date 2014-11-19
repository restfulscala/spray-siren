package org.restfulscala

import com.yetu.siren.{Siren, SirenRootEntityWriter}
import com.yetu.siren.model.Entity.RootEntity
import spray.httpx.marshalling.Marshaller

package object spraysiren {

  import spray.http.{MediaType, MediaTypes}

  /**
   * The Siren JSON media type.
   */
  val sirenJsonMediaType = "application/vnd.siren+json"

  /**
   * The Siren JSON media type as a [[spray.http.MediaType]].
   */
  val `application/vnd.siren+json` = MediaTypes.register(MediaType.custom(sirenJsonMediaType))

  implicit def sirenJsonConvertableMarshaller[T : SirenRootEntityWriter](implicit m: Marshaller[RootEntity]) =
    Marshaller.delegate[T, RootEntity](`application/vnd.siren+json`)(Siren.asRootEntity(_))
}
