package com.innobraves.kairosjava.clients;

import com.innobraves.kairosjava.models.requests.*;
import com.innobraves.kairosjava.models.results.*;

/**
 * Interface containing any request a recognition client has to handle
 * @author P. Willnow
 * @version 0.0.1
 */
public interface Recognition {
    /**
     * Takes a photo and returns the facial features it finds.
     * @param detectRequest DetectRequest
     * @return Result of the Detect operation returned by the service.
     */
    DetectResult detect(DetectRequest detectRequest);

    /**
     * Takes a photo, finds the faces within it, and stores the faces into a gallery you create.
     * @param enrollRequest EnrollRequest
     * @return Result of the Enroll operation returned by the service.
     */
    EnrollResult enroll(EnrollRequest enrollRequest);

    /**
     * Lists out all of the galleries you have created.
     * @param galleryListAllRequest GalleryListAllRequest
     * @return Result of the GalleryListAll operation returned by the service.
     */
    GalleryListAllResult galleryListAll(GalleryListAllRequest galleryListAllRequest);

    /**
     * Removes a gallery and all of its subjects.
     * @param galleryRemoveRequest GalleryRemoveRequest
     * @return Result of the GalleryRemove operation returned by the service.
     */
    GalleryRemoveResult galleryRemove(GalleryRemoveRequest galleryRemoveRequest);

    /**
     * Removes a face you have enrolled within a gallery.
     * @param galleryRemoveSubjectRequest GalleryRemoveSubjectRequest
     * @return Result of the GalleryRemoveSubject operation returned by the service.
     */
    GalleryRemoveSubjectResult galleryRemoveSubject(GalleryRemoveSubjectRequest galleryRemoveSubjectRequest);

    /**
     * Lists out all of the faces you have enrolled in a gallery.
     * @param galleryViewRequest GalleryViewRequest
     * @return Result of the GalleryView operation returned by the service.
     */
    GalleryViewResult galleryView(GalleryViewRequest galleryViewRequest);

    /**
     * Displays all face_id's and enrollment timestamps for each template you have enrolled from a given gallery_name and subject_id.
     * @param galleryViewSubjectRequest GalleryViewSubjectRequest
     * @return Result of the GalleryViewSubject operation returned by the service.
     */
    GalleryViewSubjectResult galleryViewSubject(GalleryViewSubjectRequest galleryViewSubjectRequest);

    /**
     * Takes a photo, finds the faces within it, and tries to match them against the faces you have already enrolled into a gallery.
     * @param recognizeRequest RecognizeRequest
     * @return Result of the Recognize operation returned by the service.
     */
    RecognizeResult recognize(RecognizeRequest recognizeRequest);

    /**
     * Takes a photo, finds the face within it, and tries to compare it against a face you have already enrolled into a gallery.
     * @param verifyRequest VerifyRequest
     * @return Result of the Verify operation returned by the service.
     */
    VerifyResult verify(VerifyRequest verifyRequest);
}
