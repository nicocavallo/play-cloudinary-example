package controllers

import cloudinary.model.CloudinaryResource
import com.cloudinary.parameters.UploadParameters
import play.api._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def upload = Action.async(parse.multipartFormData) { implicit request =>
    val imageUrlFuture = request.body.file("picture").fold(Future.successful("No Image uploaded")) { picture =>
      CloudinaryResource.upload(picture.ref.file,UploadParameters(Map())).map( i => i.url())
    }

    imageUrlFuture map { imageUrl =>
      Ok(views.html.image(imageUrl))
    } recover {
      case e:Throwable => InternalServerError(e.getMessage())
    }



  }

}