resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

resolvers += Resolver.url("bintray-sbt-plugin-releases", url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

addSbtPlugin("me.lessis" % "bintray-sbt" % "0.1.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.6.4")

addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "0.99.11")

addSbtPlugin("org.scoverage" %% "sbt-coveralls" % "0.99.0")
