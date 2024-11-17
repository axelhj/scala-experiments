// object Main extends App {
//   println("Hello, World!")
//   Other.da_func()
//   BlazeServerBuilder[IO]()
//     .port(8080)
//     .addEndpoint(countCharacters)
//     .startAndWait()
// }

import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.HttpRoutes
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.server.Router
import sttp.tapir.*
import sttp.tapir.server.http4s.Http4sServerInterpreter

// Normally provided by IOApp:
// implicit val cs: ContextShift[IO] = IO.contextShift(global)
// implicit val timer: Timer[IO] = IO.timer(global)

// To run the app without the cats effect IOApp
// val serverBuilder = BlazeServerBuilder[IO](global).bindHttp(8080, "localhost").withHttpApp(httpApp)
// val fiber = serverBuilder.resource.use(_ => IO.never).start.unsafeRunSync()

object HelloWorldTapir extends IOApp:
  override def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO]
      .bindHttp(8080, "localhost")
      .withHttpApp(Router("/" -> countCharactersRoutes).orNotFound)
      .resource
      .use(_ => IO.never)
      .as(ExitCode.Success)
