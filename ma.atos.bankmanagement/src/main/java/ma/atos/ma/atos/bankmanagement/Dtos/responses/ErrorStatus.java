package ma.atos.ma.atos.bankmanagement.Dtos.responses;


// Enum for error status
public enum ErrorStatus {
    TECHNICAL_ERROR(500, "Technical error"),
    BAD_REQUEST(400, "Bad request"),
    NOT_FOUND(404, "Not found"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    CONFLICT(409, "Conflict"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable entity"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int code;
    private final String description;

    ErrorStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String description() {
        return description;
    }

}
