package com.rare_earth_track.portal.service;

import javax.servlet.http.HttpServletResponse;

/**
 * The interface Ret file service.
 *
 * @author hhoa
 * @date 2022 /7/14
 */
public interface RetFileService {
    /**
     * Download.
     *
     * @param filesUUID the files uuid
     * @param response  the response
     */
    void download(String filesUUID, HttpServletResponse response);
}
