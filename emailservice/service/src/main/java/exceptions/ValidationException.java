package exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by mcboman on 15/10/2016.
 */
@Provider
public class ValidationException implements ExceptionMapper{

    @Override
    public Response toResponse(Throwable throwable) {
        if(throwable instanceof ConstraintViolationException){
            final StringBuilder stringBuilder = new StringBuilder();
            for(ConstraintViolation<?> cv : ((ConstraintViolationException) throwable).getConstraintViolations()){
                stringBuilder.append(cv.getPropertyPath().toString() + " " + cv.getMessage());
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).type(MediaType.APPLICATION_JSON)
                    .entity(stringBuilder.toString()).build();
        }
        return Response.serverError().entity(throwable.getMessage()).build();
    }
}
