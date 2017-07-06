package com.innobraves.kairosjava.clients;

import com.innobraves.kairosjava.models.requests.*;
import com.innobraves.kairosjava.models.results.*;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public interface Recognition {
    DetectResult detect(DetectRequest detectRequest);
    EnrollResult enroll(EnrollRequest enrollRequest);
    GalleryListAllResult galleryListAll(GalleryListAllRequest galleryListAllRequest);
    GalleryRemoveResult galleryRemove(GalleryRemoveRequest galleryRemoveRequest);
    GalleryRemoveSubjectResult galleryRemoveSubject(GalleryRemoveSubjectRequest galleryRemoveSubjectRequest);
    GalleryViewResult galleryView(GalleryViewRequest galleryViewRequest);
    GalleryViewSubjectResult galleryViewSubject(GalleryViewSubjectRequest galleryViewSubjectRequest);
    RecognizeResult recognize(RecognizeRequest recognizeRequest);
    VerifyResult verify(VerifyRequest verifyRequest);

}
