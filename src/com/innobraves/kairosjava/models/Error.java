package com.innobraves.kairosjava.models;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public enum Error {
    ERR_9000(
            900,
            0,
            "Exception occurred",
            "Some Issue occurred within your JVM instance"
    ),
    ERR_1000(
            1000,
            200,
            "invalid characters found in parameters",
            "Check that you do not have any special characters in your subject IDs and gallery names"
    ),
    ERR_1001(
            1001,
            200,
            "invalid content type header was sent",
            "We did not find an HTTP header set to \"content-type\" - \"application/json\""
    ),
    ERR_1002(
            1002,
            200,
            "required parameter missing",
            "Check www.kairos.com/docs to make sure you are passing all the required parameters for your API call"
    ),
    ERR_1003(
            1003,
            200,
            "an invalid parameter was sent",
            "We found an invalid parameter in your request. Check www.kairos.com/docs to make sure you are passing all the correct parameters for your API call."
    ),
    ERR_1004(
            1004,
            200,
            "remote url or file name is too long",
            "The filename or URL was too long, please submit a shorter URL or filename."
    ),
    ERR_3000(
            3000,
            429,
            "you've exceeded the number of request you can send",
            "You have exceeded the number of API requests for the rate plan you are subscribed to. Check out our other plans at www.kairos.com/pricing."
    ),
    ERR_3001(
            3001,
            502,
            "API temporarily unavailable",
            "There has been a temporary issue with the API and we are unable to process your request. Please try your request again later."
    ),
    ERR_3002(
            3002,
            404,
            "an invalid endpoint was used",
            "Check the request URL to make sure it is one of the valid URLs we accept."
    ),
    ERR_3003(
            3003,
            403,
            "invalid authentication parameters",
            "The app_id or app_key were not valid."
    ),
    ERR_5000(
            5000,
            200,
            "an invalid image was sent must be jpg or png format",
            "We only accept images in JPG and PNG format currently."
    ),
    ERR_5001(
            5001,
            200,
            "an invalid image URL was sent",
            "We had an issue retrieving your image from the URL that was specified"
    ),
    ERR_5002(
            5002,
            200,
            "no faces found in the image",
            "We weren't able to find any face in the image that was sent."
    ),
    ERR_5003(
            5003,
            200,
            "subject ID was not found",
            "The subject ID you specified was not found in the gallery"
    ),
    ERR_5004(
            5004,
            200,
            "gallery name not found",
            "The gallery name you specified was not found in our system"
    ),
    ERR_5005(
            5005,
            200,
            "face that was detected is corrupt and cannot be processed",
            "Sometimes we detect what looks like a face in an image, but upon further inspection we discover it isn't a real face."
    ),
    ERR_5010(
            5010,
            200,
            "too many faces in image",
            "When processing a verify request an image with multiple faces was sent."
    ),
    ERR_5011(
            5011,
            200,
            "enterprise only feature",
            "A request was made that is only available when on a paid Enterprise level plan."
    ),
    ERR_5012(
            5012,
            200,
            "no match found",
            "A candidate match was not found in the gallery"
    );

    private int httpCode;
    private int errorCode;
    private String message;
    private String description;

    Error(int errorCode, int httpCode, String message, String description){
        this.errorCode = errorCode;
        this.httpCode = httpCode;
        this.message = message;
        this.description = description;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Error{\n" +
                "httpCode:\t" + httpCode + "\n" +
                "errorCode:\t" + errorCode + "\n" +
                "message:\t'" + message + '\'' + "\n" +
                "description:\t'" + description + '\'' + "\n" +
                '}';
    }

    public static Error getByErrCode(int errCode){
        for(Error e : Error.values()){
            if(e.errorCode == errCode)return e;
        }
        return null;
    }

    public static Error getByHttpCode(int httpCode){
        for(Error e : Error.values()){
            if(e.httpCode == httpCode)return e;
        }
        return null;
    }
}
