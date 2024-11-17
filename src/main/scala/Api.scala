import org.http4s.HttpRoutes
import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.HttpRoutes
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.server.Router
import sttp.tapir.*
import sttp.tapir.server.http4s.Http4sServerInterpreter

def countCharacters(s: String): IO[Either[Unit, Int]] = 
  IO.pure(Right[Unit, Int](s.length))

val countCharactersEndpoint: PublicEndpoint[String, Unit, Int, Any] = 
  endpoint
    .in(stringBody)
    .out(plainBody[Int])
    // .serverLogic[IO](name => IO
    //   .println(s"Saying hello to: $name")
    //   .flatMap(_ => IO.pure(Right(s"Hello, $name!"))))

val countCharactersRoutes: HttpRoutes[IO] = 
  Http4sServerInterpreter[IO]()
    .toRoutes(countCharactersEndpoint.serverLogic(countCharacters))
