package com.innobraves.kairosjava.clients;

import com.innobraves.kairosjava.models.requests.EnrollRequest;
import com.innobraves.kairosjava.models.results.EnrollResult;

/**
 * @author Hex-3-En
 * @version 0.0.1
 */
public interface Recognition {
    EnrollResult enroll(EnrollRequest enrollRequest);
}
